package com.pivovarit.movies.domain;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    default Movie map(MoviePersistence persistence){
        return Movie.builder()
                .id(MovieIdMapper.INSTANCE.map(persistence.getId()))
                .title(persistence.getTitle())
                .type(persistence.getType())
                .year(persistence.getYear())
                .build();
    }
    MoviePersistence map(Movie movie);
}
