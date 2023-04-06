package com.example.rucafe;

import javafx.scene.control.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {
    //should have order number and list of menu items

    private int orderNumber;
    private ArrayList<MenuItem> orderList;


    private final double NJ_TAX = 0.06625;
    //what's the point of this being an ArrayList?
    //it's the list of all the items chosen to odder(the different donuts and etc)


    public Order()
    {
        orderNumber =1;
        orderList= new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getOrderList()
    {
        return this.orderList;
    }

    public void add(Donuts a)
    {
        orderList.add(a);
    }

    public void remove(Donuts a)
    {
        for(int i=0; i<orderList.size(); i++)
        {
            if(orderList.get(i).equals(a))
            {
                orderList.remove(i);
            }
        }
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber =orderNumber;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

//    public int findIndexMenuItem(String menuItemFind)
//    {
//
//    }

    public int getOrderListSize()
    {
        return orderList.size();
    }

    public String menuItemAsString(int index)
    {
        String outputString = "";
        outputString = orderList.get(index).toString();

        return outputString;
    }

    public String toString()
    {
        String orderString = "Order #" + this.orderNumber + " Total: $" + this.totalWithTax() + "(" + this.orderNumber + ")";
        //display each order from ArrayList as a new line
        for(int i =0; i<orderList.size(); i++)
        {
            orderString += orderList.get(i).toString() + "\n";
        }

        return orderString;
    }

    public double salesTax() //6.625% and dollars rounded to 2 decimal points
    {
        double salesTax =0;
        //get the sales tax
      //  salesTax = NJ_TAX * menuItems.itemPrice();
        //add to total
        salesTax= Double.parseDouble(String.format("%.2f",salesTax));
        return salesTax;
    }

    public double totalWithTax() //6.625% and dollars rounded to 2 decimal points
    {
        double totalWithTax =0;
        //get the sales tax
     //   totalWithTax = salesTax() + orderList.itemPrice();
        //add to total
        totalWithTax= Double.parseDouble(String.format("%.2f",totalWithTax));

        return totalWithTax;
    }





}
