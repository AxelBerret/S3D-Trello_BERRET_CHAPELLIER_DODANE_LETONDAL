package com.example.application_trello;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class VueTache extends GridPane {

    private Tache t;
    private ObservableList<String> listeDep;
    private ObservableList<String> listeSousT;
    private ObservableList<String> vueDep;
    private ObservableList<String> vueSt;
    private String dependanceSelectionnee;

    public VueTache(Tache t){// !!! !!! Ne pas oublier d'actualiser a la création
        this.t = t;
        this.listeDep = FXCollections.observableArrayList();
        this.listeSousT = FXCollections.observableArrayList();
        GridPane grid = new GridPane();
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setVgap(10);
        this.setHgap(10);
        Label commentLabel = new Label("Commentaire:");
        TextArea commentTextArea = new TextArea("Commentaire de test");
        commentTextArea.setWrapText(true);

        // Éléments pour les dépendances
        Label dependLabel = new Label("Dépendances:");
        ListView<String> dependListView = new ListView<>();
        dependListView.setItems(this.vueDep);

        ComboBox<String> dependComboBox = new ComboBox<>();
        dependComboBox.setItems(this.listeDep);

        Button addDependButton = new Button("Ajouter");
        addDependButton.setId("addDependButton" + this.t.getNomTache());
        addDependButton.setOnAction(e -> {//Créer controleur
            // Ajouter la nouvelle dépendance
            this.dependanceSelectionnee = dependComboBox.getValue();
            if (dependanceSelectionnee != null && !dependanceSelectionnee.isEmpty()) {
                dependListView.getItems().add(dependanceSelectionnee);
                dependComboBox.setValue(null);
            }
        });
        addDependButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                this.dependanceSelectionnee = dependComboBox.getValue();
                if (dependanceSelectionnee != null && !dependanceSelectionnee.isEmpty()) {
                    dependListView.getItems().add(dependanceSelectionnee);
                    dependComboBox.setValue(null);
                }

                // Créer le contrôleur
                ControlBoutonsModifTache controleur = new ControlBoutonsModifTache();//Passer en parametre la dependance a ajouter

                // Appeler la méthode du contrôleur
                monControleur.handle(event);
            }
        });

        // Éléments pour les sous-tâches
        Label subtaskLabel = new Label("Sous-Tâches:");
        ListView<String> subtaskListView = new ListView<>();
        subtaskListView.setItems(this.vueSt);

        ComboBox<String> subtaskComboBox = new ComboBox<>();
        subtaskComboBox.setItems(this.listeSousT);

        Button addSubtaskButton = new Button("Ajouter");
        addSubtaskButton.setOnAction(e -> {//Créer controleur
            // Ajouter la nouvelle sous-tâche
            String nouvelleSousTache = subtaskComboBox.getValue();
            if (nouvelleSousTache != null && !nouvelleSousTache.isEmpty()) {
                subtaskListView.getItems().add(nouvelleSousTache);
                subtaskComboBox.setValue(null);
                ActionEvent event = new ActionEvent(null, addDependButton);
                event.setUserData(dependanceSelectionnee);

                // Passer l'événement modifié au gestionnaire
                addDependButton.fireEvent(eventWithUserData);
            }
        });


        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(e -> {//Faire contrôleur
        });

        this.add(commentLabel, 0, 0);
        this.add(commentTextArea, 1, 0);
        this.add(dependLabel, 0, 1);
        this.add(dependListView, 1, 1);
        this.add(dependComboBox, 0, 2);
        this.add(addDependButton, 1, 2);
        this.add(subtaskLabel, 0, 3);
        this.add(subtaskListView, 1, 3);
        this.add(subtaskComboBox, 0, 4);
        this.add(addSubtaskButton, 1, 4);
        this.add(saveButton, 0, 5, 2, 1);
    }

    public void actualiser(Sujet s){
        ArrayList<Tache> lisAllTaches = ((Tableau)s).getListeTaches();
        ArrayList<Tache> lisD = this.t.getListeDependances();
        lisAllTaches.removeAll(lisD);
        lisAllTaches.remove(this.t);
        for (Tache t : lisAllTaches){//On ajoute a la liste des dependances possibles toutes les taches sauf celles qui sont deja les dependances et la tache en question
            this.listeDep.add(t.getNomTache());
        }
        Tache ta = ((Tableau)s).getTache(this.t.getNomTache());//On récupère la tache actuelle mise a jour
        ArrayList<Tache> listDepActuelles = ta.getListeDependances();//On recupere ses dépendances
        for (Tache t : listDepActuelles){//Pour chaque dependance
            this.vueDep.add(t.getNomTache());//On récupère son nom et on l'ajoute a la liste
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
                this.listeSousT.add(t.getNomTache());//On ajoute tous les noms des tâches possibles dans l'observableList
            }
            TacheComplexe tc = (TacheComplexe) ((Tableau)s).getTache(this.t.getNomTache());
            ArrayList<Tache> lisStActuelles = tc.getListeTaches();//On recupere la liste de ses sous-taches
            for (Tache t : lisStActuelles){
                this.vueSt.add(t.getNomTache());//On met a jour l'attribut VueDep
            }
        }
    }

    public String getDependanceSelectionnee() {
        return this.dependanceSelectionnee;
    }

    }