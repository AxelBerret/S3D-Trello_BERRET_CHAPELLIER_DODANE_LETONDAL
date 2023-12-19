package com.example.application_trello;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.application.Platform;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

import java.util.ArrayList;
import java.util.Arrays;

public class VueTache extends Application {

    private Tache t;
    private ObservableList<String> listeDep;
    private ObservableList<String> listeSousT;

    public VueTache(Tache t){
        this.t = t;
        this.listeDep = FXCollections.observableArrayList();
        this.listeSousT = FXCollections.observableArrayList();
        //observableList.add("Element 1");
    }

    public void actualiser(Sujet s){
        ArrayList<Tache> lisAllTaches = ((Tableau)s).getListeTaches();
        ArrayList<Tache> lisD = this.t.getListeDependances();
        lisAllTaches.removeAll(lisD);
        lisAllTaches.remove(this.t);
        for (Tache t : lisAllTaches){//On ajoute a la liste des dependances possibles toutes les taches sauf celles qui sont deja les dependances et la tache en question
            this.listeDep.add(t.getNomTache());
        }

        //On fait la même chose pour les sous-tâches
        //Ces observablesLists serviront pour les comboBox lors de la modification d'une tâche
        //Et accessoirement donc lors de l'ajout de dépendances ou sous-tâches
        lisAllTaches = ((Tableau)s).getListeTaches();//On remet à 0 la liste de toutes les tâches
        if (t instanceof TacheComplexe){//Et si notre tâche est une tâche complexe (car sinon elle n'a pas de sous-tâche dans tous les cas)
            ArrayList<Tache> lisSousT = ((TacheComplexe) t).getListeTaches();//On récupère les sous-tâches déjà assignées à cette tâche
            lisAllTaches.removeAll(lisSousT);//On les enleve de la liste de toutes les tâches
            lisAllTaches.remove(this.t);//On enleve ensuite la tâche en question
            for (Tache t : lisAllTaches){
                this.listeDep.add(t.getNomTache());//On ajoute tous les noms des tâches possibles dans l'observableList
            }
        }
    }

    public

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
        dependComboBox.setItems(this.listeDep);

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
        subtaskComboBox.setItems(this.listeSousT);

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
