package com.pivovarit.movies.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
interface SpringDataMovieRepository extends CrudRepository<HibernatePersistedMovie, String> {
    Collection<HibernatePersistedMovie> findAllByType(String toString);
    Optional<HibernatePersistedMovie> findAllByTitle(String title);

    Collection<HibernatePersistedMovie> findAllByYear(int value);

    Collection<HibernatePersistedMovie> findAllByYearLessThan(int year);
    Collection<HibernatePersistedMovie> findAllByYearBetweenOrderByYearDesc(int yearFrom, int yearTo);
}
