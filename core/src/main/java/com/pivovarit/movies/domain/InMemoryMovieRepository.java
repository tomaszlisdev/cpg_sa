package com.pivovarit.movies.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryMovieRepository implements MovieRepository {

    private final Map<Long, Movie> storage = new ConcurrentHashMap<>();

    @Override
    public MovieId save(Movie movie) {
        requireNonNull(movie);
        storage.put(movie.getId().getId(), movie);
        return movie.getId();
    }

    @Override
    public Collection<Movie> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return storage.values().stream()
            .filter(m -> m.getTitle().equals(title))
            .findAny();
    }
}
