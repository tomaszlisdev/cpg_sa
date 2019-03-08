package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieFasadeTest {
    @Mock
    private MovieCreator creator;

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieFacade facade;

    @Test
    public void findAllMoviesShouldInvokeRepositoryAndReturnFilms(){
        List<Movie> moviesInRepository = new ArrayList<>();
        Movie movie = new Movie(new MovieId("1"), "Test Movie", MovieType.NEW, Year.of(2018));
        moviesInRepository.add(movie);
        when(repository.findAll()).thenReturn(moviesInRepository);

        Collection<MovieDto> movies = facade.findAll();

        verify(repository, atLeastOnce()).findAll();
        assertNotNull(movies);
        assertTrue(movies.size()>0);
        assertThat(movies, everyItem(hasProperty("title", is(movie.getTitle()))));
        assertThat(movies, everyItem(hasProperty("id", is(movie.getId().getId()))));
        assertThat(movies, everyItem(hasProperty("type", hasProperty("movieType",is(movie.getType().toString())))));
    }

    @Test
    public void findByTitleShouldInvokeRepositoryAndReturnAppropriateFilm(){
        Movie movie = new Movie(new MovieId("1"), "Test Movie", MovieType.NEW, Year.of(2018));
        when(repository.findByTitle("Test Movie")).thenReturn(Optional.of(movie));

        MovieDto movieDto = facade.findByTitle("Test Movie");

        verify(repository, atLeastOnce()).findByTitle(any());
        assertNotNull(movieDto);
        assertThat(movieDto, hasProperty("title", is(movie.getTitle())));
        assertThat(movieDto, hasProperty("id", is(movie.getId().getId())));
        assertThat(movieDto, hasProperty("type", hasProperty("movieType",is(movie.getType().toString()))));
    }

    @Test
    public void addMovieMustInvokeRepositoryAndReturnId(){
        MovieDto movieDto = new MovieDto("1", "Test Movie", new MovieTypeDto(MovieType.NEW.toString()),2018, "");
        when(creator.from(movieDto)).thenCallRealMethod();
        when(repository.save(any())).thenReturn(new MovieId("1"));

        MovieId movieId =  facade.add(movieDto);

        verify(repository, atLeastOnce()).save(any());
        verify(creator, atLeastOnce()).from(movieDto);
        assertNotNull(movieId);
        assertEquals(movieDto.getId(), movieId.getId());
    }
}
