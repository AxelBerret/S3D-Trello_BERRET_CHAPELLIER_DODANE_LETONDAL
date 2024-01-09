package com.example.application_trello.Views;
import com.example.application_trello.Controls.ControlBoutonsModifTache;
import com.example.application_trello.Objects.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
//Vue tache : vue qu'on va afficher dans une fenêtre externe a l'application lorsqu'on va cliquer sur une tache,
//pour afficher des informations complémentaires et personnaliser plus en détails les tâches.
//Classe écrite par Titouan
public class VueTache extends GridPane implements Observateur {

    private Tache t;
    private ObservableList<String> listeDep;
    private ObservableList<String> listeSousT;
    private ObservableList<String> vueDep;
    private ObservableList<String> vueSt;
    private String dependanceSelectionnee;
    private String sousTacheSelectionnee;
    private Tableau tab;
    private ListView<String> dependListView;

    public VueTache(Tache t, Tableau tab){// !!! !!! Ne pas oublier d'actualiser a la création
        this.t = t;
        this.tab = tab;
        this.listeDep = FXCollections.observableArrayList();
        this.listeSousT = FXCollections.observableArrayList();
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(10);
        this.setHgap(10);
        Label commentLabel = new Label("Commentaire:");
        commentLabel.setStyle("-fx-text-fill: white;-fx-font-size: 16;");

        TextArea commentTextArea = new TextArea("Commentaire de test");
        commentTextArea.setWrapText(true);


        // Éléments pour les dépendances
        Label dependLabel = new Label("Dépendances:");//Crée le label dépendances
        dependLabel.setStyle("-fx-text-fill: white;-fx-font-size: 16;");
        this.dependListView = new ListView<>();//Crée la boite ou les dépendances vont apparaitre
        ComboBox<String> dependComboBox = new ComboBox<>();
        dependComboBox.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-min-width: 110; -fx-text-fill: black;");

        dependComboBox.setItems(this.listeDep);//On met dans la comboBox les taches qui peuvent devenir des dépendances
        dependComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            dependanceSelectionnee = newValue; // Lorsqu'une selection est faite dans la comboBox, on modifie l'attribut dépendance séléctionnée.
        });
        Button addDependButton = new Button("Ajouter");
        addDependButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;");
        addDependButton.setOnMouseEntered(e -> addDependButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: black; -fx-text-fill: white;"));
        addDependButton.setOnMouseExited(e -> addDependButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;"));
        addDependButton.setId("addDependButton" + this.t.getNomTache());
        ControlBoutonsModifTache controleur = new ControlBoutonsModifTache(this.tab);
        addDependButton.setOnAction(controleur);


        // Éléments pour les sous-tâches
        Label sousTachesLabel = new Label("Sous-Tâches:");
        sousTachesLabel.setStyle("-fx-text-fill: white;-fx-font-size: 16;");
        ListView<String> sousTachesListView = new ListView<>();
        sousTachesListView.setItems(this.vueSt);
        ComboBox<String> sousTachesComboBox = new ComboBox<>();
        sousTachesComboBox.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-min-width: 110; -fx-text-fill: black;");
      sousTachesComboBox.setItems(this.listeSousT);//On met dans la comboBox les taches qui peuvent devenir des sous-tâches
        sousTachesComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            sousTacheSelectionnee = newValue; // Lorsqu'une selection est faite dans la comboBox, on modifie l'attribut sous-tache séléctionnée.
        });
        this.setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");

        Button addSousTacheButton = new Button("Ajouter");
        addSousTacheButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;");
        addSousTacheButton.setOnMouseEntered(e -> addSousTacheButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: black; -fx-text-fill: white;"));
        addSousTacheButton.setOnMouseExited(e -> addSousTacheButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;"));
        addSousTacheButton.setId("addSousTacheButton" + this.t.getNomTache());
        addSousTacheButton.setOnAction(controleur);
        Button saveButton = new Button("Enregistrer");
        saveButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;");
        saveButton.setOnMouseEntered(e -> saveButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: black; -fx-text-fill: white;"));
        saveButton.setOnMouseExited(e -> saveButton.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;"));
        saveButton.setOnAction(e -> {//Pour que la fenêtre se ferme lorsqu'on clique sur ce bouton
            Scene scene = this.getScene();
            ((Stage) scene.getWindow()).close();
            tab.supprimerObservateur(this);
        });

        this.add(commentLabel, 0, 0);
        this.add(commentTextArea, 1, 0);
        this.add(dependLabel, 0, 1);
        this.add(dependListView, 1, 1);
        this.add(dependComboBox, 0, 2);
        this.add(addDependButton, 1, 2);
        this.add(sousTachesLabel, 0, 3);
        this.add(sousTachesListView, 1, 3);
        this.add(sousTachesComboBox, 0, 4);
        this.add(addSousTacheButton, 1, 4);
        this.add(saveButton, 0, 5, 2, 1);
    }

    public void actualiser(Sujet s){
        ArrayList<Tache> lisAllTaches = ((Tableau)s).getListeTaches();//Stocke toutes les tâches du modèle
        Tache ta = ((Tableau)s).getTache(this.t.getNomTache());//On récupère la tache actuelle mise a jour
        ArrayList<Tache> listDepActuelles = ta.getListeDependances();//On recupere ses dépendances
        for (Tache t : listDepActuelles){//Pour chaque dependance
            this.vueDep.add(t.getNomTache());//On récupère son nom et on l'ajoute a la liste

        }
        dependListView.setItems(this.vueDep);//Affiche dans la boite les dépendances déjà mises en ajoutant l'observableList a la ListView
        lisAllTaches.removeAll(listDepActuelles);//Supprime les dépendances actuelles de la liste de toutes les tâches
        lisAllTaches.remove(this.t);//Supprime la tâche en modification de la liste de toutes les tâches
        for (Tache t : lisAllTaches){//On ajoute à la liste des dépendances possibles à l'ajout toutes les taches sauf celles qui sont deja les dépendances et la tache en question
            this.listeDep.add(t.getNomTache());
        }
        this.setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");
        //On fait la même chose pour les sous-tâches
        //Ces observablesLists serviront pour les comboBox lors de la modification d'une tâche
        //Et accessoirement donc lors de l'ajout de dépendances ou sous-tâches
        lisAllTaches = ((Tableau)s).getListeTaches();//On remet à 0 la liste de toutes les tâches
        if (t instanceof TacheComplexe){//Et si notre tâche est une tâche complexe (car sinon elle n'a pas de sous-tâche dans tous les cas)
            ArrayList<Tache> lisSousT = ((TacheComplexe) t).getListeTaches();//On récupère les sous-tâches déjà assignées à cette tâche
            lisAllTaches.removeAll(lisSousT);//On les enleve de la liste de toutes les tâches
            lisAllTaches.remove(this.t);//On enlève ensuite la tâche en question
            for (Tache tach : lisAllTaches){
                this.listeSousT.add(tach.getNomTache());//On ajoute tous les noms des autres tâches possibles dans l'observableList
            }
            TacheComplexe tc = (TacheComplexe) ((Tableau)s).getTache(t.getNomTache());
            ArrayList<Tache> lisStActuelles = tc.getListeTaches();//On recupere la liste de ses sous-taches
            for (Tache tach : lisStActuelles){
                this.vueSt.add(tach.getNomTache());//On met a jour l'attribut VueDep
            }
        }
    }

    public String getDependanceSelectionnee() {
        return this.dependanceSelectionnee;
    }

    public String getSousTacheSelectionnee(){
        return this.sousTacheSelectionnee;
    }

    }