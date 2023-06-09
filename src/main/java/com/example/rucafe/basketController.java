/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.example.rucafe.MainController.storeOrderListMain;

public class basketController implements Initializable {
    Scanner fileScanner = new Scanner(new File("coffeeFile.txt"));
    Scanner fileScanner2 = new Scanner(new File("donutsFile.txt"));

    File donutFile = new File("RUCafeProject4/src/main/donutsFile.txt");
    File coffeeFile = new File("RUCafeProject4/src/main/coffeeFile.txt");

    private MainController mainController;

    private ObservableList<String> orderedItems = FXCollections.observableArrayList();

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

    /**
     * declaring basket controller
     */
    public basketController() throws FileNotFoundException {
    }

    /**
     * connecting to the main controller
     * @param controller the main controller
     */
    public void setMainController(MainController controller) {this.mainController = controller;}
    ArrayList<MenuItem> basket = new ArrayList<MenuItem>(); //don't need this can reference from Order class



    /**
     * reads information about menuitems from file to put into basket
     */
    public void importFile() throws FileNotFoundException {
        addCoffees();
        addDonuts();

        basketList.setItems(orderedItems);
        CalculateCosts();
    }

    /**
     * Item is removed from the basket
     * @param e is the event that the remove button is selected
     */
    @FXML
    protected void onRemoveSelectedItem(ActionEvent e){
        int del = basketList.getSelectionModel().getSelectedIndex();
        if(del == -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No item has been selected to remove.");
            return;
        }
        //delete from observable list
        orderedItems.remove(del);

        //delete from the array
        currentOrder.getOrderList().remove(del);
        basketList.setItems(orderedItems);

        //recalculate after removing item!!!
        CalculateCosts();
    }

    /**
     * Places the order
     * @param e is the event that the place order button is selected
     */
    @FXML
    protected void onPlaceOrder(ActionEvent e) throws IOException {
        //puts the order into the
        currentOrder.setTotalPrice(CalculateCosts());
        storeOrderListMain.addOrder(currentOrder);


        //clears out the coffee file for a new order
        FileWriter clearWriter = new FileWriter("coffeeFile.txt", false);
        FileWriter clearWriter1 = new FileWriter("donutsFile.txt", false);

        clearWriter.write("");
        clearWriter1.write("");
        clearWriter.flush();
        clearWriter1.flush();


        basketList.getSelectionModel().clearSelection();


        donutFile.delete();
        coffeeFile.delete();

        clearWriter.close();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Placed!");
        alert.setContentText("The order has been placed and can be viewed in store orders!");
        alert.showAndWait();
    }


    /**
     * Calculates the basket's costs
     */
    protected double CalculateCosts(){
        subTotalCost = 0.0;

        //goes through the array and based on the item's type, adds that cost
        for(int i =0; i<currentOrder.getOrderList().size(); i++){
            subTotalCost = subTotalCost + currentOrder.getOrderList().get(i).itemPrice();
        }
        //displaying the costs
        subTotal.setText("$" + String.format("%.2f",(subTotalCost)));
        totalTax.setText("$" + String.format("%.2f",(subTotalCost*.06625)));
        totalCost.setText("$" + String.format("%.2f",(subTotalCost*1.06625)));

        return(Double.parseDouble(String.format("%.2f",(subTotalCost*1.06625))));
    }

    /**
     * Initializes the controller
     * @param location  creates location
     * @param resources intializes resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            importFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Reads from coffee file to create basket items
     */
    private void addCoffees() throws FileNotFoundException {
        if(!fileScanner.hasNextLine()){
            return;
        }
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            //list of add ins
            String tempList = line.substring(line.indexOf('[')+1, line.indexOf(']'));
            String tempArr[] = tempList.split(",");
            ArrayList addInList = new ArrayList<>();
            for(int i=0; i<tempArr.length; i++){
                if(tempArr[i].equals("sweetcream") || tempArr[i].equals(" sweetcream")){
                    addInList.add(AddIns.SWEETCREAM);
                }
                if(tempArr[i].equals("frenchvanilla") || tempArr[i].equals(" frenchvanilla")){
                    addInList.add(AddIns.FRENCHVANILLA);
                }
                if(tempArr[i].equals("irishcream") || tempArr[i].equals(" irishcream")){
                    addInList.add(AddIns.IRISHCREAM);
                }
                if(tempArr[i].equals("caramel") || tempArr[i].equals(" caramel")){
                    addInList.add(AddIns.CARAMEL);
                }
                if(tempArr[i].equals("mocha") || tempArr[i].equals(" mocha")){
                    addInList.add(AddIns.MOCHA);
                }
            }
            currentOrder.addCoffee(new Coffee(line.substring(8, (line.indexOf('A'))-1), addInList, Double.parseDouble(line.substring(line.indexOf('$')+1))));
            //display on the view
            orderedItems.add(line.substring(0, '$'));
        }
    }


    /**
     * Reads from donuts file to create basket items
     */
    private void addDonuts() throws FileNotFoundException {
        //reads through each line of the file of coffee

        if(!fileScanner2.hasNextLine()){
            return;
        }
        while (fileScanner2.hasNextLine()) {
            String line = fileScanner2.nextLine();

            String donutT = line.substring(0, line.indexOf("Donuts")+6);

            String donutF = line.substring(line.indexOf("Donuts")+7, line.indexOf("("));

            String quantity = (line.substring(line.indexOf("(")+1, line.indexOf(")")));
            double donutQuantity = Double.parseDouble(quantity);

            Donuts test = new Donuts(donutT, donutF, donutQuantity);
            currentOrder.addDonut(test);

            //display on the view
            orderedItems.add(line.substring(0, line.indexOf('$')));
        }
    }




}


