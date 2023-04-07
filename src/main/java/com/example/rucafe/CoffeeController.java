/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoffeeController {
    private MainController mainController;
    private int quantity = 1;
//    private double currentPrice = 1.89;
    ArrayList addIns = new ArrayList();

    public CoffeeController() throws IOException {
    }

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

    /**
     * Updates price if quantity is changed
     */
    public void oneCoffee(ActionEvent actionEvent) {quantity = 1;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    /**
     * Updates price if quantity is changed
     */
    public void twoCoffee(ActionEvent actionEvent) {quantity = 2;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    /**
     * Updates price if quantity is changed
     */
    public void threeCoffee(ActionEvent actionEvent) {quantity = 3;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    /**
     * Updates price if quantity is changed
     */
    public void fourCoffee(ActionEvent actionEvent) {quantity = 4;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    /**
     * Updates price if quantity is changed
     */
    public void fiveCoffee(ActionEvent actionEvent) {quantity = 5;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if this add-in is selected
     */
    @FXML
    protected void onSweetCreamSelected(Event e){
//        addIns.add(AddIns.SWEETCREAM);
//        currentPrice = currentPrice + AddIns.SWEETCREAM.getPrice();
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if this add-in is selected
     */
    @FXML
    protected void onFrenchVanillaSelected(Event e){
//        addIns.add(AddIns.FRENCHVANILLA);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if this add-in is selected
     */
    @FXML
    protected void onIrishCreamSelected(Event e){
//        addIns.add(AddIns.IRISHCREAM);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if this add-in is selected
     */
    @FXML
    protected void onCaramelSelected(Event e){
//        addIns.add(AddIns.CARAMEL);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if this add-in is selected
     */
    @FXML
    protected void onMochaSelected(Event e){
//        addIns.add(AddIns.MOCHA);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    /**
     * Updates price if size is changed
     */
    @FXML
    protected void onGetSize(Event e){
//        String size = cupSize.getSelectedToggle().toString();
//        size = size.substring(size.indexOf("'") +1, size.length() -1);

//        if(size.equals("Short")){
//            currentPrice = currentPrice + 1.89;
//        }else if(size.equals("Tall")){
//            currentPrice = currentPrice + 2.29;
//        }else if(size.equals("Grande")){
//            currentPrice = currentPrice + 2.69;
//        }else if(size.equals("Venti")){
//            currentPrice = currentPrice + 3.09;
//        }

        displayPrice();
    }

    /**
     * Adds the coffee to the basket
     * @param e is the event that the add button is clicked
     */
    @FXML
    protected void onAddToBasket(Event e) throws IOException {
        File coffeeFile = new File("RUCafeProject4/src/main/coffeeFile.txt");

        FileWriter myWriter = new FileWriter("coffeeFile.txt", true);
        double price = 0.0;
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);

        if(SweetCream.isSelected()){
            addIns.add(AddIns.SWEETCREAM);
//            price += AddIns.SWEETCREAM.getPrice();
        }
        if(FrenchVanilla.isSelected()){
            addIns.add(AddIns.FRENCHVANILLA);
//            price += AddIns.FRENCHVANILLA.getPrice();
        }
        if(IrishCream.isSelected()){
            addIns.add(AddIns.IRISHCREAM);
//            price += AddIns.IRISHCREAM.getPrice();
        }
        if(Caramel.isSelected()){
            addIns.add(AddIns.CARAMEL);
//            price += AddIns.CARAMEL.getPrice();
        }
        if(Mocha.isSelected()){
            addIns.add(AddIns.MOCHA);
//            price += AddIns.MOCHA.getPrice();
        }

       price = (displayPrice()/quantity);
        for(int i=0; i<quantity; i++){
            Coffee newCoffee = new Coffee(size, addIns, price);

            //EXPORTS TO A FILE
            myWriter.write(newCoffee.toString() + "$" + newCoffee.itemPrice() + "\n");
//            System.out.println(newCoffee.toString() + "$" + newCoffee.itemPrice() + "\n");
        }
        myWriter.close();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation!!");
        alert.setHeaderText("Add to Basket!");
        alert.setContentText("Adding Coffee to Basket Confirmed!");
        alert.showAndWait();
    }

    /**
     * Helper method to update the running price
     */
    private double displayPrice(){
        double currPrice = 0.0;
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);

        if(size.equals("Short")){
            currPrice = currPrice + 1.89;
        }else if(size.equals("Tall")){
            currPrice = currPrice + 2.29;
        }else if(size.equals("Grande")){
            currPrice = currPrice + 2.69;
        }else if(size.equals("Venti")){
            currPrice = currPrice + 3.09;
        }

        if(SweetCream.isSelected()){
            currPrice = currPrice + AddIns.SWEETCREAM.getPrice();
        }
        if(FrenchVanilla.isSelected()){
            currPrice = currPrice + AddIns.FRENCHVANILLA.getPrice();
        }
        if(IrishCream.isSelected()){
            currPrice = currPrice + AddIns.IRISHCREAM.getPrice();
        }
        if(Caramel.isSelected()){
            currPrice = currPrice + AddIns.CARAMEL.getPrice();
        }
        if(Mocha.isSelected()){
            currPrice = currPrice + AddIns.MOCHA.getPrice();
        }

        priceTotal.setText("$" + String.format("%.2f",(currPrice * quantity)));
        return (currPrice * quantity);
    }


}