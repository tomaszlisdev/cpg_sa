package com.pivovarit.movies.domain;

@FunctionalInterface
public interface PriceCalculator {
    public long getPrice(MovieType movieType);
}


