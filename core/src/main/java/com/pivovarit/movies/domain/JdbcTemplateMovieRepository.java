package com.pivovarit.movies.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcTemplateMovieRepository implements  MovieRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public MovieId save(Movie movie) {
        jdbcTemplate.update("INSERT INTO movie VALUES (?, ?, ?, ?)",
                new Object[]{movie.getId().getId(), movie.getTitle(), movie.getType().toString(), movie.getYear()}
                );
        return movie.getId();
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movie", new MovieRowMapper());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE title = ?",
                new Object[]{title},
                new MovieRowMapper()).stream().findAny();
    }

    static class MovieRowMapper implements RowMapper<Movie>{
        @Override
        public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Movie(
                new MovieId(resultSet.getLong("id")),
                resultSet.getString("title"),
                MovieType.valueOf(resultSet.getString("type")),
                resultSet.getInt("year")
            );
        }
    }
}
