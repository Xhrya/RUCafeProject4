package com.example.rucafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DonutsController {
    private MainController mainController;

    @FXML
    ComboBox<String> donutsType;



    @FXML
    ListView donutFlavors;

    @FXML
    TextArea quantity;

    @FXML
    VBox runningTotal;

    int runningTotalCalculated;


    public void setMainController(MainController controller) {
        mainController = controller;
    }
    @FXML
    protected void onDonutTypeComboSelected()
    {

        donutsType = new ComboBox();
        donutsType.getItems().addAll(
                "Hole",
                "yeast",
                "cake"
        );
    }



    @FXML
    protected void onSelectDonut()
    {
        String donutType = donutsType.getId().toString();

        String donutFlavor = donutFlavors.getId().toString();

        int numberOfDonuts = Integer.parseInt(quantity.getText());
        double total=0;

        if(donutType.equals("yeast"))
        {
            total = 1.59 * numberOfDonuts;
        }
        else if(donutType.equals("cake")) {
            total = 1.79 * numberOfDonuts;

        }
        else if(donutType.equals("hole"))
        {
            total = 0.39 * numberOfDonuts;
        }

        runningTotal.setAccessibleText("$" + total);



    }

    @FXML
    protected void onAddToBasket()
    {
        //add to some sort of list of donuts to sent to basket
    }

    @FXML
    protected void onHomeButtonClick()
    {
        Stage mainView = new Stage();
        BorderPane root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeView.fxml"));
            root2 = (BorderPane) loader.load();
            Scene scene = new Scene(root2, 550, 700);
            mainView.setScene(scene);
            mainView.show();

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();

        }

    }




}

