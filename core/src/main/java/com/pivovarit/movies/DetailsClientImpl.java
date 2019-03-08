package com.pivovarit.movies;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class DetailsClientImpl implements DetailsClient{
    RestTemplate restTemplate = new RestTemplate();
    private final DiscoveryClient discoveryClient;


    public String getDetails(String id){
        String url = discoveryClient.getInstances("MOVIE-DETAILS").stream().map(serviceInstance -> serviceInstance.getUri().toString()).findAny().orElseThrow(IllegalStateException::new);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url+"/details/"+id,String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        } else {
            return "No details for "+id;
        }
    }
}
