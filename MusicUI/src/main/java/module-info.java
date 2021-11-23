module tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens tutorial to javafx.fxml;
    opens tutorial.model to javafx.fxml;
    opens myUpdates to javafx.fxml;
    opens myUpdates.model to javafx.fxml;

    exports tutorial;
    exports tutorial.model;
    exports myUpdates;
    exports myUpdates.model;
}