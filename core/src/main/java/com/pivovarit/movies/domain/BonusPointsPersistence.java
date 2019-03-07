package com.pivovarit.movies.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bonus_points_history")
class BonusPointsPersistence {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerPersistence customer;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private RentalPersistence rental;
    private int amount;
}
