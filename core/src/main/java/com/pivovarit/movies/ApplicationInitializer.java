package com.pivovarit.movies;

import com.pivovarit.movies.domain.MovieFacade;
import com.pivovarit.movies.dto.MovieDto;
import com.pivovarit.movies.dto.MovieTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
class ApplicationInitializer implements CommandLineRunner {

    private final MovieFacade movieFacade;

    @Value("${java.io.tmpdir}")
    private String tempDir;

    @Override
    public void run(String... args) {
        System.out.println("Started!");

        List<MovieDto> movies = Arrays.asList(
            new MovieDto("spdrmun1", "Spiderman1", new MovieTypeDto("OLD"), 2012, ""),
            new MovieDto("spdrmun2", "Spiderman2", new MovieTypeDto("OLD"), 2013, ""),
            new MovieDto("incptn", "Inception", new MovieTypeDto("REGULAR"), 2014, ""),
            new MovieDto("plpfct1", "Pulp Fiction", new MovieTypeDto("OLD"), 1994, ""),
            new MovieDto("grnbook", "Grenbook", new MovieTypeDto("NEW"), 2019, ""),
            new MovieDto("mtrx", "Matrix", new MovieTypeDto("OLD"), 1997, ""),
            new MovieDto("cztrpncrn", "Czterej Pancerni", new MovieTypeDto("OLD"), 1966,"")
        );

        movies.forEach(m -> {
            try {
                movieFacade.add(m);
            } catch (Exception e) {
                log.warn("duplicates ignored", e);

            }
        });

        movieFacade.priceFor(new MovieTypeDto("NEW")).ifPresent(price -> System.out.println("NEW price: " + price));
        movieFacade.priceFor(new MovieTypeDto("OLD")).ifPresent(price -> System.out.println("OLD price: " + price));
        movieFacade.priceFor(new MovieTypeDto("REGULAR")).ifPresent(price -> System.out.println("REGULAR price: " + price));
    }
}
