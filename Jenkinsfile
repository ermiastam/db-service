
             pipeline {
                 agent any
             try {
                 stages {
                     stage('Build') {
                         steps {
                             echo 'Building..'
                             withMaven(maven: 'maven_3_5_3') {
                                 sh "mvn clean compile -DskipTests"
                             }

                             currentBuild.result = "SUCCESS"
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
             }catch (e){

                 currentBuild.result = "FAILED"
             }

             }