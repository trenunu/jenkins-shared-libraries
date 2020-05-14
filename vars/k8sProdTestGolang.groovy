def call(address) {
    sh "go get -d -v -t"
    sh "go mod vendor"
    sh """DURATION=1 ADDRESS=${address} \
        go test ./... -v \
        --run ProductionTest"""
}
