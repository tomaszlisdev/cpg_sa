package com.pivovarit.movies.dto;

import lombok.Value;

@Value
public class MovieDto {
    private final Long id;
    private final String title;
    private final MovieTypeDto type;
}
