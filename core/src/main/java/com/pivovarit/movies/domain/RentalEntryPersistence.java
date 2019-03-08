package com.pivovarit.movies.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rental_entry")
class RentalEntryPersistence {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private RentalPersistence rental;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MoviePersistence movie;
    private int days;
}
