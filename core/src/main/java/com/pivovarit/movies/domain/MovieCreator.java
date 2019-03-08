package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;

import java.time.Year;

class MovieCreator {
    Movie from(MovieDto filmDto) {
        return new Movie(new MovieId(filmDto.getId()), filmDto.getTitle(), MovieType
            .valueOf(filmDto.getType().getMovieType()), Year.of(filmDto.getYear()));
    }
}
