package com.example.rucafe;

public enum AddIns {
    SWEETCREAM(0.30),
    FRENCHVANILLA(0.30),
    IRISHCREAM(0.30),
    CARAMEL(0.30),
    MOCHA(0.30);


    private final double price;

    AddIns(double Price){
        this.price = Price;
    }

    double getPrice(){
        return this.price;
    }
}
