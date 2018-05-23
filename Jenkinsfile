
             pipeline {
                 agent any

                 stages {
                     stage('Build') {
                         steps {
                             echo 'Building..'
                             withMaven('maven:maven_3_5_3') {
                                 sh 'mvn clean compile'
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