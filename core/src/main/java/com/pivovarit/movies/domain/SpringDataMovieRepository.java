package com.pivovarit.movies.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringDataMovieRepository extends CrudRepository<HibernatePersistedMovie, String> {
}
