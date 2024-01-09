package com.example.application_trello.Views;

import com.example.application_trello.Objects.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueListe extends VBox implements Observateur {

    private Tableau tableau;
    private String nomColonne;

    public VueListe(Tableau tableau, String nomColonne) {
        this.tableau = tableau;
        this.nomColonne = nomColonne;
        initialize();
    }

    private void initialize() {
        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");

        actualiser(tableau);

        tableau.enregistrerObservateur(this);
    }

    @Override
    public void actualiser(Sujet s) {
        getChildren().clear();

        // Parcourir toutes les colonnes du tableau
        for (Colonne colonne : tableau.getListeColonnes()) {
            String nomColonne = colonne.getNomColonne();

            // Ajouter un label pour indiquer la colonne
            Label labelColonne = new Label(nomColonne);
            labelColonne.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 24;");

            getChildren().add(labelColonne);

            // Parcourir les tâches dans la colonne et les afficher
            for (Tache tache : colonne.getListeTaches()) {
                Label labelTache = new Label(tache.getNomTache());
                labelTache.setStyle("-fx-text-fill: white; -fx-font-size: 20;");

                getChildren().add(labelTache);
            }

        }
    }

}
