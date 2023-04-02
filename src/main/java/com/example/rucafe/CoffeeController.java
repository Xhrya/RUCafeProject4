package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class CoffeeController {
    private MainController mainController;
    private int quantity = 0;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    ToggleGroup cupSize;
    @FXML
    CheckBox SweetCream;
    @FXML
    CheckBox FrenchVanilla;
    @FXML
    CheckBox IrishCream;
    @FXML
    CheckBox Caramel;
    @FXML
    CheckBox Mocha;
    @FXML
    MenuButton CoffeeQty;

    public void oneCoffee(ActionEvent actionEvent) {quantity = 1;}
    public void twoCoffee(ActionEvent actionEvent) {quantity = 2;}
    public void threeCoffee(ActionEvent actionEvent) {quantity = 3;}
    public void fourCoffee(ActionEvent actionEvent) {quantity = 4;}
    public void fiveCoffee(ActionEvent actionEvent) {quantity = 5;}

    @FXML
    protected void onAddToBasket(Event e){
        if(cupSize.getSelectedToggle() == null){
            //insert text here
            return;
        }
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);

        ArrayList addIns = new ArrayList();
        if(SweetCream.isSelected()){addIns.add("Sweet Cream");}
        if(FrenchVanilla.isSelected()){addIns.add("French Vanilla");}
        if(IrishCream.isSelected()){addIns.add("Irish Cream");}
        if(Caramel.isSelected()){addIns.add("Caramel");}
        if(Mocha.isSelected()){addIns.add("Mocha");}

        for(int i=0; i<quantity; i++){
            Coffee newCoffee = new Coffee(size, addIns);
            //somehow adds to the basket
        }
        quantity = 0;
    }
}