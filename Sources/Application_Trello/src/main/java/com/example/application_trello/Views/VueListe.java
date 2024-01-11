package com.example.application_trello.Views;

import com.example.application_trello.Controls.ControlModificationTache;
import com.example.application_trello.Objects.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

//Vue Liste : vue qu'on va afficher dans une fenêtre externe a l'application lorsqu'on va cliquer sur une tache,
//pour afficher la liste des taches de chaque colonne avec la possibilité d'acceder a la vue tache de chaque tache
//Classe écrite par Sacha

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
                Hyperlink hyperlinkTache = new Hyperlink(tache.getNomTache());
                hyperlinkTache.setStyle("-fx-text-fill: white; -fx-font-size: 20;");

                Tache ta = this.tableau.getTache(tache.getNomTache());
                ControlModificationTache cmt = new ControlModificationTache(this.tableau, ta);

                hyperlinkTache.setOnAction(cmt);
                getChildren().add(hyperlinkTache);
            }


        }
        setOnDragDetected(event -> {
            Dragboard db = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(nomColonne);  // Utilisez le nom de la colonne comme donnée de glisser-déposer
            db.setContent(content);
            event.consume();
        });

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
                // Déplacer la tâche en utilisant votre méthode deplacerTache
                tableau.deplacerTache(db.getString(), db.getString(), nomColonne);
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();
        });

        setOnDragDone(event -> {
            // Rafraîchissez l'affichage après le déplacement
            actualiser(tableau);
            event.consume();
        });
    }
}


