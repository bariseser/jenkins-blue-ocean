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
        }
        failure {
            sh 'echo Failure'
        }
      }
      steps {
        sh 'echo Success'
      }
    }
  }
  post {
    always {
      junit 'build/test-results/**/TEST-*.xml'
    }
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '7'))
  }
}