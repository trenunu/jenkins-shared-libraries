def call(project, domain, extraValues = "") {
    chartName = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}"
    tagBeta = "${currentBuild.displayName}-${env.BRANCH_NAME}"
    addr = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}.${domain}"
    sh """helm upgrade -i \
        ${chartName.toLowerCase()} \
        helm/${project} \
        --set image.tag=${tagBeta} \
        --set ingress.host=${addr.toLowerCase()} \
        ${extraValues}"""
}
