package com.example.rucafe;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class CoffeeController {

    private MainController mainController;


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


    protected void onAddToBasketClick(Event e){
        if(cupSize.getSelectedToggle() == null){
            //insert text here
            return;
        }
        ArrayList addIns = new ArrayList();

        int qty = Integer.parseInt(CoffeeQty.getPopupSide().toString());

        if(SweetCream.isSelected()){
            addIns.add("Sweet Cream");
        }

        if(FrenchVanilla.isSelected()){
            addIns.add("French Vanilla");
        }

        if(IrishCream.isSelected()){
            addIns.add("Irish Cream");
        }

        if(Caramel.isSelected()){
            addIns.add("Caramel");
        }

        if(Mocha.isSelected()){
            addIns.add("Mocha");
        }

        for(int i=0; i<qty; i++){
            Coffee newCoffee = new Coffee(cupSize.getSelectedToggle().toString(), addIns);
            //somehow adds to the basket
        }
    }
}