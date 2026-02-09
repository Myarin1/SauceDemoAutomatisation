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
             -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..." ^
             -X POST ^
             --data @"target/cucumber.json" ^
             https://xray.cloud.getxray.app/api/v1/import/execution/cucumber
        '''
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
}