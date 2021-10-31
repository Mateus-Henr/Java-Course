module com.example.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;

    exports tutorial.first;
    exports tutorial.second;
    exports tutorial.third;
    opens tutorial.first to javafx.fxml;
    opens tutorial.second to javafx.fxml;
    opens tutorial.third to javafx.fxml;
}