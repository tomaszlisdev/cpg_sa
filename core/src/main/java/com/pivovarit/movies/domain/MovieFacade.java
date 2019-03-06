package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFacade {

    private final MovieRepository filmRepository;

    private final MovieCreator movieCreator;

    @Autowired
    public MovieFacade(MovieRepository filmRepository, MovieCreator movieCreator) {
        this.filmRepository = filmRepository;
        this.movieCreator = movieCreator;

        add(new MovieDto(1L, "Spiderman1", new MovieTypeDto("NEW")));
    }

    public MovieId add(MovieDto filmDto) {
        return filmRepository.save(movieCreator.from(filmDto));
    }

    public MovieDto findByTitle(String movieTitle) {
        Movie movie = filmRepository.findByTitle(movieTitle).orElseThrow(IllegalStateException::new);
        return new MovieDto(movie.getId().getId(), movie.getTitle(), new MovieTypeDto(movie.getType().name()));
    }

    public List<MovieDto> findAll() {
        return filmRepository.findAll().stream()
          .map(m -> new MovieDto(m.getId().getId(), m.getTitle(), new MovieTypeDto(m.getType().name())))
          .collect(Collectors.toList());
    }
}
