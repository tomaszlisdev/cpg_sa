package com.pivovarit.movies.domain;

import lombok.Value;

@Value
public class StaticPriceCalculator implements PriceCalculator {

    private final long priceNew;
    private final long priceRegular;
    private final long priceOld;

    @Override
    public long getPrice(MovieType movieType) {
        switch (movieType){
            case NEW: return priceNew;
            case REGULAR: return priceRegular;
            case OLD: return priceOld;
            default: throw new IllegalStateException("Price not found");
        }
    }
}
