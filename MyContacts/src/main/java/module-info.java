module com.example.mycontacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens challenge to javafx.fxml;
    exports challenge;
    exports challenge.datamodel;
    opens challenge.datamodel to javafx.fxml;
}