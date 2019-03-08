package com.pivovarit.movies;

import lombok.Value;

public interface MovieDetailsClient {

    MovieDetails get(String movieId);

    @Value
    class MovieDetails {
        private final String details;
    }
}
