package com.example.rucafe;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Donuts extends MenuItem {


  private final double yeast = 1.59;
  private final double cake = 1.79;

  private final double hole = 1.39;
//
//        if(donutType.equals("yeast"))
//    {
//        total = 1.59 * numberOfDonuts;
//    }
//        else if(donutType.equals("cake")) {
//        total = 1.79 * numberOfDonuts;
//
//    }
//        else if(donutType.equals("hole"))
//    {
//        total = 0.39 * numberOfDonuts;
//    }
    @Override
    public double itemPrice() {
       return 0.0;
    }


    @Override
    public int compareTo(MenuItem o) {
        return 0;
    }
}
