module tutorial.musicui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens tutorial to javafx.fxml;
    exports tutorial;
}