package com.example.application_trello.Views;

import com.example.application_trello.Controls.ControlDesarchivageTache;
import com.example.application_trello.Controls.ControlModificationTache;
import com.example.application_trello.Objects.Observateur;
import com.example.application_trello.Objects.Sujet;
import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VueArchive  extends GridPane implements Observateur {

    private Tableau tableau;
    private String nomColonne;
    private ListView<Tache> listViewTachesArchivees;

    public VueArchive(Tableau tableau, String nomColonne) {
        this.tableau = tableau;
        this.nomColonne = nomColonne;
        initialize();
    }

    private void initialize() {
        setHgap(30);
        setVgap(30);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");

        // Initialiser la ListView pour afficher les tâches archivées
        listViewTachesArchivees = new ListView<>();
        getChildren().add(listViewTachesArchivees);

        actualiser(tableau);

        tableau.enregistrerObservateur(this);
    }

    @Override
    public void actualiser(Sujet s) {
        getChildren().clear();

        // Ajouter un label pour indiquer la vue archive
        Label labelVueArchive = new Label("Vue Archive");
        labelVueArchive.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 28;");
        add(labelVueArchive, 0, 0, 2, 1);

        // Parcourir les tâches archivées et les afficher en tant que lignes dans le GridPane
        int row = 1; // Commencer à partir de la deuxième ligne
        for (Tache tache : tableau.getListeTachesArchives()) {
            Hyperlink hyperlinkTache = new Hyperlink(tache.getNomTache());
            hyperlinkTache.setStyle("-fx-text-fill: white;-fx-font-size: 24;");
            add(hyperlinkTache, 0, row);
            ControlModificationTache cmt = new ControlModificationTache(this.tableau, tache);
            hyperlinkTache.setOnAction(cmt);

            Button boutonDesarchiver = new Button("Désarchiver");
            ControlDesarchivageTache condesarchiTache = new ControlDesarchivageTache(tableau,tache.getNomTache(),nomColonne);
            boutonDesarchiver.setOnAction(condesarchiTache);
            boutonDesarchiver.setId("boutonDesarchiver"+tache.getNomTache());

            boutonDesarchiver.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;");
            VBox.setMargin(boutonDesarchiver, new Insets(30));
            boutonDesarchiver.setOnMouseEntered(e -> boutonDesarchiver.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: black; -fx-text-fill: white;"));
            boutonDesarchiver.setOnMouseExited(e -> boutonDesarchiver.setStyle("-fx-font-size: 16; -fx-padding: 5 30; -fx-background-radius: 20 20 20 20; -fx-background-color: white; -fx-text-fill: black;"));

            //boutonDesarchiver.setOnAction(event -> desarchiverTache(tache)); // Remplacez cette méthode par votre logique de désarchivage
            add(boutonDesarchiver, 1, row);

            row++;
        }
    }


}
