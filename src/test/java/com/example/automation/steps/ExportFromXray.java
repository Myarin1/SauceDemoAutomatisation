package com.example.automation.steps;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

    public class ExportFromXray {
        public static void downloadFeatureFiles(String token, String testKeys) {
            try {
                URL url = new URL("https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=" + testKeys);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", "Bearer " + token);
                conn.setRequestProperty("Content-Type", "application/json");

                InputStream inputStream = conn.getInputStream();
                FileOutputStream outputStream = new FileOutputStream("features.zip");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                System.err.println("Erreur lors du téléchargement des fichiers feature: " + e.getMessage());
            }
        }

        public static void unzip(String zipFilePath, String destDir) throws IOException {
            File dir = new File(destDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
                ZipEntry entry;

                while ((entry = zis.getNextEntry()) != null) {
                    File newFile = new File(destDir, entry.getName());

                    if (entry.isDirectory()) {
                        newFile.mkdirs();
                    } else {
                        // Crée les dossiers parents si besoin
                        new File(newFile.getParent()).mkdirs();

                        try (FileOutputStream fos = new FileOutputStream(newFile)) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = zis.read(buffer)) > 0) {
                                fos.write(buffer, 0, length);
                            }
                        }
                    }

                    zis.closeEntry();
                }
            }
        }

        @Test
        public void test() throws IOException, InterruptedException {
            downloadFeatureFiles("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6MDAzMGIzMjMtNjQ3OC00MzYxLThlZjYtNjcyZjg3NWI4YTNlIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3NzAyOTE3MDIsImV4cCI6MTc3MDM3ODEwMiwiYXVkIjoiNzJDNkI1MEYwRkU0NDY5REJGRjhFNzgwQUFBNUIzRkYiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI3MkM2QjUwRjBGRTQ0NjlEQkZGOEU3ODBBQUE1QjNGRiJ9.DZJADe4DKdGWC7-w2GNrOsftgvy-2ThNhcVf-engf-A", "POEI2-844");

            unzip("features.zip", System.getProperty("user.dir") + "\\src\\test\\resources\\features");
        }
    }

