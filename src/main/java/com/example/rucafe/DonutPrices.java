/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

public enum DonutPrices {

    YEAST(1.59),
    CAKE(1.79),
    HOLE(1.39);

    private final double price;

    DonutPrices(double Price){
        this.price = Price;
    }

    double getPrice(){
        return this.price;
    }
}
