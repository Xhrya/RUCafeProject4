package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DonutsController {
    private MainController mainController;

    ArrayList<Donuts> donutList;

    @FXML
    ComboBox<String> donutsType;

    @FXML
    ListView<String> donutFlavors;

    @FXML
    TextField quantity;

    @FXML
    TextField runningTotal;

    int runningTotalCalculated;

    //create an array list of donuts that stores the info about donut
    //the info about the donut will be: flavor, type, and quantity?

    public void setMainController(MainController controller) {
        mainController = controller;
    }
    @FXML
    protected void onDonutTypeComboSelected()
    {
        //use observable lists here to set types of donuts

        //this particular observable list is to set and choose type of donut
        ObservableList<String> donutTypeList = FXCollections.observableArrayList("Hole","Yeast", "Cake");
        donutsType.setItems(donutTypeList);


        //now create a list for each type of flavor by each type of donut selected
        ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Strawberry","Chocolate", "Vanilla", "Coconut", "Boston Creme", "Birthday Cake");

        ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate","Vanilla", "Birthday Cake");
        ObservableList<String> donutHolesFlavors = FXCollections.observableArrayList("Chocolate","Glazed", "Vanilla");



    }



    @FXML
    protected void onSelectDonut()
    {
        String donutType = donutsType.getId().toString();

        String donutFlavor = donutFlavors.getId().toString();

        int numberOfDonuts = Integer.parseInt(quantity.getText());
        double total=0;


        runningTotal.setAccessibleText("$" + total);



    }

    @FXML
    protected void onAddToBasket()
    {
        //add to some sort of list of donuts to sent to basket
        //Donuts(donutsType.getItems());
    }

    @FXML
    protected void onHomeButtonClick()
    {
        Stage mainView = new Stage();
        BorderPane root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeView.fxml"));
            root2 = (BorderPane) loader.load();
            Scene scene = new Scene(root2, 550, 700);
            mainView.setScene(scene);
            mainView.show();

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();

        }

    }




}

