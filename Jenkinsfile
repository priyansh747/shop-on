pipeline {
    agent any
    stages {
        stage('Build'){
            steps {
                echo "Build Project"
                sh label: '', script: 'mvn clean package'
            }
        }
        stage('JAVA RUN'){
            steps{
                echo "JAVA RUN"
                sh label: '', script: 'javac ./src/test/java/com/ShopOn/TestRunner/TestRunner.java'
                sh label: '', script: 'java ./src/test/java/com/ShopOn/TestRunner/TestRunner.java'
            }
        }
    }
}
