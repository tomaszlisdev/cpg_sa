package com.pivovarit.movies.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rental")
class RentalPersistence {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerPersistence customer;
    @OneToMany(mappedBy = "rental")
    private List<RentalReturnPersistence> rentalReturns;
    @OneToMany(mappedBy = "rental")
    private List<RentalEntryPersistence> rentalEntries;
    @OneToOne(mappedBy = "rental")
    private BonusPointsPersistence bonusPoints;
    private LocalDate localDate;
}
