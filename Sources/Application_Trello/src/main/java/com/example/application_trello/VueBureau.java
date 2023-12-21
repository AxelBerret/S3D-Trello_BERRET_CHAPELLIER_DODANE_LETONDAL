package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
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
            link.setOnMouseEntered(e -> link.setStyle(" -fx-background-color: white; -fx-text-fill: black;"));
            link.setOnMouseExited(e -> link.setStyle("-fx-background-color: transparent; -fx-text-fill: black;"));

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

        // Ajoutez un gestionnaire d'événements pour le drag-and-drop
        setDragDropHandlers(columnVBox);

        return columnVBox;
    }

    private VueColonne createSpecialColumn() {
        VueColonne specialColumnVBox = new VueColonne();

        // Ajoutez un gestionnaire d'événements pour le drag-and-drop
        setDragDropHandlers(specialColumnVBox);

        return specialColumnVBox;
    }

    // Méthode pour définir les gestionnaires d'événements de glisser-déposer
    private void setDragDropHandlers(VueColonne columnVBox) {
        columnVBox.setOnDragDetected(event -> {
            // Commence le glisser-déposer
            Dragboard db = columnVBox.startDragAndDrop(TransferMode.MOVE);

            // Ajoute les données à transférer (ici, le nom de la colonne)
            ClipboardContent content = new ClipboardContent();
            content.putString(columnVBox.getColumnLabel());
            db.setContent(content);

            event.consume();
        });

        columnVBox.setOnDragOver(event -> {
            // Autorise le déplacement si les données sont du type attendu
            if (event.getGestureSource() != columnVBox && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }

            event.consume();
        });

        columnVBox.setOnDragDropped(event -> {
            // Récupère le contenu des données déposées
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                // Ajoute la tâche à la colonne actuelle
                columnVBox.addTask(db.getString());
                success = true;
            }

            // Indique que le déplacement est terminé
            event.setDropCompleted(success);
            event.consume();
        });

        columnVBox.setOnDragDone(DragEvent::consume);
    }

    public static void main(String[] args) {
        launch();
    }
}
