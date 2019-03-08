package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/movie-details/idkfa78'
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body("When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family.")
        headers {
            header('Content-Type': 'application/json')
        }
    }
}