pipeline {
    agent any

    stages {
        stage('projectbBuild') {
            steps {
                //container('gradle') {
                echo 'Building Application......'
                
                // Get some code from a GitHub repository
                // git 'https://github.com/Sujeet-Uchagaonkar/springboot_features.git'
                
                
                sh "clean build"
                //bat "gradle clean build"
               // }
            }
        }
    }
}






