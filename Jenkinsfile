
             pipeline {
                 agent any

                 stages {
                     stage('Build') {
                         steps {
                             echo 'Building..'
                          withMaven(M3:'maven_3_5_3') {
                              sh 'mvn -e clean compile'
                          }
                         }
                     }
                     stage('Test') {
                         steps {
                             echo 'Testing..'
                         }
                     }
                     stage('Deploy') {
                         steps {
                             echo 'Deploying....'
                         }
                     }
                 }


             }