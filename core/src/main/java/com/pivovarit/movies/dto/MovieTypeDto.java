package com.pivovarit.movies.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.beans.ConstructorProperties;

@RequiredArgsConstructor(onConstructor = @__({@ConstructorProperties({"movieType"})}))
@Builder
@Value
public class MovieTypeDto {
    private final String movieType;
}
