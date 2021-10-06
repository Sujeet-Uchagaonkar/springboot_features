pipeline {
    agent {
      label "Built-In Node"
    }

    stages {
        stage('projectbBuild') {
            steps {
                echo 'Building Application......'
                
                // Get some code from a GitHub repository
                // git 'https://github.com/Sujeet-Uchagaonkar/springboot_features.git'
                
                
                sh "clean build"
                //bat "gradle clean build"
            }
        }
    }
}






