package com.pivovarit.movies.infrastructure;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestControllerEndpoint(id = "custom-actuator")
class CustomActuatorEndpoint {

    @GetMapping("/foo")
    String getFilms() {
        return "bar";
    }
}

// docker run --name movies-psql --publish 5432:5432 -e POSTGRES_PASSWORD=user123 -d postgres:9.5

