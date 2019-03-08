package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieApplication.class)
@AutoConfigureMockMvc
public class MovieApplicationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private MovieFacade facade;

    @Test
    public void testGetAllMovies() throws Exception {
        mvc.perform(get("/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[*].title", contains("Spiderman1")))
                .andExpect(jsonPath("$[*].id", contains(1)))
                .andExpect(jsonPath("$[*].type.movieType", contains("NEW")))
        ;
    }
}
