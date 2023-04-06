module com.example.rucafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.rucafe to javafx.fxml;
    exports com.example.rucafe;
}