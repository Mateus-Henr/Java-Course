module com.example.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens tutorial to javafx.fxml;
    exports tutorial;
}