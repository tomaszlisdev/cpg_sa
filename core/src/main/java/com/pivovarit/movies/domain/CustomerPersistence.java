package com.pivovarit.movies.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
class CustomerPersistence {
    @Id
    private long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<RentalPersistence> rentals;
    @OneToMany(mappedBy = "customer")
    private List<BonusPointsPersistence> pointsHistory;
}
