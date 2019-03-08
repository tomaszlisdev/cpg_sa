package com.pivovarit.movies.domain;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

class InMemoryMovieRepository implements MovieRepository {

    private final Map<String, Movie> storage = new ConcurrentHashMap<>();

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

    @Override
    public void delete(Movie movie) {
        storage.remove(movie.getId());
    }

    @Override
    public void deleteById(String movieId) {
        storage.remove(movieId);
    }

    @Override
    public Collection<Movie> findAllByType(MovieType type) {
        return storage.values().stream()
                .filter(movie -> movie.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Movie> findAllByYear(Year year) {
        return null;
    }
}
