package com.example.rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    private String cupSize;
    private ArrayList addIns;
    public Coffee(String size, ArrayList addIns){
        this.cupSize = size;
        this.addIns = addIns;
    }

    @Override
    public double itemPrice(){
        return 0.0;
    }

    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }
}
