package com.pivovarit.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
class HibernatePersistedMovie {

    @Id
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private Integer year;
}
