package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoffeeController {
    private MainController mainController;
    private int quantity = 1;
//    private double currentPrice = 1.89;
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
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    public void twoCoffee(ActionEvent actionEvent) {quantity = 2;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    public void threeCoffee(ActionEvent actionEvent) {quantity = 3;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    public void fourCoffee(ActionEvent actionEvent) {quantity = 4;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }
    public void fiveCoffee(ActionEvent actionEvent) {quantity = 5;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    @FXML
    protected void onSweetCreamSelected(Event e){
//        addIns.add(AddIns.SWEETCREAM);
//        currentPrice = currentPrice + AddIns.SWEETCREAM.getPrice();
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    @FXML
    protected void onFrenchVanillaSelected(Event e){
//        addIns.add(AddIns.FRENCHVANILLA);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    @FXML
    protected void onIrishCreamSelected(Event e){
//        addIns.add(AddIns.IRISHCREAM);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    @FXML
    protected void onCaramelSelected(Event e){
//        addIns.add(AddIns.CARAMEL);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

    @FXML
    protected void onMochaSelected(Event e){
//        addIns.add(AddIns.MOCHA);
//        currentPrice = currentPrice + 0.30;
//        priceTotal.setText("$" + String.format("%.2f",(currentPrice * quantity)));
        displayPrice();
    }

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

    @FXML
    protected void onAddToBasket(Event e) throws IOException {
        FileWriter myWriter = new FileWriter("coffeeFile.txt");
        double price = 0.0;
        String size = cupSize.getSelectedToggle().toString();
        size = size.substring(size.indexOf("'") +1, size.length() -1);

//        if(size.equals("Short")){
//            price = price + 1.89;
//        }else if(size.equals("Tall")){
//            price = price + 2.29;
//        }else if(size.equals("Grande")){
//            price = price + 2.69;
//        }else if(size.equals("Venti")){
//            price = price + 3.09;
//        }

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
            System.out.println(newCoffee.toString() + "$" + newCoffee.itemPrice() + "\n");
        }
        myWriter.close();
    }

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
//            addIns.add("Sweet Cream");
            currPrice = currPrice + AddIns.SWEETCREAM.getPrice();
        }
        if(FrenchVanilla.isSelected()){
//            addIns.add("French Vanilla");
            currPrice = currPrice + AddIns.FRENCHVANILLA.getPrice();
        }
        if(IrishCream.isSelected()){
//            addIns.add("Irish Cream");
            currPrice = currPrice + AddIns.IRISHCREAM.getPrice();
        }
        if(Caramel.isSelected()){
//            addIns.add("Caramel");
            currPrice = currPrice + AddIns.CARAMEL.getPrice();
        }
        if(Mocha.isSelected()){
//            addIns.add("Mocha");
            currPrice = currPrice + AddIns.MOCHA.getPrice();
        }

        priceTotal.setText("$" + String.format("%.2f",(currPrice * quantity)));
        return (currPrice * quantity);
    }


}