// def call(String project, String ImageTag, String hubUser){
    
//     sh """   
//      trivy image ${hubUser}/${project}:latest > scan.txt
//      cat scan.txt
//     """
// }

def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
    trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > scan.txt
    cat scan.txt
    """
}