package com.example.application_trello;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VueColonne extends VBox {

    public VueColonne(String columnName) {
        setMinWidth(300);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        setAlignment(Pos.TOP_CENTER);

        Label columnLabel = new Label(columnName);
        columnLabel.setPadding(new Insets(30));
        columnLabel.setAlignment(Pos.TOP_CENTER);

        HBox additionalButtonsRow = new HBox(15);
        additionalButtonsRow.setAlignment(Pos.CENTER);
        Button newButton1 = createIconButton("trombonne.png");
        Button newButton2 = createIconButton("croix.png");
        Button newButton3 = createIconButton("plus.png");
        additionalButtonsRow.getChildren().addAll(newButton1, newButton2, newButton3);
        additionalButtonsRow.setPadding(new Insets(20));
        getChildren().addAll(columnLabel, additionalButtonsRow);
    }

    public VueColonne() {
        setMinWidth(300);
        setMaxHeight(30);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        setAlignment(Pos.TOP_CENTER);
        Label columnLabel = new Label("Créer une Colonne");
        columnLabel.setAlignment(Pos.BASELINE_LEFT);
        columnLabel.setPadding(new Insets(30));
        Button plusButton = new Button("+");
        columnLabel.se(20);
        plusButton.setStyle("-fx-background-color: lightblue;");
        addHoverEffect(plusButton);

        getChildren().addAll(columnLabel, plusButton);
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
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: pink;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: lightblue;"));
    }

    public void addTask(String taskName) {
        Hyperlink clickableText = new Hyperlink(taskName);
        clickableText.setStyle("-fx-text-fill: black; -fx-underline: none;");

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER);
        Button trombonneButton = createIconButton("trombonne.png");
        Button croixButton = createIconButton("croix.png");
        buttonRow.getChildren().addAll(trombonneButton, croixButton);

        HBox taskInColumn = new HBox(10);
        taskInColumn.setPadding(new Insets(20));
        taskInColumn.getChildren().addAll(clickableText, buttonRow);

        Separator columnSeparator = new Separator();
        columnSeparator.setOrientation(Orientation.HORIZONTAL);
        columnSeparator.setStyle("-fx-background-color: black; -fx-min-height: 2px; -fx-pref-height: 2px; -fx-max-height: 2px;");

        getChildren().addAll(columnSeparator, taskInColumn);
    }
}
