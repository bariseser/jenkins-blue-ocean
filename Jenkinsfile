pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh './gradlew clean build -x check -x test'
      }
    }
    stage('static-analysis') {
      parallel {
        stage('check') {
          steps {
            sh './gradlew check'
          }
        }
        stage('sonarqube') {
          steps {
            sh 'echo TBD'
          }
        }
      }
    }
    stage('test') {
      steps {
        sh './gradlew test'
      }
    }
    stage('deploy') {
      when {
        branch 'master'
      }
      post {
        success {
            sh 'echo Success'
            //office365ConnectorSend message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful", status: 'Success'
        }
        failure {
            sh 'echo Failure'
            //office365ConnectorSend message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful", status: 'Success'
        }
      }
    }
  }
  post {
    always {
      junit 'build/test-results/**/TEST-*.xml'
      recordIssues enabledForFailure: true, tool: checkStyle(pattern: '**/build/reports/checkstyle/*.xml')
      recordIssues enabledForFailure: true, tool: findBugs(pattern: '**/build/reports/findbugs/*.xml')
      recordIssues enabledForFailure: true, tool: pmd(pattern: '**/build/reports/pmd/*.xml')
      recordIssues enabledForFailure: true, tool: cpd(pattern: '**/build/reports/cpd/*.xml')
    }
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '7'))
  }
}