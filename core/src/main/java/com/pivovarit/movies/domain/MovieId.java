package com.pivovarit.movies.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class MovieId {
    private final long id;
}
