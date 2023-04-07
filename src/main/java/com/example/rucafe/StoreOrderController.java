/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.example.rucafe.MainController.storeOrderListMain;

public class StoreOrderController implements Initializable {
    private MainController mainController;

    private ObservableList<String> observeOrderList = FXCollections.observableArrayList();
    @FXML
    protected TextField subTotal;
    @FXML
    protected TextField salesTax;
    @FXML
    protected TextField total;

    @FXML
    protected ListView listOfOrders;

    @FXML
    ComboBox orderChooser;

    //create two observable lists?

    ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    //call the order class in order to get order number and etc

    private ObservableList<String> orderNumbersTotal = FXCollections.observableArrayList();



    //import all the orders from myBasket

    /**
     * Sets the main controller
     * @param controller is the main controller
     */
    public void setMainController (MainController controller){
        mainController = controller;
    }

    /**
     * Selects a specific order
     * @param actionEvent is under the case this order is selected
     */
    @FXML
    protected void onChooseOrderNumber(ActionEvent actionEvent)
    {

        int index = listOfOrders.getSelectionModel().getSelectedIndex();

        listOfOrders.getItems().clear();
        //we want to call this entire order form storeOrders

        if(!orderList.isEmpty())
        {

//               // listOfOrders.add(thisOrder.getMenuString(i)); //get this to show up in the listview
//
//                for(int i=0; i<storeOrderListMain.getOrder(order).getOrderListSize(); i++){
                    observeOrderList.add(storeOrderListMain.getOrder(index).toString());
//                }
                listOfOrders.setItems(observeOrderList);
                //subTotal.setText("$" + calculateFinalPrices());


        }

        //listOfOrders.setItems(thisOrder);

        subTotal.setText("$" + storeOrderListMain.getOrder(index).totalWithTax());

    }


    /**
     * Cancels the selected order
     * @param event is under the case this order is selected
     */
    @FXML
    protected void onCancelOrder(ActionEvent event)
    {
        Alert alert;
        if(listOfOrders.getSelectionModel().getSelectedItem()==null)
        {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Order Cancellation Failed.");
            alert.setContentText("There are no orders in the store.");
            alert.showAndWait();
        } else {
            int index = listOfOrders.getSelectionModel().getSelectedIndex();

            //remove at the index
            //listOfOrders.remove(index);
            observeOrderList.remove(index);
            storeOrderListMain.getListOfOrders().remove(index);
            listOfOrders.setItems(observeOrderList);

            //recalculate after removing item!!!
            calculateFinalPrices();
        }
    }

    /**
     * Saves and exports the order
     * @param event is under the case this order is selected
     */
    @FXML
    protected void onSaveAndExport(ActionEvent event) throws IOException {
        if(listOfOrders.equals(null))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Error");
            alert.setContentText("There are no orders to save and export.");
            alert.showAndWait();
        }
        else {
//            File coffeeFile = new File("RUCafeProject4/src/main/savedOrder.txt");
            FileWriter myWriter = new FileWriter("savedOrder.txt", true);
            for(int i =0; i<storeOrderListMain.getListOfOrders().size(); i++){
                myWriter.write(storeOrderListMain.getListOfOrders().get(i).toString());
            }
            myWriter.close();

        }

        }


    /**
     * Initializes the controller
     * @param location  creates location
     * @param resources intializes resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(storeOrderListMain != null){
            for(int i=0; i<storeOrderListMain.getNumberOrders(); i++){
                observeOrderList.add(storeOrderListMain.getOrder(i).toString());
            }
            listOfOrders.setItems(observeOrderList);
            calculateFinalPrices();
        }
//        if(storeOrderListMain != null)
//        {
//            orderChooser.getItems().clear();
//            orderNumbersTotal.clear();
//            for (int i = 0; i < storeOrderListMain.getNumberOrders(); i++) {
//                String orderNumber = String.valueOf(storeOrderListMain.getListOfOrders().get(i).getOrderNumber());
//                orderNumbersTotal.add(orderNumber);
//            }
//            orderChooser.setItems(orderNumbersTotal);
//            orderChooser.getSelectionModel().select(0);
//        }
//        else {
//            return;
//        }
    }

    /**
     * Calculates the final prices of all the orders
     */
    public void calculateFinalPrices(){
        double subTotalCost = 0.0;
      //  goes through the array and based on the item's type, adds that cost
        for(int i =0; i<storeOrderListMain.getListOfOrders().size(); i++){
            subTotalCost = subTotalCost + storeOrderListMain.getListOfOrders().get(i).getTotalPrice();
        }
        //displaying the costs
        subTotal.setText("$" + String.format("%.2f",(subTotalCost/1.06625)));
        salesTax.setText("$" + String.format("%.2f",(subTotalCost-(subTotalCost/1.06625))));
        total.setText("$" + String.format("%.2f",subTotalCost));
    }

}