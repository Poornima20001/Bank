pipeline {
    agent any
    tools{
        maven 'mvn 3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github_root_crentional', url: 'https://github.com/Poornima20001/sproject.git'
            }
        }
        stage('list of comment') {
            steps {
                bat 'dir'
                
            }
        }
         stage('Test') {
            steps {
                bat 'echo %PATH%'
            }
        }
stage('mvn') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
