package com.example.rucafe;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


import java.io.IOException;

public class MainController {
    private int value = 10;
    private MainController mainController;


    @FXML
    Button donutsView;

    @FXML
    Button coffeeView;

    //when one button or another is clicked, we will
    //open either the food or drinks window


    @FXML
    protected void onDonutsClickButton()
    {

        Stage donutsView = new Stage();
        BorderPane root;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("donutsView.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 550, 700);
            donutsView.setScene(scene);
            donutsView.show();
            DonutsController donutController = loader.getController();
            donutController.setMainController(this);

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
    protected void onCoffeeClickButton()
    {
        Stage coffeeView = new Stage();
        BorderPane root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffeeView.fxml"));
            root2 = (BorderPane) loader.load();
            Scene scene = new Scene(root2, 550, 700);
            coffeeView.setScene(scene);
            coffeeView.show();
            CoffeeController coffeeController = loader.getController();
            coffeeController.setMainController(this);

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
    protected void OnHomeButtonClick()
    {
        Stage homeView = new Stage();
        BorderPane root2;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeView.fxml"));
            root2 = (BorderPane) loader.load();
            Scene scene = new Scene(root2, 550, 700);
            homeView.setScene(scene);
            homeView.show();
            MainController homeController = loader.getController();
            homeController.setMainController(this);

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
    protected void onStoreOrdersClick()
    {

    }

    @FXML
    protected void onMyOrderClick()
    {

    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }
    public int getValue() {
        return value;
    }
}
