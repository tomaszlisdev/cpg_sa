package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import lombok.RequiredArgsConstructor;

import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieFacade {

    private final MovieRepository filmRepository;
    private final MovieCreator movieCreator;
    private final MoviePriceCalculator moviePriceCalculator;

    public static MovieFacade inMemoryMovieFacade() {
        return new MovieFacade(new InMemoryMovieRepository(), new MovieCreator(), new StaticMoviePriceCalculator(42, 42, 42));
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
        return new MovieDto(movie.getId().getId(), movie.getTitle(), new MovieTypeDto(movie.getType().name()), movie.getYear().get(ChronoField.YEAR));
    }

    public List<MovieDto> findAll() {
        return filmRepository.findAll().stream()
            .map(m -> new MovieDto(m.getId().getId(), m.getTitle(), new MovieTypeDto(m.getType().name()), m.getYear().get(ChronoField.YEAR)))
            .collect(Collectors.toList());
    }
}
