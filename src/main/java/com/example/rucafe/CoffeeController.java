package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CoffeeController {
    private MainController mainController;
    private int quantity = 0;
    private double currentPrice = 0.0;

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
    @FXML
    TextField priceTotal;


    public void oneCoffee(ActionEvent actionEvent) {quantity = 1;
//        priceTotal.appendText("" + currentPrice);
    }
    public void twoCoffee(ActionEvent actionEvent) {quantity = 2;
//        priceTotal.appendText("" + currentPrice * 2);
    }
    public void threeCoffee(ActionEvent actionEvent) {quantity = 3;
//        priceTotal.appendText("" + currentPrice * 3);
    }
    public void fourCoffee(ActionEvent actionEvent) {quantity = 4;
//        priceTotal.appendText("" + currentPrice * 4);
    }
    public void fiveCoffee(ActionEvent actionEvent) {quantity = 5;
//        priceTotal.appendText("" + currentPrice * 5);
    }

    @FXML
    protected void onAddToBasket(Event e){
        if(cupSize.getSelectedToggle() == null){
            //insert text here
            return;
        }
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);


        ArrayList addIns = new ArrayList();
        if(SweetCream.isSelected()){
            addIns.add("Sweet Cream");
            currentPrice = currentPrice + 0.30;
        }
        if(FrenchVanilla.isSelected()){
            addIns.add("French Vanilla");
            currentPrice = currentPrice + 0.30;
        }
        if(IrishCream.isSelected()){
            addIns.add("Irish Cream");
            currentPrice = currentPrice + 0.30;
        }
        if(Caramel.isSelected()){
            addIns.add("Caramel");
            currentPrice = currentPrice + 0.30;
        }
        if(Mocha.isSelected()){
            addIns.add("Mocha");
            currentPrice = currentPrice + 0.30;
        }

        if(size.equals("Short")){
            currentPrice = currentPrice + 1.89;
        }else if(size.equals("Tall")){
            currentPrice = currentPrice + 2.29;
        }else if(size.equals("Grande")){
            currentPrice = currentPrice + 2.69;
        }else if(size.equals("Venti")){
            currentPrice = currentPrice + 3.09;
        }

        for(int i=0; i<quantity; i++){
            Coffee newCoffee = new Coffee(size, addIns);
            //somehow adds to the basket

        }
        priceTotal.appendText("$" + (currentPrice * quantity));
        quantity = 0;
    }

}