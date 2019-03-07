package com.pivovarit.movies.domain;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieIdMapper {
    MovieIdMapper INSTANCE = Mappers.getMapper(MovieIdMapper.class);
    default MovieId map(MovieIdPersistence persistenceId){
        return builder(persistenceId).build();
    }
    MovieIdPersistence map(MovieId movieId);
    MovieId.MovieIdBuilder builder(MovieIdPersistence moviePersistence);
}
