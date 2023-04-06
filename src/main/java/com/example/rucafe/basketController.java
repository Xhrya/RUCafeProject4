package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class basketController implements Initializable {
    private MainController mainController;

    private ObservableList<String> orderedItems = FXCollections.observableArrayList();

    int itemNum=0;
    Order currentOrder = new Order();
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

    public void setMainController(MainController controller) {this.mainController = controller;}
    ArrayList<MenuItem> basket = new ArrayList<MenuItem>(); //don't need this can reference from Order class


//    public void addToBasket(){
//        basketList.getItems().addAll(basket);
//        CalculateCosts();
//    } --> what is this

    public void importFile() throws FileNotFoundException {
        //reads through each line of the file of coffee
        Scanner fileScanner = new Scanner(new File("coffeeFile.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

//            //list of add ins
//            String tempList = line.substring(line.indexOf('['), line.indexOf(']')+1);
//            String tempArr[] = tempList.split(",");
//            ArrayList addInList = new ArrayList<>();
//            for(int i=0; i<tempArr.length; i++){
//                if(tempArr[i].equals("SWEETCREAM")){
//                    addInList.add(AddIns.SWEETCREAM);
//                }
//                if(tempArr[i].equals("FRENCHVANILLA")){
//                    addInList.add(AddIns.FRENCHVANILLA);
//                }
//                if(tempArr[i].equals("IRISHCREAM")){
//                    addInList.add(AddIns.IRISHCREAM);
//                }
//                if(tempArr[i].equals("CARAMEL")){
//                    addInList.add(AddIns.CARAMEL);
//                }
//                if(tempArr[i].equals("MOCHA")){
//                    addInList.add(AddIns.MOCHA);
//                }
//            }
//            //adding the coffee to the order
//
//            currentOrder.addCoffee(new Coffee(line.substring(6, (line.indexOf('A'))+1), addInList,Double.parseDouble(line.substring(line.indexOf('$')))));
//            //display on the view
            orderedItems.add(line.substring(0, '$'));
        }
        basketList.setItems(orderedItems);
        CalculateCosts();
        //adds to order

        //tmew i will fix this to calcuate costs, removeclick, + system testing

    }


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
        for(int i =0; i<currentOrder.getOrderList().size(); i++){
            subTotalCost = subTotalCost + currentOrder.getOrderList().get(i).itemPrice();
        }

        //displaying the costs
        subTotal.setText("" + subTotalCost);
        totalTax.setText("" + subTotalCost*.06625);
        totalCost.setText("" + subTotalCost*1.06625);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            importFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        basketList.getItems().clear();
//        Order thisorder = new Order(); //do I need this?
//        //iterate through orderList
//        for(int i =0; i < thisorder.getOrderListSize(); i++) //how am I supposed to access this list?
//        {
//            orderedItems.add(thisorder.menuItemAsString(i));
//        }
//        basketList.setItems(orderedItems);
//        CalculateCosts();
    }
}


