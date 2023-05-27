// vars/dockerBuildAndPushImage.groovy

def call(Map config) {
  def dockerfileDir = config.dockerfileDir
  def imageName = config.imageName
  def imageTag = config.imageTag
  def dockerHubCredentialsId = config.dockerHubCredentialsId

  // Build Docker image
  sh "docker build -t ${imageName}:${imageTag} ${dockerfileDir}"

  // Log in to Docker Hub
  withDockerRegistry(credentialsId: dockerHubCredentialsId, url: '') {
    // Push Docker image to Docker Hub
    sh "docker push ${imageName}:${imageTag}"
  }
}
