package com.pivovarit.movies.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MoviesConfiguration {

    @Bean
    static MovieFacade inMemoryMovieFacade() {
        return MovieFacade.inMemoryMovieFacade();
    }

    @Bean
    MovieFacade movieFacade(MovieRepository movieRepository) {
        return new MovieFacade(movieRepository, new MovieCreator());
    }

    @Bean
    MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }
}
