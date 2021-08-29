import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return student by id=1"

    request {
        url "/student/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(
                id: 1,
                name: "James"
        )
    }
}