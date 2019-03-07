package com.pivovarit.movies.domain;


import lombok.Value;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Value
public class MovieJpaRepository implements MovieRepository{
    private final MovieAutogeneratedRepository crudRepository;

    @Override
    public MovieId save(Movie movie) {
        return MovieMapper.INSTANCE.map(crudRepository.save(MovieMapper.INSTANCE.map(movie))).getId();
    }

    @Override
    public Collection<Movie> findAll() {
        return crudRepository.findAll().stream().map(MovieMapper.INSTANCE::map).collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return crudRepository.findByTitle(title).map(MovieMapper.INSTANCE::map);
    }
}