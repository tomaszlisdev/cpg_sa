package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;

import java.time.Year;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
class JpaMovieRepository implements MovieRepository {

    private final SpringDataMovieRepository crudMovieRepository;
    private final MovieCreator movieCreator;

    @Override
    public MovieId save(Movie movie) {
        crudMovieRepository
            .save(new HibernatePersistedMovie(movie.getId().getId(), movie.getTitle(), movie.getType().toString(), movie
                .getYear().get(ChronoField.YEAR)));

        return movie.getId();
    }

    @Override
    public void delete(Movie movie) {
        crudMovieRepository.delete(new HibernatePersistedMovie(movie.getId().getId(),movie.getTitle(),movie.getType().toString(),movie.getYear().getValue()));
    }

    @Override
    public void deleteById(String movieId) {
        crudMovieRepository.deleteById(movieId);
    }

    @Override
    public Collection<Movie> findAllByType(MovieType type) {
        return crudMovieRepository.findAllByType(type.toString()).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findById(String id) {
        return crudMovieRepository.findById(id).map(this::toMovie);
    }

    private Movie toMovie(HibernatePersistedMovie m) {
        return Movie.builder().id(MovieId.builder().id(m.getId()).build()).type(MovieType.valueOf(m.getType())).year(Year.of(m.getYear())).build();
    }

    @Override
    public Collection<Movie> findAllByYear(Year year) {
        return crudMovieRepository.findAllByYear(year.getValue()).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findAll() {
        return StreamSupport.stream(crudMovieRepository.findAll().spliterator(),false).map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return crudMovieRepository.findAllByTitle(title).map(this::toMovie);
    }

    @Override
    public Collection<Movie> findAllBefore(int year) {
        return crudMovieRepository.findAllByYearLessThan(year).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByYearBetween(int yearStart, int yearEnd) {
        return crudMovieRepository.findAllByYearBetweenOrderByYearDesc(yearStart, yearEnd).stream().map(this::toMovie).collect(Collectors.toList());
    }
}
