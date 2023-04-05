package com.example.rucafe;

import javafx.scene.control.Menu;

import java.util.ArrayList;

public class Order {
    //should have order number and list of menu items

    private int orderNumber;
    private MenuItem menuItems;

    private final double NJ_TAX = 0.06625;
    protected ArrayList<MenuItem> orderList;
    //what's the point of this being an ArrayList?
    //it's the list of all the items chosen to odder(the different donuts and etc)


    public Order()
    {
        orderNumber =1;
        orderList= new ArrayList<MenuItem>();
    }

    public void add(Donuts a)
    {
        orderList.add(a);
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber =orderNumber;
    }

    public String menuItemAsString(int index)
    {
        String outputString = "";
        outputString = orderList.get(index).toString();

        return outputString;
    }

    public String toString()
    {
        String orderString ="";
        return orderString;
    }

    public double salesTax() //6.625% and dollars rounded to 2 decimal points
    {
        double salesTax =0;
        //get the sales tax
        salesTax = NJ_TAX * menuItems.itemPrice();
        //add to total
        salesTax= Double.parseDouble(String.format("%.2f",salesTax));
        return salesTax;
    }

    public double totalWithTax() //6.625% and dollars rounded to 2 decimal points
    {
        double totalWithTax =0;
        //get the sales tax
        totalWithTax = salesTax() + menuItems.itemPrice();
        //add to total
        return totalWithTax;
    }





}
