def call(project, addr) {
    sh """helm upgrade -i \
        ${project} \
        helm/${project} \
        --namespace ${project} \
        --set image.tag=${currentBuild.displayName} \
        --set ingress.host=${addr} \
        --reuse-values"""
}
