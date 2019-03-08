package com.pivovarit.movies.domain;

import com.pivovarit.movies.MovieDetailsClient;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

class HttpMovieDetailsClient implements MovieDetailsClient {

    private final RestTemplate restTemplate = restTemplate();

    @Override
    public MovieDetails get(String movieId) {
        RequestEntity<Void> requestEntity = RequestEntity
            .get(URI.create("http://localhost:8889/movie-details/" + movieId))
            .accept(MediaType.APPLICATION_JSON).build();

        return restTemplate.exchange(requestEntity, MovieDetails.class).getBody();
    }

    private static RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.setMessageConverters(Arrays.asList(converter, new FormHttpMessageConverter()));

        return restTemplate;
    }
}
