pipeline {
    agent any
    
    tools {
       maven 'Maven 3.8.5'
    }

    triggers {
        githubPush()
    }

    environment {
        GIT_REPO = 'https://github.com/yuva-shree-a/Devops_assessment'
        DEVELOPERS_EMAIL = 'athiyuva2513@gmail.com'
        BRANCH_NAME = 'secondbranch' 
    }
 
    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH_NAME}", url: "${GIT_REPO}"
            }
        }
 
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
 
    post {
        always {
            cleanWs()
        }
 
        failure {
            script {
                 if (env.BRANCH_NAME == 'secondbranch') {
                    emailext subject: "Build failed in Jenkins: ${currentBuild.fullDisplayName}",
                             body: "Something is wrong with ${env.BRANCH_NAME} branch.\n\nCheck console output at ${env.BUILD_URL} to view the results.",
                             to: "${env.DEVELOPERS_EMAIL}"
                }
            }
        }
    }
    
}