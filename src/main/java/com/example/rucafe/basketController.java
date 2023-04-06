package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class basketController implements Initializable {
    private MainController mainController;

    private ObservableList<String> orderedItems = FXCollections.observableArrayList();


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

    public basketController() {
    }

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }
    ArrayList<MenuItem> basket = new ArrayList<MenuItem>(); //don't need this can reference from Order class


//    public void addToBasket(){
//        basketList.getItems().addAll(basket);
//        CalculateCosts();
//    } --> what is this


    @FXML
    protected void onRemoveClick(Event e){
        String del = basketList.getSelectionModel().getSelectedItems().toString();

        //find the item in the arr and delete

        //basket.remove();



        //have to recalculate subtotal after removing item
        CalculateCosts();
    }

    protected void CalculateCosts(){
        subTotalCost = 0.0;
        //goes through the array and based on the item's type, adds that cost
        for(int i =0; i<basket.size(); i++){
            subTotalCost = subTotalCost + basket.get(i).itemPrice();
        }

        //displaying the costs
        subTotal.setText("" + subTotalCost);
        totalTax.setText("" + subTotalCost*.06625);
        totalCost.setText("" + subTotalCost*1.06625);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        basketList.getItems().clear();
        Order thisorder = new Order(); //do I need this?
        //iterate through orderList
        for(int i =0; i < thisorder.getOrderListSize(); i++) //how am I supposed to access this list?
        {
            orderedItems.add(thisorder.menuItemAsString(i));
        }
        basketList.setItems(orderedItems);
        CalculateCosts();
    }
}


