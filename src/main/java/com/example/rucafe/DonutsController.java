/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;


public class DonutsController implements Initializable{
    private MainController mainController;

    private ArrayList<Donuts> donutList = new ArrayList<Donuts>();

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

    /**
     * Sets the main controller
     * @param controller is the main controller
     */
    public void setMainController(MainController controller) {
        mainController = controller;
        //currentOrderList= list;
    }

    /**
     * Initializes the controller
     * @param location  creates location
     * @param resources intializes resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //public so this initialize method can be used by other methods


        //use observable lists here to set types of donuts

        //this particular observable list is to set and choose type of donut
        ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast Donuts", "Hole Donuts", "Cake Donuts");
        chooseDonutsType.setItems(donutTypeList);

        chooseDonutsType.getSelectionModel().select(0);

        //now create a list for each type of flavor by each type of donut selected
        ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Chocolate", "Vanilla", "Coconut", "Boston Creme", "Birthday Cake");
        chooseDonutFlavors.getItems().clear();
        chooseDonutFlavors.setItems(yeastDonutFlavors);
        //chooseDonutFlavors.getSelectionModel().select(0);

        ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Birthday Cake");
//        chooseDonutFlavors.getItems().clear();
//        chooseDonutFlavors.setItems(cakeDonutFlavors);

        ObservableList<String> donutHolesFlavors = FXCollections.observableArrayList("Chocolate", "Glazed", "Vanilla");
//        chooseDonutFlavors.getItems().clear();
//        chooseDonutFlavors.setItems(donutHolesFlavors);


    }

    /**
     * Displays according to the type of donut that is selected
     */
    @FXML
    protected void onDonutTypeComboSelected() {
        Object currentDonutTypeSelection = chooseDonutsType.getSelectionModel().getSelectedItem();

        if (currentDonutTypeSelection.equals("Yeast Donuts")) {
            ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Chocolate", "Vanilla", "Coconut", "Boston Creme", "Birthday Cake");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(yeastDonutFlavors);
            //donutImage.setImage(cakeDonuts.jpeg);
        } else if (currentDonutTypeSelection.equals("Cake Donuts")) {
            ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Birthday Cake");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(cakeDonutFlavors);

        } else if (currentDonutTypeSelection.equals("Hole Donuts")) {
            ObservableList<String> donutHolesFlavors = FXCollections.observableArrayList("Chocolate", "Glazed", "Vanilla");
            chooseDonutFlavors.getItems().clear();
            chooseDonutFlavors.setItems(donutHolesFlavors);
        }
    }


    /**
     * Display based on the donut and the flavor are selected, otherwise warning
     */
    @FXML
    protected void onSelectDonut() {
        //check to make sure donut type selected
        //check to make sure donut flavor selected
        //check to make sure quantity is greater than or equal to 1

        String donutType = chooseDonutsType.getSelectionModel().getSelectedItem();
        if (donutType.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select a donut type");
        }
        String donutFlavor = chooseDonutFlavors.getSelectionModel().getSelectedItem();
        if (donutFlavor.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select a donut flavor");
        }
        int numberOfDonuts = Integer.parseInt(quantity.getText());
        if (numberOfDonuts == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Please select the amount of donuts you would like to purchase");
        }
        //    public Donuts(String donutType, String donutFlavor, double quantity){
        currentDonut = new Donuts(donutType, donutFlavor, numberOfDonuts);

        double displayPrice = currentDonut.itemPrice() * numberOfDonuts;

        thisDonutPrice.setText("$" + displayPrice);

        donutList.add(currentDonut);

    }


    /**
     * Display price based on what has been selected
     * */
    protected double displayTotalPrice() {
        double total = 0;

        for (int i = 0; i < donutList.size(); i++) {
            total += donutList.get(i).donutPriceWithQuantity();
        }

        total = Double.parseDouble(String.format("%.2f", total));
        return total;
    }


    /**
     * Adds donuts to basket
     */
    @FXML
    protected void onAddToBasket() throws IOException {

        if (donutList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("Add to Order Failed");
            alert.setContentText("No donuts selected.");
            alert.showAndWait();
        } else {

            donutsPriceTotal.setText("$" + displayTotalPrice());
            FileWriter myWriter = new FileWriter("donutsFile.txt");

            for (int i = 0; i < donutList.size(); i++) {

                //EXPORTS TO A FILE
                myWriter.write(donutList.get(i).toString() + "$" + donutList.get(i).itemPrice() + "\n");
                System.out.println(donutList.get(i).toString() + "$" + donutList.get(i).itemPrice() + "\n");
            }
            myWriter.close();


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation!!");
            alert.setHeaderText("Add to Basket!");
            alert.setContentText("Adding Donuts to Basket Confirmed!");
            alert.showAndWait();

        }
    }


}








