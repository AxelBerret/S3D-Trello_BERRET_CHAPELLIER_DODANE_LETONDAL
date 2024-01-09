package com.example.application_trello;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    @Override
    public void actualiser(Sujet s) {
        // Mettre à jour la ListView avec les tâches archivées
        if (s instanceof Tableau) {
            Tableau tableau = (Tableau) s;
            if (nomColonne.equals("Archive")) { // Assurez-vous que la colonne est celle des archives
                listViewTachesArchivees.getItems().setAll(tableau.getListeTachesArchives());
            }
        }
    }
}
