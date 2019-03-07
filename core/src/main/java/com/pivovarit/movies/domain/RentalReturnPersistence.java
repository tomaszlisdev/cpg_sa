package com.pivovarit.movies.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "rental_return")
class RentalReturnPersistence {
    @EmbeddedId
    private RentalReturnId id;
    @ManyToOne
    @JoinColumn(name = "rental_id", insertable = false, updatable = false)
    private RentalPersistence rental;
    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private MoviePersistence movie;
    private LocalDate returnDate;
}
