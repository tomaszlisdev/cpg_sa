package com.pivovarit.movies.domain;

import com.pivovarit.movies.DetailsClient;
import com.pivovarit.movies.MockMovieDetailsClient;
import com.pivovarit.movies.MovieDetailsClient;
import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Year;
import java.net.URI;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieFacade {

    private final MovieRepository filmRepository;
    private final MovieCreator movieCreator;
    private final MoviePriceCalculator moviePriceCalculator;
    private final DetailsClient detailsClient;

    public static MovieFacade inMemoryMovieFacade() {
        return new MovieFacade(new InMemoryMovieRepository(), new MovieCreator(), new StaticMoviePriceCalculator(42, 42, 42), new MockMovieDetailsClient());
    }

    public MovieId add(MovieDto filmDto) {
        return filmRepository.save(movieCreator.from(filmDto));
    }

    public Optional<Long> priceFor(MovieTypeDto type) {
        try {
            return Optional.of(moviePriceCalculator.getPrice(MovieType.valueOf(type.getMovieType())));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public MovieDto findByTitle(String movieTitle) {
        Movie movie = filmRepository.findByTitle(movieTitle).orElseThrow(IllegalStateException::new);
        return toMovieDto(movie);
    }

    public List<MovieDto> findAll() {
        return filmRepository.findAll().stream()
            .map(m -> toMovieDto(m))
            .collect(Collectors.toList());
    }

    private MovieDto toMovieDto(Movie m) {
        return new MovieDto(m.getId().getId(), m.getTitle(), new MovieTypeDto(m.getType().name()), m.getYear().get(ChronoField.YEAR), detailsClient.getDetails(m.getId().getId()));
    }

    public List<MovieDto> findAllByType(String type){
        return filmRepository.findAllByType(MovieType.valueOf(type)).stream().map(m -> toMovieDto(m)).collect(Collectors.toList());
    }

    public List<MovieDto> findAllByYear(int year){
        return filmRepository.findAllByYear(Year.of(year)).stream().map(this::toMovieDto).collect(Collectors.toList());
    }

    public MovieDto findById(String id){
        return filmRepository.findById(id).map(this::toMovieDto).orElseThrow(IllegalStateException::new);
    }

    public void deleteById(String id){
        filmRepository.deleteById(id);
    }

    public List<MovieDto> findMovieToYear(int year){
        return filmRepository.findAllBefore(year).stream().map(this::toMovieDto).collect(Collectors.toList());
    }

    public List<MovieDto> findMoviesBetweenYears(int yearFrom, int yearTo){
        return filmRepository.findByYearBetween(yearFrom, yearTo).stream().map(this::toMovieDto).collect(Collectors.toList());
    }
}