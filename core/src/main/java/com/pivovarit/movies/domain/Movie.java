package com.pivovarit.movies.domain;

import lombok.Value;

@Value
class Movie {
    private final MovieId id;
    private final String title;
    private final MovieType type;
}
