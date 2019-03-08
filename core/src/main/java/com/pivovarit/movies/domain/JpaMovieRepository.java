package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
class JpaMovieRepository implements MovieRepository {

    private final SpringDataMovieRepository springDataMovieRepository;

    @Override
    public MovieId save(Movie movie) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return Optional.empty();
    }
}
