package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import org.springframework.stereotype.Component;

class MovieCreator {
    Movie from(MovieDto filmDto) {
        return new Movie(new MovieId(filmDto.getId()), filmDto.getTitle(), MovieType.valueOf(filmDto.getType().getMovieType()));
    }
}
