module org.example.parcial_v1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.example.parcial_v1 to javafx.fxml;
    exports org.example.parcial_v1;
    exports org.example.parcial_v1.controllers;
    opens org.example.parcial_v1.controllers to javafx.fxml;
}