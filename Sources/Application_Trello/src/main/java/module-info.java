module com.example.application_trello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.application_trello to javafx.fxml;
    exports com.example.application_trello;
    exports com.example.application_trello.Objects;
    opens com.example.application_trello.Objects to javafx.fxml;
    exports com.example.application_trello.Controls;
    opens com.example.application_trello.Controls to javafx.fxml;
    exports com.example.application_trello.Views;
    opens com.example.application_trello.Views to javafx.fxml;
}