package com.example.application_trello.Views;

import com.example.application_trello.Controls.ControlDesarchivageTache;
import com.example.application_trello.Controls.ControlModificationTache;
import com.example.application_trello.Objects.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//VueArchive : vue qu'on va afficher dans une fenêtre externe a l'application lorsqu'on va cliquer sur une tache,
//pour afficher la liste des taches archivees avec la possibilité de désarchiver ou d'acceder a la vue tache de chaque tache actuellement archivé
//Classe écrite par Sacha
public class VueArchive  extends GridPane implements Observateur {

    /**
     * attribut tableau de la classe VueArchive
     * represente le modele que l on va actualiser
     */
    private Tableau tableau;

    /**
     * attribut nomColonne de la classe VueArchive
     * (utile pour le desarchivage)
     */
    private String nomColonne;

    /**
     * attribut listViewtachesArchivees de la classe VueArchive
     * represente la liste des taches archivees
     */
    private ListView<Tache> listViewTachesArchivees;


    /**
     * constructeur qui cree des objets de types VueArchive
     * a partir des donnees passees en parametres
     * @param tableau tableau que l on souhaite utiliser en tant que modele
     * @param nomColonne nom de la colonne que l on souhaite utiliser pour le desarchivage
     */
    public VueArchive(Tableau tableau, String nomColonne) {
        this.tableau = tableau;
        this.nomColonne = nomColonne;
        initialize();
    }


    /**
     * methode initialize de la classe VueArchive
     * initialise la vue
     */
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

    /**
     * methode actualiser de la classe VueArchive
     * @param s sujet que l on souhaite actualiser
     */
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
            ControlModificationTache cmt = new ControlModificationTache(this.tableau, tache);
            hyperlinkTache.setOnAction(cmt);
            add(hyperlinkTache, 0, row);


            Button boutonDesarchiver = new Button("Désarchiver");
            ControlDesarchivageTache condesarchiTache = new ControlDesarchivageTache(tableau,tache.getNomTache(), tache.getColonneParent().getNomColonne());
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
