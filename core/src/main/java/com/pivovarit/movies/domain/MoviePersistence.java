package com.pivovarit.movies.domain;

import com.pivovarit.movies.converters.YearConverter;
import lombok.*;

import javax.persistence.*;
import java.time.Year;


@Data
@Table(name = "movie")
@Entity
class MoviePersistence {
    @EmbeddedId
    private MovieIdPersistence id;
    private String title;
    @Enumerated
    private MovieType type;
    @Convert(converter = YearConverter.class)
    private Year year;
}
