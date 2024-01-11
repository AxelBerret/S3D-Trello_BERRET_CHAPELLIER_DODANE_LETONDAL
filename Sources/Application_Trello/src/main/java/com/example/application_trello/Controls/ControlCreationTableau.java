package com.example.application_trello.Controls;

import com.example.application_trello.Objects.ListeTableaux;
import com.example.application_trello.Objects.Tableau;
import javafx.scene.control.TextInputDialog;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la création d'un tableau.
 * Classe écrite par Axel
 */
public class ControlCreationTableau {

    /**
     * attribut tab de la classe ControlCreationTableau
     * represente le modele que l on modifiera
     */
    private ListeTableaux listeTab;


    /**
     * constructeur qui cree des objets de types ControlCreationTableau
     * a partir des donnees passees en parametres
     * @param lt liste de tableaux que l on souhaite utiliser en modele
     */
    public ControlCreationTableau(ListeTableaux lt) {this.listeTab = lt;}

    /**
     * getter de la liste de tableaux
     * @return
     */
    public ListeTableaux getListeTab() {
        return listeTab;
    }

    /**
     * methode handle de la classe ControlCreationTableau
     * qui permet la gestion du bouton de creation de tableau
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            if ("boutonCreationTableau".equals(sourceButton.getId())) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Création de Tableau");
                dialog.setHeaderText("Entrer le texte du tableau :");
                dialog.setContentText("Texte :");
                // Attendre que l'utilisateur entre le texte
                dialog.showAndWait().ifPresent(texteTableau -> {
                    // Créer un nouveau tableau avec le texte et l ajouter au modele
                    Tableau tab = new Tableau(texteTableau);
                    this.listeTab.ajouterTableau(tab);
                });
            }
        }
    }
}
