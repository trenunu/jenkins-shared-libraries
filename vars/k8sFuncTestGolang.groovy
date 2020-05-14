def call(project, domain) {
    addr = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}.${domain}"
    sh "go get -d -v -t"
    sh "go mod vendor"
    sh """ADDRESS=${addr} \
        go test ./... -v \
        --run FunctionalTest"""
}
