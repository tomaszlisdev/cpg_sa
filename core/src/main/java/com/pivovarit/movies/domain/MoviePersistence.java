package com.pivovarit.movies.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "movie")
@Entity
class MoviePersistence {
    @EmbeddedId
    private MovieIdPersistence id;
    private String title;
    @Enumerated
    private MovieType type;
    private int year;
}
