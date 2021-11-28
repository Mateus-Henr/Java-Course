module com.example.taskexample
{
    requires javafx.controls;
    requires javafx.fxml;

    exports tutorial.first;
    opens tutorial.first to javafx.fxml;
    exports tutorial.second;
    opens tutorial.second to javafx.fxml;
}