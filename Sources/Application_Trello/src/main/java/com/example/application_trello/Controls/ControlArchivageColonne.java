package com.example.application_trello.Controls;

import java.util.Optional;

import com.example.application_trello.Objects.Tableau;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
//Controleur sarchivageTache : Controleur qui va permettre d'archiver une tache en lien avec le bouton sur les taches
//Classe écrite par Sacha
public class ControlArchivageColonne implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlArchivageTache
     * represente le modele que l on modifiera
     */
    private Tableau tab;

    /**
     * attribut nomCol de la classe ControlArchivageColonne
     * represente le nom de la colonne que l on va maniupuler pour l archivage
     */
    private String nomCol;


    /**
     * contructeur qui cree des objets de types ControlArchivageColonne
     * a partir des donnees passees en parametres
     * @param t tableau que l on va utiliser en tant que modele
     * @param nomCol nom de la colonne que l on veut manipuler
     */
    public ControlArchivageColonne(Tableau t, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;
    }


    /**
     * methode handle de la classe ControlArchivageTache
     * qui permet la gestion du bouton d archivage des taches
     * @param event
     */
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button) {
            Button targetButton = (Button) event.getTarget();

            if (targetButton.getId().startsWith("boutonArchivageColonne")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de l archivage");
                alert.setHeaderText("Archiver la Colonne");
                alert.setContentText("Etes-vous sur de vouloir archiver cette Colonne?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    String NomColonne = this.extraireNomColonneDeID(targetButton.getId());
                    this.tab.archiverColonne(this.nomCol);

                }
            }
        }
    }

    /**
     * methode extraireNomColonneDeID de la classe ControlArchivageColonne
     * @param idBouton identifiant du bouton que l on souhaite verifier
     * @return le nom de la colonne
     */
    public String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("boutonArchivageColonne")) {
            return idBouton.substring("boutonArchivageColonne".length());
        }
        return null;
    }

    /**
     * methode getTab de la classe ControlArchivageColonne
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }
}
