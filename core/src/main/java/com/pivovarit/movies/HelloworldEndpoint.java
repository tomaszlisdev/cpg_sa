package com.pivovarit.movies;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestControllerEndpoint(id = "custom-actuator")
public class HelloworldEndpoint {
    @GetMapping("hello-my-actuator")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("hello im commont actuator!");
    }
}
