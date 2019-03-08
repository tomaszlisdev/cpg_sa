package com.pivovarit.movies.domain;

import java.time.Year;
import java.util.Collection;
import java.util.Optional;

interface MovieRepository {
    MovieId save(Movie movie);
    void delete(Movie movie);
    void deleteById(String movieId);
    Collection<Movie> findAllByType(MovieType type);
    Optional<Movie> findById(String id);
    Collection<Movie> findAllByYear(Year year);

    Collection<Movie> findAll();
    Optional<Movie> findByTitle(String title);
    // TODO find all by id
    // TODO find all by type
    // TODO find all by year
    // TODO find all before year
    // TODO find all between years sorted descending
}
