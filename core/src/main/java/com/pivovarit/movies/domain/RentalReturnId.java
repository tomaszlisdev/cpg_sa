package com.pivovarit.movies.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class RentalReturnId implements Serializable {
    @Column(name = "rental_id")
    private long rentalId;
    @Column(name = "movie_id")
    private String movieId;
}
