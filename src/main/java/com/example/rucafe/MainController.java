package com.example.rucafe;

import javafx.fxml.FXML;
import javafx.event.Event;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


import java.io.IOException;

public class MainController {
    private int value = 10;

    @FXML
    Button foodView;

    @FXML
    Button drinksView;

    //when one button or another is clicked, we will
    //open either the food or drinks window


    @FXML
    protected void onFoodButtonClick()
    {

        Stage foodView = new Stage();
        BorderPane root;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("foodView.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            foodView.setScene(scene);
            foodView.show();
            FoodController foodController = loader.getController();
            foodController.setMainController(this);

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();

        }



    }

    @FXML
    protected void onDrinksButtonClick()
    {
        Stage drinksView = new Stage();
        BorderPane root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("drinksView.fxml"));
            root2 = (BorderPane) loader.load();
            Scene scene = new Scene(root2, 500, 400);
            drinksView.setScene(scene);
            drinksView.show();
            DrinksController drinksController = loader.getController();
            drinksController.setMainController(this);

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();

        }

    }
    public int getValue() {
        return value;
    }
}
