module com.example.bataille__ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bataille__ to javafx.fxml;
    exports com.example.bataille__;
}