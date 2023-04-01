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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DonutsController {
    private MainController mainController;

    @FXML
    ComboBox donutsType;

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
    protected void onAddDonut()
    {
        String donutType = donutsType.getId().toString();

        String donutFlavor = donutFlavors.getId().toString();

        int numberOfDonuts = Integer.parseInt(quantity.getText());

        if(donutType.equals("yeast"))
        {

        }
        else if(donutType.equals("cake")) {

        }
        else if(donutType.equals("hole"))
        {

        }



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

