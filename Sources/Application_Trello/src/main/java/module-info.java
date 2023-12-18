module com.example.application_trello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.application_trello to javafx.fxml;
    exports com.example.application_trello;
}