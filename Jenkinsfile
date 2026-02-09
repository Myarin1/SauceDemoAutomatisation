pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                // Si ton projet n'est PAS sur Git, on saute cette étape
                echo 'Projet local - pas de checkout Git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Execution des tests Cucumber via Maven...'
                dir('C:/dev/Backup_Git/SauceDemoAutomatisation') {
                    bat 'mvn clean test'
                    }

            }
        }
        stage('Export results to XRAY') {
    steps {
        echo 'Export des .json vers XRAY'

        bat '''
        curl -H "Content-Type: application/json" ^
			 -X POST ^
             -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6MDAzMGIzMjMtNjQ3OC00MzYxLThlZjYtNjcyZjg3NWI4YTNlIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3NzA2MzU2OTIsImV4cCI6MTc3MDcyMjA5MiwiYXVkIjoiNzJDNkI1MEYwRkU0NDY5REJGRjhFNzgwQUFBNUIzRkYiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI3MkM2QjUwRjBGRTQ0NjlEQkZGOEU3ODBBQUE1QjNGRiJ9.GNQNaNDURgZK0RqNFwySykJyLM_kqVs7X5n7TtZpoBs" ^
             --data @"C:/ev/BackupMisc/target/cucumber.json" ^
             https://xray.cloud.getxray.app/api/v1/import/execution/cucumber
        '''
		}
	}

	}
    post {

        success {
            echo 'Tests exécutés avec succès 🎉'
        }

        failure {
            echo 'Des tests ont échoué ❌'
        }
    }
}