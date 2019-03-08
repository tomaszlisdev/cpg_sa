package com.pivovarit.movies;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class MovieDetailsController {

    private final MovieDetailsRepository movieDetailsRepository;

    @GetMapping(value = "/movie-details/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails movieDetails(@PathVariable  String movieId) throws InterruptedException {
        Thread.sleep(500);

        String result = movieDetailsRepository.getDetails(movieId);

        if (result == null) {
            return new MovieDetails(null);
        }

        return new MovieDetails(result);
    }

    @Value
    static class MovieDetails {
        private final String details;
    }
}
