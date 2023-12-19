package com.example.application_trello;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import java.util.Arrays;

public class VueTache extends Application {
    @Override
    public void start(Stage stage) {
        /*Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Modifier la Tâche");*/

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Ajoutez ici les éléments de l'interface utilisateur
        Label commentLabel = new Label("Commentaire:");
        TextArea commentTextArea = new TextArea("Commentaire de test");
        commentTextArea.setWrapText(true);

        // Éléments pour les dépendances
        Label dependLabel = new Label("Dépendances:");
        ListView<String> dependListView = new ListView<>();
        dependListView.setItems(FXCollections.observableArrayList("Dep1", "Dep2", "Dep3"));

        ComboBox<String> dependComboBox = new ComboBox<>();
        dependComboBox.setItems(FXCollections.observableArrayList("NouvelleDep1", "NouvelleDep2", "NouvelleDep3", "ExempleDep1", "ExempleDep2"));

        Button addDependButton = new Button("Ajouter");
        addDependButton.setOnAction(e -> {
            // Ajouter la nouvelle dépendance
            String nouvelleDependance = dependComboBox.getValue();
            if (nouvelleDependance != null && !nouvelleDependance.isEmpty()) {
                dependListView.getItems().add(nouvelleDependance);
                dependComboBox.setValue(null);
            }
        });

        // Éléments pour les sous-tâches
        Label subtaskLabel = new Label("Sous-Tâches:");
        ListView<String> subtaskListView = new ListView<>();
        subtaskListView.setItems(FXCollections.observableArrayList("SousTache1", "SousTache2", "SousTache3"));

        ComboBox<String> subtaskComboBox = new ComboBox<>();
        subtaskComboBox.setItems(FXCollections.observableArrayList("NouvelleSousTache1", "NouvelleSousTache2", "NouvelleSousTache3", "ExempleSousTache1", "ExempleSousTache2"));

        Button addSubtaskButton = new Button("Ajouter");
        addSubtaskButton.setOnAction(e -> {
            // Ajouter la nouvelle sous-tâche
            String nouvelleSousTache = subtaskComboBox.getValue();
            if (nouvelleSousTache != null && !nouvelleSousTache.isEmpty()) {
                subtaskListView.getItems().add(nouvelleSousTache);
                subtaskComboBox.setValue(null);
            }
        });

        // Vous pouvez ajouter d'autres éléments comme des listes déroulantes, des boutons, etc.

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(e -> {
            // Enregistrez les modifications ici
            String commentaire = commentTextArea.getText();
            // Vous pouvez obtenir la liste des dépendances depuis dependListView.getItems()
            // Vous pouvez obtenir la liste des sous-tâches depuis subtaskListView.getItems()

            // Faites quelque chose avec les données (par exemple, les passer au modèle)
            // tache.setCommentaire(commentaire);
            // tache.setDependances(dependListView.getItems());
            // tache.setSousTaches(subtaskListView.getItems());

            // Ajoutez d'autres mises à jour en fonction de vos besoins

            // Fermez la fenêtre
            stage.close();
        });

        grid.add(commentLabel, 0, 0);
        grid.add(commentTextArea, 1, 0);
        grid.add(dependLabel, 0, 1);
        grid.add(dependListView, 1, 1);
        grid.add(dependComboBox, 0, 2);
        grid.add(addDependButton, 1, 2);

        grid.add(subtaskLabel, 0, 3);
        grid.add(subtaskListView, 1, 3);
        grid.add(subtaskComboBox, 0, 4);
        grid.add(addSubtaskButton, 1, 4);

        grid.add(saveButton, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 750, 900);
        /*window.setScene(scene);
        window.showAndWait();*/

        // Create the scene with the main VBox

        // Set the stage title and scene
        stage.setTitle("Tableau JavaFX");
        stage.setScene(scene);

        // Show the stage in full screen
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
