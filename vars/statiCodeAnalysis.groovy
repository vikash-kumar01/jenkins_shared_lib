def call(){
    sh 'mvn clean package sonar:sonar'
}