package com.pivovarit.movies.domain;

import com.pivovarit.movies.MovieRESTResource;
import com.pivovarit.movies.dto.MovieDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Year;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
    ids = "com.pivovarit:movie-details-service:+:stubs:8889",
    stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class MovieDetailsContractTest {

    @Autowired
    private MovieRESTResource movieRESTResource;

    @Autowired
    private MovieFacade movieFacade;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void getBookById() {
        when(movieRepository.findAllById(any())).thenReturn(
            Stream.of(new Movie(new MovieId("idkfa7"), "", MovieType.NEW, Year.of(2000))));

        Optional<MovieDto> result = movieRESTResource.getFilm("idkfa7");
        Assertions.assertThat(result.get().getDetails()).isEqualTo("idkfa7-details");
    }

    @Test
    public void getBookByIdDoesntExist() {
        when(movieRepository.findAllById(any())).thenReturn(
            Stream.of(new Movie(new MovieId("notfound"), "", MovieType.NEW, Year.of(2000))));

        Optional<MovieDto> result = movieRESTResource.getFilm("notfound");
        Assertions.assertThat(result.get().getDetails()).isNull();
    }
}
