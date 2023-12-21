package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VueBureau extends Application {

    @Override
    public void start(Stage stage) {
        // Left VBox with 5 hyperlinks
        VBox leftVBox = new VBox(100);
        leftVBox.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 5; i++) {
            Hyperlink link = new Hyperlink("Link " + i);
            link.setStyle("-fx-font-size: 14;-fx-padding: 50; -fx-border-color: transparent; -fx-background-color: transparent;");
            link.setStyle("-fx-text-fill: black; -fx-underline: none;");
            link.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            VBox.setMargin(link, new Insets(30));
            link.setPadding(new Insets(10, 30, 10, 30));
            leftVBox.getChildren().add(link);
        }

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        VBox rightVBox = new VBox(20);
        rightVBox.setPadding(new Insets(20));
        rightVBox.setAlignment(Pos.CENTER);

        HBox rightHBox = new HBox(20);

        // Create task columns using VueColonne
        VueColonne columnAfaire = createColumn("A faire");
        VueColonne columnEnCours = createColumn("En cours");
        VueColonne columnTermine = createColumn("Terminé");

        // Add tasks to each column
        columnAfaire.addTask("Tache 1");
        columnAfaire.addTask("Tache 2");

        columnEnCours.addTask("Tache 1");
        columnEnCours.addTask("Tache 2");

        columnTermine.addTask("Tache 1");
        columnTermine.addTask("Tache 2");

        // Special column for creating a new column
        VueColonne createColumnColumn = createSpecialColumn();

        rightHBox.getChildren().addAll(columnAfaire, columnEnCours, columnTermine, createColumnColumn);
        rightHBox.setMargin(createColumnColumn, new Insets(0, 0, 0, 50));

        Button ganttButton = new Button("Création du Gantt");
        ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: white; -fx-text-fill: black;");
        VBox.setMargin(ganttButton, new Insets(30));
        ganttButton.setOnMouseEntered(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: black; -fx-text-fill: white;"));
        ganttButton.setOnMouseExited(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: white; -fx-text-fill: black;"));

        HBox mainHBox = new HBox(20, leftVBox, separator, rightVBox);
        mainHBox.setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");
        rightVBox.getChildren().addAll(rightHBox, ganttButton);

        Scene scene = new Scene(mainHBox, 900, 400);

        stage.setTitle("Hello JavaFX!");
        stage.setScene(scene);

        stage.show();
    }

    private VueColonne createColumn(String columnName) {
        VueColonne columnVBox = new VueColonne(columnName);
        columnVBox.setOnMouseEntered(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 255, 0.05), CornerRadii.EMPTY, Insets.EMPTY))));
        columnVBox.setOnMouseExited(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))));
        HBox.setMargin(columnVBox, new Insets(0, 0, 0, 50));
        return columnVBox;
    }

    private VueColonne createSpecialColumn() {
        VueColonne specialColumnVBox = new VueColonne();
        specialColumnVBox.setOnMouseEntered(e -> specialColumnVBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 255, 0.05), CornerRadii.EMPTY, Insets.EMPTY))));
        specialColumnVBox.setOnMouseExited(e -> specialColumnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))));
        return specialColumnVBox;
    }

    public static void main(String[] args) {
        launch();
    }
}
