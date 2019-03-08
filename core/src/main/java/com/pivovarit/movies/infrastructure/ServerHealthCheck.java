package com.pivovarit.movies.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
class ServerHealthCheck implements HealthIndicator {

    @Value("${spring.cloud.config.uri}")
    private String configServer;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Health health() {
        try {
            ResponseEntity<Void> result = restTemplate.getForEntity(configServer + "/actuator/health", Void.class);
        } catch (RestClientException e) {
            return Health.down().withException(e).build();
        }

        return Health.up().build();
    }
}
