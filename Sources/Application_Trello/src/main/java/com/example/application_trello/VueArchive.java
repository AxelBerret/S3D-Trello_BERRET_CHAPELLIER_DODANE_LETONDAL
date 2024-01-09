package com.example.application_trello;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VueArchive extends VBox implements Observateur {

    private Tableau tableau;
    private String nomColonne;
    private ListView<Tache> listViewTachesArchivees;

    public VueArchive(Tableau tableau, String nomColonne) {
        this.tableau = tableau;
        this.nomColonne = nomColonne;
        initialize();
    }

    private void initialize() {
        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");

        // Initialiser la ListView pour afficher les tâches archivées
        listViewTachesArchivees = new ListView<>();
        getChildren().add(listViewTachesArchivees);

        actualiser(tableau);

        tableau.enregistrerObservateur(this);
    }

    public void actualiser(Sujet s) {
        getChildren().clear();

        // Ajouter un label pour indiquer la vue archive
        Label labelVueArchive = new Label("Vue Archive");
        labelVueArchive.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 24;");
        getChildren().add(labelVueArchive);

        // Créer un TextField pour afficher les tâches archivées
        TextField textFieldVueArchive = new TextField();
        textFieldVueArchive.setEditable(false); // Pour rendre le TextField en lecture seule
        textFieldVueArchive.setStyle("-fx-font-size: 16; -fx-pref-height: 300; -fx-pref-width: 400;-fx-text-fill: black;"); // Ajustez selon vos préférences


        System.out.println("ahhh");

        // Parcourir les tâches archivées et les afficher
        for (Tache tache : tableau.getListeTachesArchives()) {
            System.out.println("ahhh"+ tache.getNomTache());
            textFieldVueArchive.appendText(tache.getNomTache() + "\n");
        }

        // Ajouter le TextField à la vue
        getChildren().add(textFieldVueArchive);
    }

}
