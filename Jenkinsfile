node {
    def mvnHome = tool 'M3'
    
    stage('Checkout Code') {
        git credentialsId: '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',
            url: 'https://github.com/yaowenkhor/java-maven-calculator-web-app.git',
            branch: 'master'
    }
    
  stage('JUnit Test') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean test"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean test/)
      }
   }
   stage('Integration Test') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' integration-test"
      } else {
         bat(/"${mvnHome}\bin\mvn" integration-test/)
      }
   }
   stage('Performance Test') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' verify"
      } else {
         bat(/"${mvnHome}\bin\mvn" verify/)
      }
   }
   stage('Deploy') {
      timeout(time: 10, unit: 'MINUTES') {
           input message: 'Deploy this web app to production ?'
      }
      echo 'Deploy...'
   }
}