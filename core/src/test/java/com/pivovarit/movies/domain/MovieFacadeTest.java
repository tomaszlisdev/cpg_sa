package com.pivovarit.movies.domain;

import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieFacadeTest {

    private MovieFacade movieFacade;

    @BeforeEach
    void setup() {
        movieFacade = MovieFacade.inMemoryMovieFacade();
    }

    @Test
    void shouldAddMovie() {
        // given
        String title = "foo";
        MovieDto dto = new MovieDto(42l, title, new MovieTypeDto("NEW"));

        // when
        movieFacade.add(dto);

        // then
        MovieDto result = movieFacade.findByTitle(title);
        assertThat(result).isEqualTo(dto);
    }

    @Test
    void shouldAddMovie2() {
        // given
        String title = "foo";
        MovieDto dto = new MovieDto(42l, title, new MovieTypeDto("NEW"));

        // when
        movieFacade.add(dto);

        // then
        MovieDto result = movieFacade.findByTitle(title);
        assertThat(result).isEqualTo(dto);
    }

    @Test
    void shouldAddMovie3() {
        // given
        String title = "foo";
        MovieDto dto = new MovieDto(42l, title, new MovieTypeDto("NEW"));

        // when
        movieFacade.add(dto);

        // then
        MovieDto result = movieFacade.findByTitle(title);
        assertThat(result).isEqualTo(dto);
    }


}
