package edu.dlg.classapps.beerselector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerBrandExpert {

    private Map<String, BeerFeedback> beerBrands;

    public BeerBrandExpert() {
        this.beerBrands = new HashMap<>();
        this.beerBrands.put("Light", new BeerFeedback("Corona Light"));
        this.beerBrands.put("Amber", new BeerFeedback("Tocobaga Red Ale"));
        this.beerBrands.put("Brown", new BeerFeedback("Cacao Bender"));
        this.beerBrands.put("Dark", new BeerFeedback("Guiness"));
    }

     public BeerFeedback getBrand(String aBeerType) {
        return this.beerBrands.get(aBeerType);
    }
}
