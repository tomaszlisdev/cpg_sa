package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return movie details"
    request {
        method GET()
        url("/movie-details/idkfa7") {
        }
    }
    response {
        headers {
            contentType(applicationJsonUtf8())
        }
        body(
                details: $(anyNonBlankString())
        )
        status 200
    }
}