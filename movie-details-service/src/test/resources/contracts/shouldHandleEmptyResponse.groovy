package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return empty details"
    request {
        method GET()
        url("/movie-details/notfound")
    }
    response {
        headers {
            contentType(applicationJsonUtf8())
        }
        body("""{}""")
        status OK()
    }
}