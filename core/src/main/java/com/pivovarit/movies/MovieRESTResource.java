package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import com.pivovarit.movies.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Lazy
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

    @DeleteMapping("/movies/id/{id}")
    void delete(@PathVariable("id") String id){
        movieFacade.deleteById(id);
    }

    @GetMapping("/movies/type/{type}")
    Collection<MovieDto> searchByType(@PathVariable("type") String type){
        return movieFacade.findAllByType(type);
    }

    @GetMapping("/movies/year/{year}")
    Collection<MovieDto> searchByYear(@PathVariable("year") int year){
        return movieFacade.findAllByYear(year);
    }

    @GetMapping("/movies/id/{id}")
    MovieDto findById(@PathVariable("id") String id){
        return movieFacade.findById(id);
    }

    @GetMapping("/movies/search")
    Collection<MovieDto> findByParameters(@RequestParam Map<String,String> queryParams){
        if(queryParams.containsKey("yearTo")){
            if(!queryParams.containsKey("yearFrom")) {
                return movieFacade.findMovieToYear(Integer.valueOf(queryParams.get("yearTo")));
            } else {
                return movieFacade.findMoviesBetweenYears(Integer.valueOf(queryParams.get("yearFrom")), Integer.valueOf(queryParams.get("yearTo")));
            }
        } else if(queryParams.containsKey("type")){
            return searchByType(queryParams.get("type"));
        } else if(queryParams.containsKey("title")){
            return Collections.singletonList(getFilms(queryParams.get("title")));
        }
        return Collections.EMPTY_LIST;
    }











}