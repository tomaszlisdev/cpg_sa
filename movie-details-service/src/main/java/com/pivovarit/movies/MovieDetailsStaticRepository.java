package com.pivovarit.movies;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class MovieDetailsStaticRepository implements MovieDetailsRepository {

    private final Map<String, String> movieDetails = new HashMap<>();

    public MovieDetailsStaticRepository() {
        movieDetails.put("idkfa78", "When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family.");
        movieDetails.put("asdf195", "A team of commandos on a mission in a Central American jungle find themselves hunted by an extraterrestrial warrior.");
        movieDetails.put("incptn", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.");
        movieDetails.put("plpfct1", "Pulp Fiction is a 1994 American crime film written and directed by Quentin Tarantino; it is based on a story by Tarantino and Roger Avary");
    }

    @Override
    public String getDetails(String id) {
        return movieDetails.get(id);
    }
}
