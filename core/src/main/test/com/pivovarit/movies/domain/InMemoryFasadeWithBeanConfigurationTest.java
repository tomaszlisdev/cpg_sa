package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InMemoryFasadeWithBeanConfigurationTest {
    private MovieFacade movieFasade;

    @Before
    public void init(){
        movieFasade = MoviesConfiguration.inMemoryMovieFacade();
    }

    @Test
    public void addedObjectMustBeAccessible(){
        MovieDto movieDto = new MovieDto(1L, "Test Movie", new MovieTypeDto("NEW"));

        movieFasade.add(movieDto);

        assertEquals(movieDto, movieFasade.findByTitle("Test Movie"));
    }

    @Test
    public void beforeAddMovieCannotBeInMoviesList(){
        List<MovieDto> movies = movieFasade.findAll();

        MovieDto movieDto = new MovieDto(1L, "Test Movie", new MovieTypeDto("NEW"));
        movieFasade.add(movieDto);

        assertThat(movies, not(contains(movieDto)));
    }

    @Test
    public void afterAddMovieMustBeInMoviesList(){
        MovieDto movieDto = new MovieDto(1L, "Test Movie", new MovieTypeDto("NEW"));
        movieFasade.add(movieDto);

        List<MovieDto> movies = movieFasade.findAll();

        assertThat(movies, contains(movieDto));
    }
}
