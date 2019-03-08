package com.pivovarit.movies.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class MovieId {
    private final String id;

    public static MovieId of(String id){
        return new MovieId(id);
    }
}
