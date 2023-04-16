pipeline {
    agent any
    // schedule the execution every time
    triggers {cron ("* * * * *")}
    stages {
        stage('Init') {
            steps {
                echo "Testing..."
            }
        }
        stage('Run') {
            steps {
                 sh "mvn clean test"
            }
        }
    }

      post {
        always {
          step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
      }
}