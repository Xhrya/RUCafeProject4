package com.example.rucafe;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Donuts extends MenuItem {


  private final double yeast = 1.59;
  private final double cake = 1.79;

  private final double hole = 1.39;

  String donutType = "";
  String donutFlavor = "";
  double quantity =0;


    public Donuts(String donutType, String donutFlavor, double quantity){
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.quantity = quantity;
    }

    @Override
    public double itemPrice()
    {
        if(donutType.equals("Yeast Donuts"))
        {
            return yeast;
        }
        else if(donutType.equals("Cake Donuts"))
        {
           return cake;
        }
        else if(donutType.equals("Hole Donuts"))
        {
            return hole;
        }
       return 0;
    }

    public double donutPriceWithQuantity()
    {
        return itemPrice()*quantity;
    }


    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }
    @Override
    public String toString()
    {
        String outputString = "";
        outputString += donutType + " " + donutFlavor + " (" + quantity + ")";
        return outputString;
    }
}
