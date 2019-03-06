package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ApplicationInitializer implements CommandLineRunner {

    private final MovieFacade movieFacade;

    @Value("${java.io.tmpdir}")
    private String tempDir;

    @Override
    public void run(String... args) {
        System.out.println("Started!");

        movieFacade.add(new MovieDto(1L, "Spiderman1", new MovieTypeDto("NEW")));
        movieFacade.priceFor(new MovieTypeDto("NEW"))
            .ifPresent(System.out::println);
        System.out.println(tempDir);
    }
}
