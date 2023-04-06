/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem{
    private String cupSize;
    private ArrayList<String> addIns;

    private double coffeePrice = 0.0;

    /**
     * Constructor for coffee
     * @param size size of the coffee
     * @param addIns is an arraylist of add ins
     * @param price is the price of the coffee
     */
    public Coffee(String size, ArrayList addIns, double price){
        this.cupSize = size;
        this.addIns = addIns;
        this.coffeePrice = price;
    }

    /**
     * Return's the cofee's price
     */
    @Override
    public double itemPrice(){
        return coffeePrice;
    }

    /**
     * Compares the two coffees
     */
    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }

    /**
     * Returns coffee as a String
     */
    @Override
    public String toString() {
        return ("COFFEE: " + this.cupSize + " ADD-INS:" +  addIns.toString().toLowerCase());
    }
}
