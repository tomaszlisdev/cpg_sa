package com.pivovarit.movies.domain;

@FunctionalInterface
interface MoviePriceCalculator {
    long getPrice(MovieType movieType);
}
