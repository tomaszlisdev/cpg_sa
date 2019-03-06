package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import com.pivovarit.movies.dto.MovieDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MovieRESTResource {
    private MovieFacade movieFacade;

    MovieRESTResource(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/movies")
    Collection<MovieDto> getFilms() {
        return movieFacade.findAll();
    }
}