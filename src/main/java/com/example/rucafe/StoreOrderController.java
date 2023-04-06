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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreOrderController {
    private MainController mainController;

    @FXML
    protected TextField subTotal;

    @FXML
    protected ListView listOfOrders;

    @FXML
    MenuButton orderChooser;

    //create two observable lists?

    ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    //call the order class in order to get order number and etc



    //import all the orders from myBasket
    public void setMainController (MainController controller){
        mainController = controller;
    }

    @FXML
    protected void onChooseOrderNumber(ActionEvent actionEvent)
    {
        int order = Integer.parseInt(orderChooser.getText());
        StoreOrders orders = new StoreOrders();
        Order thisOrder = orders.getOrder(order);

        listOfOrders.getItems().clear();
        //we want to call this entire order form storeOrders

        if(!orderList.isEmpty())
        {
            for(int i =0; i<thisOrder.getOrderListSize(); i++)
            {
               // listOfOrders.add(thisOrder.getMenuString(i)); //get this to show up in the listview
            }

        }

        //listOfOrders.setItems(thisOrder);

        subTotal.setText("$" + thisOrder.totalWithTax());
    }



    @FXML
    protected void onCancelOrder(ActionEvent event)
    {
        Alert alert;
        if(listOfOrders.getSelectionModel().getSelectedItem() ==null)
        {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Order Cancellation Failed.");
            alert.setContentText("There are no orders in the store.");
            alert.showAndWait();
        }
        else {
            int index = listOfOrders.getSelectionModel().getSelectedIndex();

            //remove at the index
            //listOfOrders.remove(index);
        }


    }

    @FXML
    protected void onSaveAndExport(ActionEvent event)
    {
        if(listOfOrders.equals(null))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Error");
            alert.setContentText("There are no orders to save and export.");
            alert.showAndWait();
        }
        else {
            FileChooser fileChoose = new FileChooser();

            //save the data onto a new file with a new stage
            fileChoose.setTitle("Save and Export your order to a text file");
            fileChoose.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt")
                    ,new FileChooser.ExtensionFilter("HTML Files", "*.htm")
            ); //extension filter to filter out what files are shown in Filechoose

            Stage stage = new Stage();
            File saveHere = fileChoose.showSaveDialog(stage);
            Alert alert = new Alert(Alert.AlertType.WARNING);

            if(saveHere ==null)
            {
                alert.setTitle("Warning!!");
                alert.setHeaderText("Error");
                alert.setContentText("No file was chosen to be exported.");
            }
            else {
                alert.setTitle("Confirmation");
                alert.setHeaderText("Saved and Exported");
                alert.setContentText("The orders have been saved successfully.");
            }
            alert.showAndWait();
        }
    }



}