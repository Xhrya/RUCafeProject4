package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class basketController {
    private MainController mainController;

    public basketController() {
    }

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }
    ArrayList<MenuItem> basket = new ArrayList<MenuItem>();
    int itemNum=0;
    double subTotalCost = 0.0;
    @FXML
    TextField subTotal;
    @FXML
    TextField totalTax;
    @FXML
    TextField totalCost;
    @FXML
    ListView basketList;

    public void addToBasket(){
        basketList.getItems().addAll(basket);
        CalculateCosts();
    }

    @FXML
    protected void onRemoveClick(Event e){
        String del = basketList.getSelectionModel().getSelectedItems().toString();

        //find the item in the arr and delete
        //have to recalculate subtotal after removing item
        CalculateCosts();
    }

    protected void CalculateCosts(){
        subTotalCost = 0.0;
        //goes through the array and based on the item's type, adds that cost

        //displaying the costs
        subTotal.setText("" + subTotalCost);
        totalTax.setText("" + subTotalCost*.06625);
        totalCost.setText("" + subTotalCost*1.06625);
    }

}


