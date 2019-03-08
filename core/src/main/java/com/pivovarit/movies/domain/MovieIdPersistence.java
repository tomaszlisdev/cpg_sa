package com.pivovarit.movies.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class MovieIdPersistence implements Serializable {
    private String id;
}
