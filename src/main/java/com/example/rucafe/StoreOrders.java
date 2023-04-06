/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
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

    /**
     * Gets the correct order based on the number
     * @param orderNumber number assigned to the correct order
     */
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


    /**
     * sets the order number to this basket
     * @param on is the order number of the basket
     */
    public void setOrderNumber(int on)
    {
        orderNumber = on;
    }


    /**
     * Adds the order to the array
     * @param order is the order number of the basket
     */
    public boolean addOrder(Order order)
    {
        if(order!= null)
        {
            order.setOrderNumber(getListOfOrders().size());
            listOfOrders.add(order);
            return true;
        }
        return false;
    }


    /**
     * removes the order from the array
     * @param order is the order number of the basket
     */
    public boolean removeOrder(Order order)
    {
        if(order!= null)
        {
            if (listOfOrders.contains(order)) {
                listOfOrders.remove(order);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of orders
     */
    public int getNumberOrders()
    {
        return listOfOrders.size();
    }

    /**
     * the orders are returned as a list
     */
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
