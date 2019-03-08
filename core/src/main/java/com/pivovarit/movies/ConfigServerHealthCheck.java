package com.pivovarit.movies;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ConfigServerHealthCheck implements HealthIndicator {

    @Value("${spring.cloud.config.uri}")
    private String configUri;

    @Override
    public Health health() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            if (restTemplate.getForEntity(configUri + "/rental-store/master", Void.class).getStatusCode().is2xxSuccessful()) {
                System.out.println("Service up");
                return Health.up().withDetail("Message", "Config server is up!!").build();
            }
        } catch (RestClientException e){

        }
        System.out.println("Service down");
        return Health.down().withDetail("Message", "Config server is down").build();
    }
}
