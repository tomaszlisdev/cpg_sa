package com.pivovarit.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
public class MovieApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args){
        SpringApplication.run(MovieApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.query("SELECT * FROM movie", (rs, rowNum) -> getPrintln(rs.getLong("id"), rs.getString("title"), rs.getString("type")));
    }

    private String getPrintln(Object id, Object title, Object type) {
        System.out.println(String.format("%s %s %s", id, type, title));
        return "jes";
    }
}
