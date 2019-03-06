package com.pivovarit.movies.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MoviesConfiguration {

    @Bean
    static MovieFacade inMemoryMovieFacade() {
        return MovieFacade.inMemoryMovieFacade();
    }

    @Bean
    MovieFacade movieFacade(
        MovieRepository movieRepository,
        @Value("${movies.price.new}") Long priceNew,
        @Value("${movies.price.old}") Long priceOld,
        @Value("${movies.price.regular}") Long priceRegular) {
        return new MovieFacade(movieRepository, new MovieCreator(), new StaticMoviePriceCalculator(priceNew, priceOld, priceRegular));
    }

    @Bean
    MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }
}
