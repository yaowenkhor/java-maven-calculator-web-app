pipeline {
   agent any

   environment {
      MVN_HOME = tool name: 'M3', type: 'maven'
   }

   stages {
      stage('Clean Workspace') {
         steps {
            deleteDir()
         }
      }

      stage('Initialize') {
         steps {
            cleanWs()
         }
      }

      stage('Checkout Code') {
         steps {
            git credentialsId: 'my-github-creds',
               url: 'https://github.com/yaowenkhor/java-maven-calculator-web-app.git',
               branch: 'master'
         }
      }

      stage('Build') {
         steps {
            script {
               if (isUnix()) {
                  sh "'${MVN_HOME}/bin/mvn' clean package -Dmaven.javadoc.skip=true"
               } else {
                  bat(/"${MVN_HOME}\bin\mvn" clean package -Dmaven.javadoc.skip=true/)
               }
            }
         }
      }

      stage('JUnit Test') {
         steps {
            script {
               if (isUnix()) {
                  sh "'${MVN_HOME}/bin/mvn' test"
               } else {
                  bat(/"${MVN_HOME}\bin\mvn" test/)
               }
            }
         }
      }

      stage('Integration Test') {
         steps {
            script {
               if (isUnix()) {
                  sh "'${MVN_HOME}/bin/mvn' integration-test -Dmaven.javadoc.skip=true"
               } else {
                  bat(/"${MVN_HOME}\bin\mvn" integration-test -Dmaven.javadoc.skip=true/)
               }
            }
         }
      }

      stage('Performance Test') {
         steps {
            script {
               if (isUnix()) {
                  sh "'${MVN_HOME}/bin/mvn' verify -Dmaven.javadoc.skip=true"
               } else {
                  bat(/"${MVN_HOME}\bin\mvn" verify -Dmaven.javadoc.skip=true/)
               }
            }
         }
      }

      stage('Deploy') {
         steps {
            timeout(time: 10, unit: 'MINUTES') {
               input message: 'Deploy this web app to production?'
            }
            echo 'Deploying application...'
         }
      }

      stage('Clean Up') {
         steps {
            script {
               if (isUnix()) {
                  sh 'docker system prune -f'
            } else {
                  bat 'docker system prune -f'
               }
            }
         }
      }
   }
}