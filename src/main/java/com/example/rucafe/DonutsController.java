package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class DonutsController implements Initializable {
    private MainController mainController;

    private ArrayList<Donuts> donutList;
    private ArrayList<Order> currentOrderList;

    private Donuts currentDonut;

    @FXML
    ComboBox<String> chooseDonutsType;

    @FXML
    ListView<String> chooseDonutFlavors;

    @FXML
    TextField quantity;

    @FXML
    TextField thisDonutPrice;

    @FXML
    TextField donutsPriceTotal;

    @FXML
    ImageView donutImage;



    //create an array list of donuts that stores the info about donut
    //the info about the donut will be: flavor, type, and quantity?

    public void setMainController(MainController controller, ArrayList<MenuItem> basket)
    {
        mainController = controller;
        //currentOrderList= list;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //public so this initialize method can be used by other methods


        //use observable lists here to set types of donuts

        //this particular observable list is to set and choose type of donut
        ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast Donuts","Hole Donuts", "Cake Donuts");
        chooseDonutsType.setItems(donutTypeList);

        chooseDonutsType.getSelectionModel().select(0);

        //now create a list for each type of flavor by each type of donut selected
        ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Strawberry","Chocolate", "Vanilla", "Coconut", "Boston Creme", "Birthday Cake");
        chooseDonutFlavors.getItems().clear();
        chooseDonutFlavors.setItems(yeastDonutFlavors);
        //chooseDonutFlavors.getSelectionModel().select(0);

        ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate","Vanilla", "Birthday Cake");
//        chooseDonutFlavors.getItems().clear();
//        chooseDonutFlavors.setItems(cakeDonutFlavors);

        ObservableList<String> donutHolesFlavors = FXCollections.observableArrayList("Chocolate","Glazed", "Vanilla");
//        chooseDonutFlavors.getItems().clear();
//        chooseDonutFlavors.setItems(donutHolesFlavors);



    }
    @FXML
    protected void onDonutTypeComboSelected()
    {
        Object currentDonutTypeSelection = chooseDonutsType.getSelectionModel().getSelectedItem();

        if(currentDonutTypeSelection.equals("Yeast Donuts"))
        {
            ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Strawberry","Chocolate", "Vanilla", "Coconut", "Boston Creme", "Birthday Cake");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(yeastDonutFlavors);
            //donutImage.setImage(cakeDonuts.jpeg);
        }
        else if(currentDonutTypeSelection.equals("Cake Donuts"))
        {
            ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate","Vanilla", "Birthday Cake");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(cakeDonutFlavors);

        }
        else if(currentDonutTypeSelection.equals("Hole Donuts"))
        {
            ObservableList<String> donutHolesFlavors = FXCollections.observableArrayList("Chocolate","Glazed", "Vanilla");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(donutHolesFlavors);
        }
    }


    @FXML
    protected void onSelectDonut()
    {
        //check to make sure donut type selected
        //check to make sure donut flavor selected
        //check to make sure quantity is greater than or equal to 1

        String donutType = chooseDonutsType.getSelectionModel().getSelectedItem();
        if(donutType.equals(null))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select a donut type");
        }
        String donutFlavor = chooseDonutFlavors.getSelectionModel().getSelectedItem();
        if(donutFlavor.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select a donut flavor");
        }
        int numberOfDonuts = Integer.parseInt(quantity.getText());
        if(numberOfDonuts == 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select the amount of donuts you would like to purchase");
        }
    //    public Donuts(String donutType, String donutFlavor, double quantity){
        currentDonut =  new Donuts(donutType, donutFlavor, numberOfDonuts);

        double displayPrice = currentDonut.itemPrice() *numberOfDonuts;

        thisDonutPrice.setText("$" + displayPrice);

        donutList.add(currentDonut);

    }


    protected double displayTotalPrice() {
        double total = 0;

        for(int i=0; i<donutList.size(); i++)
        {
            total+= donutList.get(i).donutPriceWithQuantity();
        }

        total= Double.parseDouble(String.format("%.2f",total));
        return total;
    }






    @FXML
    protected void onAddToBasket()
    {
        //add to some sort of list of donuts to sent to basket
        //Donuts(donutsType.getItems());

        if(donutList.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Add to Order Failed");
            alert.setContentText("No donuts selected.");
            alert.showAndWait();
        }
        else if(currentDonut ==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Add to Order Failed");
            alert.setContentText("No donuts selected.");
            alert.showAndWait();
        }
        else{
            //just need to import this list?


            for(int i=0; i <donutList.size(); i++)
            {
//                basket.addDonuts(currentOrderList.get(i));



             //   currentDonut.add(donutList.get(i));
               // donutList.add(currentDonutOrder);
            }

            donutsPriceTotal.setText("$" + displayTotalPrice());



            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation!!");
            alert.setHeaderText("Add to Basket!");
            alert.setContentText("Adding Donuts to Basket Confirmed!");
            alert.showAndWait();

            //then create another alert for confirmation of whether we really wanna dd this to
            //order once we get all the data
        }
    }



    @FXML
    protected void onHomeButtonClick()
    {
        Stage mainView = new Stage();
        VBox root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeView.fxml"));
            root2 = (VBox) loader.load();
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

