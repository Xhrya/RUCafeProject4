/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private MainController mainController;
    File coffeeFile = new File("RUCafeProject4/src/main/coffeeFile.txt");
    protected static StoreOrders storeOrderListMain;




    //when one button or another is clicked, we will
    //open either the food or drinks window


    //here, I will be storing myCurrentOrder and storeOrder for ease of access


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
            DonutsController donutsController = loader.getController();
            donutsController.setMainController(this);

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
    protected void OnHomeButtonClick(ActionEvent actionEvent)
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
    protected void onStoreOrdersClick(ActionEvent actionEvent)
    {
        Stage storeOrderView = new Stage();
        BorderPane root3;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeOrderView.fxml"));
            root3 = (BorderPane) loader.load();
            Scene scene = new Scene(root3, 550, 700);
            storeOrderView.setScene(scene);
            storeOrderView.setTitle("Store Orders");
            storeOrderView.show();
            StoreOrderController storeController = loader.getController();
            storeController.setMainController(this);

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading storeOrderView.fxml.");
            alert.setContentText("Couldn't load storeOrderView.fxml.");
            alert.showAndWait();

        }
    }

    @FXML
    protected void onMyOrderClick(ActionEvent actionEvent)
    {
        Stage basketView = new Stage();
        AnchorPane root4;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("basketView.fxml"));
            root4 = (AnchorPane) loader.load();
            Scene scene = new Scene(root4, 550, 700);
            basketView.setScene(scene);
            basketView.show();
            basketController basket = loader.getController();
            basket.setMainController(this);

        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading basketView.fxml.");
            alert.setContentText("Couldn't load basketView.fxml.");
            alert.showAndWait();

        }
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storeOrderListMain = new StoreOrders();
    }
}