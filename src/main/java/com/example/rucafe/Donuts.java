/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Donuts extends MenuItem {


  String donutType = "";
  String donutFlavor = "";
  double quantity =0;


    /**
     * Constructor for donuts
     * @param donutFlavor the flavor of the donut
     * @param donutType the type of the donut
     * @param quantity is the number of donuts
     */
    public Donuts(String donutType, String donutFlavor, double quantity){
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.quantity = quantity;
    }

    /**
     * Returns the price of the donut based on its type
     */
    @Override
    public double itemPrice()
    {
        if(donutType.equals("Yeast Donuts"))
        {
            return DonutPrices.YEAST.getPrice();
        }
        else if(donutType.equals("Cake Donuts"))
        {
           return DonutPrices.CAKE.getPrice();
        }
        else if(donutType.equals("Hole Donuts"))
        {
            return DonutPrices.HOLE.getPrice();
        }
       return 0;
    }

    /**
     * Returns the price of the donut based on its type and quantity
     */
    public double donutPriceWithQuantity()
    {
        return itemPrice()*quantity;
    }

    /**
     * compares the menuitems
     */
    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }

    /**
     * donut item changed to string
     */
    @Override
    public String toString()
    {
        String outputString = "";
        outputString += donutType + " " + donutFlavor + " (" + quantity + ")";
        return outputString;
    }


}
