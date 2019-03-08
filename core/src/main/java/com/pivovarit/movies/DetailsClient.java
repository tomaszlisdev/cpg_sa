package com.pivovarit.movies;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class DetailsClient {
    RestTemplate restTemplate = new RestTemplate();
    private final DiscoveryClient discoveryClient;


    public String getDetails(String id){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8085/details/"+id,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        } else {
            return "No details for "+id;
        }
    }
}
