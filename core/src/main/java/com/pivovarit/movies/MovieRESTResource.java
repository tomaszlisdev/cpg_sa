package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import com.pivovarit.movies.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MovieRESTResource {
    private final MovieFacade movieFacade;

    @GetMapping("/movies")
    Collection<MovieDto> getFilms() {
        return movieFacade.findAll();
    }

    @GetMapping("/movies/{title}")
    MovieDto getFilms(@PathVariable("title") String title) {
        return movieFacade.findByTitle(title);
    }

    @PostMapping("/movies")
    void addFilm(@RequestBody MovieDto movieDto){
         movieFacade.add(movieDto);
    }
}