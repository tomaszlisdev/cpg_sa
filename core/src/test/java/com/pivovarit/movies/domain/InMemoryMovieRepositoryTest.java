package com.pivovarit.movies.domain;


import com.pivovarit.movies.MovieApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MovieApplication.class})
@ComponentScan(basePackages = "com.pivovarit.movies")
public class InMemoryMovieRepositoryTest {
    @Autowired
    private MovieRepository repository;

    @Test
    public void saveMustReturnMovieId(){
        Movie movie = new Movie(new MovieId(1L), "Star Wars", MovieType.NEW, 2018);
        MovieId savedMovieId = repository.save(movie);
        assertEquals(movie.getId(), savedMovieId);
    }

    @Test
    public void savedObjectMustBeAchievableById(){
        Movie movie = new Movie(new MovieId(1L), "Star Wars", MovieType.NEW, 2018);
        repository.save(movie);
        Optional<Movie> foundMovie = repository.findByTitle("Star Wars");
        assertTrue(foundMovie.isPresent());
        assertEquals(movie, foundMovie.get());
    }

    @Test
    public void savedMovieMustBeAchievableInListOfAllMovies(){
        Movie movie = new Movie(new MovieId(1L), "Star Wars", MovieType.NEW, 2018);
        repository.save(movie);
        Collection<Movie> foundMovies = repository.findAll();
        assertNotNull(foundMovies);
        assertTrue(foundMovies.size()>0);
        assertTrue(foundMovies.contains(movie));
    }
}
