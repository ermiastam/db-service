
             node() {

                     stage('Build') {

                             echo 'Building..'
                         withMaven(maven:'M3') {
                             sh "mvn clean install"
                         }


                     }
                     stage('Test') {

                             echo 'Testing..'

                     }
                     stage('Deploy') {

                             echo 'Deploying....'

                     }

             }