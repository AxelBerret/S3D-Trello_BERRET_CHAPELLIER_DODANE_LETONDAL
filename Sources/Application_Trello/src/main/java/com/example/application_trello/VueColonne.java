package com.example.application_trello;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class VueColonne extends VBox implements Observateur{

    private String columnLabel;

    public VueColonne(String columnName) {
        this.columnLabel = columnName;
        initialize();
    }

    public VueColonne() {
        this.columnLabel = "Créer une Colonne";
        initialize();
    }

    public VueColonne(Colonne c){
        this.columnLabel = c.getNomColonne();
        initialize();
    }

    private void initialize() {
        setMinWidth(200);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        setAlignment(Pos.TOP_CENTER);

        Label columnLabel = new Label(this.columnLabel);
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

        setOnDragOver(event -> {
            if (event.getGestureSource() != this && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                // Move the task to this column
                addTask(db.getString());
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();
        });
    }

    @Override
    public void actualiser(Sujet s) {

    }

<<<<<<< HEAD
    public String getColumnLabel() {
        return columnLabel;
=======
    public String getNomVueColonne() {
        return this.nomColonne;
>>>>>>> 37705b0451a08909944591deb903171f589bd3cb
    }

    public String getTaskName() {
        // Récupère le dernier élément ajouté à la colonne, qui est la tâche
        HBox taskInColumn = (HBox) getChildren().get(getChildren().size() - 1);
        Hyperlink clickableText = (Hyperlink) taskInColumn.getChildren().get(0);
        return clickableText.getText();
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

    public void removeTask(Hyperlink task) {
        getChildren().removeAll(task, task.getParent()); // Remove the task and its separator
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VueColonne that = (VueColonne) o;
        return Objects.equals(getColumnLabel(), that.getColumnLabel());
    }
}
