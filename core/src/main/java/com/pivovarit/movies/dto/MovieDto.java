package com.pivovarit.movies.dto;

import lombok.Value;

@Value
public class MovieDto {
    private final String id;
    private final String title;
    private final MovieTypeDto type;
    private final Integer year;
}
