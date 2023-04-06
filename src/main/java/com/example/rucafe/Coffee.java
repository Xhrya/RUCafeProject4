package com.example.rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem{
    private String cupSize;
    private ArrayList<String> addIns;

    private double coffeePrice = 0.0;
    public Coffee(String size, ArrayList addIns, double price){
        this.cupSize = size;
        this.addIns = addIns;
        this.coffeePrice = price;
    }

    @Override
    public double itemPrice(){
        return coffeePrice;
    }

    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }

    @Override
    public String toString() {
        return ("COFFEE: " + this.cupSize + " ADD-INS:" +  addIns.toString().toLowerCase());
    }
}
