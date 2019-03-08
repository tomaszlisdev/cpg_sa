package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;

import java.time.Year;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
class JpaMovieRepository implements MovieRepository {

    private final SpringDataMovieRepository springDataMovieRepository;

    @Override
    public MovieId save(Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {
        springDataMovieRepository.delete(new HibernatePersistedMovie(movie.getId().getId(),movie.getTitle(),movie.getType().toString(),movie.getYear().getValue()));
    }

    @Override
    public void deleteById(String movieId) {
        springDataMovieRepository.deleteById(movieId);
    }

    @Override
    public Collection<Movie> findAllByType(MovieType type) {
        return springDataMovieRepository.findAllByType(type.toString()).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findById(String id) {
        return springDataMovieRepository.findById(id).map(this::toMovie);
    }

    private Movie toMovie(HibernatePersistedMovie m) {
        return Movie.builder().id(MovieId.builder().id(m.getId()).build()).type(MovieType.valueOf(m.getType())).year(Year.of(m.getYear())).build();
    }

    @Override
    public Collection<Movie> findAllByYear(Year year) {
        return springDataMovieRepository.findAllByYear(year.getValue()).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findAll() {
        return StreamSupport.stream(springDataMovieRepository.findAll().spliterator(),false).map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return springDataMovieRepository.findAllByTitle(title).map(this::toMovie);
    }

    @Override
    public Collection<Movie> findAllBefore(int year) {
        return springDataMovieRepository.findAllByYearLessThan(year).stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByYearBetween(int yearStart, int yearEnd) {
        return springDataMovieRepository.findAllByYearBetweenOrderByYearDesc(yearStart, yearEnd).stream().map(this::toMovie).collect(Collectors.toList());
    }
}
