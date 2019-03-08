package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieCreatorTest {

    @Test
    public void movieCreatorMustRewriteDtoToEntity(){
        MovieCreator creator = new MovieCreator();
        MovieDto movieDto = new MovieDto("1", "Test Movie", new MovieTypeDto(MovieType.NEW.toString()), 2017, "");

        Movie movie = creator.from(movieDto);

        assertNotNull(movie);
        assertNotNull(movie.getId());
        assertNotNull(movieDto.getId());
        assertEquals(movieDto.getId(), movie.getId().getId());
        assertEquals(movieDto.getTitle(), movie.getTitle());
        assertNotNull(movieDto.getType());
        assertEquals(movieDto.getType().getMovieType(), movie.getType().toString());
    }
}
