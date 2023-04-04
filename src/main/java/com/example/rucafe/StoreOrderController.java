package com.example.rucafe;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrderController implements Initializable {
    private MainController mainController;

    @FXML
    protected TextField total;

    @FXML
    private ListView listOfOrders;




    //import all the orders from myBasket
    public void setMainController(MainController controller) {
        mainController = controller;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    protected void onCancelOrder()
    {

    }

    protected void onSaveAndExportOrder()
    {

    }
}