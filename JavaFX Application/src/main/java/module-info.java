module com.example.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;

    exports tutorial.first;
    exports tutorial.second;
    opens tutorial.first to javafx.fxml;
    opens tutorial.second to javafx.fxml;
}