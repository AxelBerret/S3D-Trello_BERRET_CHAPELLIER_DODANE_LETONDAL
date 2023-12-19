package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        // Right VBox with HBox, rectangles, and "Gant" button
        VBox rightVBox = new VBox(10); // Added spacing
        rightVBox.setPadding(new Insets(10)); // Added padding

        // HBox in the right VBox
        HBox rightHBox = new HBox(10); // Added spacing

        // Create 4 rectangles with specified properties
        for (int i = 0; i < 4; i++) {
            Rectangle rectangle = new Rectangle(100, 400);
            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);
            rectangle.setFill(Color.LIGHTGRAY);

            rightHBox.getChildren().add(rectangle);
        }

        // Button "Gant" in the right VBox
        Button gantButton = new Button("Gant");
        gantButton.setStyle("-fx-font-size: 16; -fx-padding: 10 20;");
        rightVBox.getChildren().addAll(rightHBox, gantButton);

        // Main HBox with left and right VBoxes
        HBox mainHBox = new HBox(20, leftVBox, rightVBox); // Added spacing

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
