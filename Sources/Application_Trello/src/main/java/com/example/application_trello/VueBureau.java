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

        VBox rightVBox = new VBox(10);
        rightVBox.setPadding(new Insets(10));
        rightVBox.setAlignment(Pos.CENTER);

        HBox rightHBox = new HBox(10);

        for (int i = 0; i < 5; i++) {  // Changement ici pour inclure la cinquième colonne
            VBox columnVBox;

            if (i < 4) {
                // Les quatre premières colonnes
                columnVBox = createTaskColumn(i + 1);
            } else {
                // Cinquième colonne spéciale
                columnVBox = createSpecialColumn();
            }

            rightHBox.getChildren().addAll(columnVBox);
            columnVBox.setOnMouseEntered(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 255, 0.05), CornerRadii.EMPTY, Insets.EMPTY))));
            columnVBox.setOnMouseExited(e -> columnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))));
            HBox.setMargin(columnVBox, new Insets(0, 0, 0, 50));
        }

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

    private VBox createTaskColumn(int index) {
        VBox columnVBox = new VBox(20);
        columnVBox.setMinWidth(200);
        columnVBox.setMinHeight(500);
        columnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        columnVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        columnVBox.setAlignment(Pos.TOP_CENTER);

        Label columnLabel;
        switch (index) {
            case 1:
                columnLabel = new Label("A faire");
                break;
            case 2:
                columnLabel = new Label("En cours");
                break;
            case 3:
                columnLabel = new Label("Terminé");
                break;
            case 4:
                columnLabel = new Label("Unknown");
                break;
            default:
                columnLabel = new Label("Unknown");
        }
        columnLabel.setPadding(new Insets(20));
        columnLabel.setAlignment(Pos.TOP_CENTER);

        HBox additionalButtonsRow = new HBox(10);
        additionalButtonsRow.setAlignment(Pos.CENTER);
        Button newButton1 = createIconButton("trombonne.png");
        Button newButton2 = createIconButton("croix.png");
        Button newButton3 = createIconButton("plus.png");
        additionalButtonsRow.getChildren().addAll(newButton1, newButton2, newButton3);

        Hyperlink clickableText = new Hyperlink("Task " + index);
        clickableText.setStyle("-fx-text-fill: black; -fx-underline: none;");

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER);
        Button trombonneButton = createIconButton("trombonne.png");
        Button croixButton = createIconButton("croix.png");
        buttonRow.getChildren().addAll(trombonneButton, croixButton);

        HBox taskInColumn = new HBox(10);
        taskInColumn.setPadding(new Insets(10));
        taskInColumn.getChildren().addAll(clickableText, buttonRow);

        Separator columnSeparator = new Separator();
        columnSeparator.setOrientation(Orientation.HORIZONTAL);
        columnSeparator.setStyle("-fx-background-color: black; -fx-min-height: 2px; -fx-pref-height: 2px; -fx-max-height: 2px;");

        columnVBox.getChildren().addAll(columnLabel, additionalButtonsRow, columnSeparator, taskInColumn);

        return columnVBox;
    }

    private VBox createSpecialColumn() {
        VBox specialColumnVBox = new VBox(20);
        specialColumnVBox.setMinWidth(200);
        specialColumnVBox.setMaxHeight(30);
        specialColumnVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        specialColumnVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        specialColumnVBox.setAlignment(Pos.TOP_CENTER);

        Label specialColumnLabel = new Label("Créer une colonne");
        specialColumnLabel.setPadding(new Insets(15));
        specialColumnLabel.setAlignment(Pos.CENTER);

        Button plusButton = createIconButton("plus.png");

        HBox specialColumnContent = new HBox(10);
        specialColumnContent.setAlignment(Pos.CENTER);
        specialColumnContent.getChildren().addAll(specialColumnLabel, plusButton);

        specialColumnVBox.getChildren().addAll(specialColumnContent);

        return specialColumnVBox;
    }

    private Button createIconButton(String imageName) {
        Image image = new Image("file:Image/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        imageView.setPreserveRatio(true);
        Button button = new Button("", imageView);
        button.setStyle("-fx-background-color: lightblue;");
        addHoverEffect(button);
        return button;
    }

    private void addHoverEffect(Button button) {
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: orange;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: lightblue;"));
    }

    public static void main(String[] args) {
        launch();
    }
}
