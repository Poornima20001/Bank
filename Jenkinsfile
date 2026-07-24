pipeline {
    agent any
    tools{
        maven 'mvn 3.9.9'
    }
// hello
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',  url: 'https://github.com/Poornima20001/Bank.git'
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
