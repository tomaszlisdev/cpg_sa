package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class StaticMoviePriceCalculator implements MoviePriceCalculator {

    private final long priceNew;
    private final long priceOld;
    private final long priceRegular;

    @Override
    public long getPrice(MovieType movieType) {
        switch (movieType) {
            case NEW: return priceNew;
            case REGULAR: return priceRegular;
            case OLD: return priceOld;
            default: throw new IllegalStateException("pricing not found");
        }
    }
}
