package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CoffeeController {
    private MainController mainController;
    private int quantity = 1;
    private double currentPrice = 0.0;

    ArrayList addIns = new ArrayList();

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
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }
    public void twoCoffee(ActionEvent actionEvent) {quantity = 2;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }
    public void threeCoffee(ActionEvent actionEvent) {quantity = 3;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }
    public void fourCoffee(ActionEvent actionEvent) {quantity = 4;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }
    public void fiveCoffee(ActionEvent actionEvent) {quantity = 5;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onSweetCreamSelected(Event e){
        addIns.add("Sweet Cream");
        currentPrice = currentPrice + 0.30;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onFrenchVanillaSelected(Event e){
        addIns.add("French Vanilla");
        currentPrice = currentPrice + 0.30;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onIrishCreamSelected(Event e){
        addIns.add("Irish Cream");
        currentPrice = currentPrice + 0.30;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onCaramelSelected(Event e){
        addIns.add("Caramel");
        currentPrice = currentPrice + 0.30;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onMochaSelected(Event e){
        addIns.add("Irish Cream");
        currentPrice = currentPrice + 0.30;
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onGetSize(Event e){
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);

        if(size.equals("Short")){
            currentPrice = currentPrice + 1.89;
        }else if(size.equals("Tall")){
            currentPrice = currentPrice + 2.29;
        }else if(size.equals("Grande")){
            currentPrice = currentPrice + 2.69;
        }else if(size.equals("Venti")){
            currentPrice = currentPrice + 3.09;
        }

        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
    }

    @FXML
    protected void onAddToBasket(Event e){
        double price = 0.0;
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);


        if(SweetCream.isSelected()){
            addIns.add("Sweet Cream");
            price = price + 0.30;
        }
        if(FrenchVanilla.isSelected()){
            addIns.add("French Vanilla");
            price = price + 0.30;
        }
        if(IrishCream.isSelected()){
            addIns.add("Irish Cream");
            price = price + 0.30;
        }
        if(Caramel.isSelected()){
            addIns.add("Caramel");
            price = price + 0.30;
        }
        if(Mocha.isSelected()){
            addIns.add("Mocha");
            price = price + 0.30;
        }

        if(size.equals("Short")){
            price = price + 1.89;
        }else if(size.equals("Tall")){
            price = price + 2.29;
        }else if(size.equals("Grande")){
            price = price + 2.69;
        }else if(size.equals("Venti")){
            price = price + 3.09;
        }
        for(int i=0; i<quantity; i++){
            Coffee newCoffee = new Coffee(size, addIns, price);
            price = 0.0;
            //somehow adds to the basket

        }
        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        quantity = 0;
    }

}