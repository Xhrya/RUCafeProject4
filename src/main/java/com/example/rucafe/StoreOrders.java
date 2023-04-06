package com.example.rucafe;

import java.util.ArrayList;

public class StoreOrders {

    //call all the orders from orders class
    //create an array of all the orders that basket gets

    //private Order order = new Order();
    private int orderNumber;
    private ArrayList<Order> listOfOrders;

    public StoreOrders()
    {
        listOfOrders = new ArrayList<Order>();
    }

    public ArrayList<Order> getListOfOrders()
    {
        return listOfOrders;
    }

    public Order getOrder(int orderNumber) //return the order based on order number
    {//find the index of the order
        Order thisOrder = new Order();
        for(int i=0;i<listOfOrders.size();i++)
        {
            if(listOfOrders.get(i).getOrderNumber() == orderNumber)
            {
                thisOrder= listOfOrders.get(i);
            }
        }

        return thisOrder;
    }

    public int getNumberOrders()
    {
        return listOfOrders.size();
    }

    public String toString()
    {
        String storeOrdersString = "";
        for(int i =0; i<listOfOrders.size(); i++)
        {
            storeOrdersString += listOfOrders.get(i).toString() + "\n";
        }
        return storeOrdersString;
    }



}
