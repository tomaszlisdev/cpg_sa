package com.pivovarit.movies;

public class MockMovieDetailsClient implements DetailsClient {
    @Override
    public String getDetails(String id) {
        return "";
    }
}
