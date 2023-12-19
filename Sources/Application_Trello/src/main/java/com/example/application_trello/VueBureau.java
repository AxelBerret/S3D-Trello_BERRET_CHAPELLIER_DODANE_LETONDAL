package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VueBureau extends Application {
    @Override
    public void start(Stage stage) {
        // Left VBox with 5 buttons
        VBox leftVBox = new VBox(10); // Added spacing
        leftVBox.setPadding(new Insets(10)); // Added padding
        for (int i = 1; i <= 5; i++) {
            Button button = new Button("Button " + i);
            button.setStyle("-fx-font-size: 14; -fx-padding: 10 20;");
            leftVBox.getChildren().add(button);
        }

        // Right VBox with HBox, rectangles, and "Gantt" button
        VBox rightVBox = new VBox(10); // Added spacing
        rightVBox.setPadding(new Insets(10)); // Added padding

        // HBox in the right VBox
        HBox rightHBox = new HBox(10); // Added spacing

        // Create tasks in each column
        for (int i = 0; i < 4; i++) {
            VBox columnVBox = new VBox(20); // Added spacing
            columnVBox.setMinWidth(200); // Set minimum width to 200 pixels
            columnVBox.setMinHeight(500); // Set minimum height to 500 pixels
            columnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            columnVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

            // Label for column title
            Label columnLabel;
            switch (i) {
                case 0:
                    columnLabel = new Label("A faire");
                    break;
                case 1:
                    columnLabel = new Label("En cours");
                    break;
                case 2:
                    columnLabel = new Label("Terminé");
                    break;
                default:
                    columnLabel = new Label("Unknown");
            }

            // Center the title horizontally
            columnLabel.setAlignment(Pos.CENTER);

            // Hyperlink and buttons for each task
            Hyperlink clickableText = new Hyperlink("Task " + (i + 1));
            Button button1 = new Button("B1");
            Button button2 = new Button("B2");

            // HBox for each task
            HBox taskInColumn = new HBox(10); // Added spacing
            taskInColumn.setPadding(new Insets(10)); // Added padding
            taskInColumn.getChildren().addAll(clickableText, button1, button2);
            columnVBox.getChildren().addAll(columnLabel, taskInColumn);
            rightHBox.getChildren().add(columnVBox);

            // Add hover effect to the columnVBox
            columnVBox.setOnMouseEntered(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.rgb(255, 165, 0, 0.05), CornerRadii.EMPTY, Insets.EMPTY))));
            columnVBox.setOnMouseExited(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))));
        }

        // Styling the "Gantt" button
        Button ganttButton = new Button("Gantt");
        ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: blue; -fx-text-fill: white;");

        // Add hover effect to the "Gantt" button
        ganttButton.setOnMouseEntered(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: orange; -fx-text-fill: white;"));
        ganttButton.setOnMouseExited(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: blue; -fx-text-fill: white;"));

        // Main HBox with left and right VBoxes
        HBox mainHBox = new HBox(20, leftVBox, rightVBox); // Added spacing
        rightVBox.getChildren().addAll(rightHBox, ganttButton);

        // Create the scene with the main HBox
        Scene scene = new Scene(mainHBox, 900, 400);

        // Set the stage title and scene
        stage.setTitle("Hello JavaFX!");
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
