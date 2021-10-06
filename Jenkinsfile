pipeline {
    agent any

    
    stages {
        stage('Build') {
            agent { label 'gradle' }
            steps {
                //checkout scm
                //sh "env"
                sh "gradle bootRepackage --stacktrace"
               // sh 'jarFile=`ls build/libs | grep -v original` && mkdir -p ocp/deployments && cp build/libs/$jarFile ocp/deployments/'
            }
        }
    
    
    }
    
    
    
    
}






