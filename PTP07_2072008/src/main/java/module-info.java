module com.example.ptp07_2072008 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.ptp07_2072008 to javafx.fxml;
    exports com.example.ptp07_2072008;
}