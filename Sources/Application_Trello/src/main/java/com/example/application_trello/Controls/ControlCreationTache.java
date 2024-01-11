package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;

public class ControlCreationTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlCreationTache
     * represente le modele que l on va utiliser
     */
    private Tableau tab;

    /**
     * attribut listeNomColonnes de la classe ControlCreationTache
     * represente la liste des nom des colonnes
     */
    private ArrayList<String> listeNomColonnes;


    /**
     * constructeur qui cree des objets de types ControlCreationTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en tant que modele
     */
    public ControlCreationTache(Tableau t){
        this.tab = t;
        this.majListeNomColonnes();
    }


    /**
     * methode getTab de la classe ControlCreationTache
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode getListeNomColonnes de la classe ControlCreationTache
     * @return la liste des noms des colonnes
     */
    public ArrayList<String> getListeNomColonnes() {
        return listeNomColonnes;
    }

    /**
     * methode handle de la classe ControlCreationTache
     * @param event
     */
    public void handle(ActionEvent event) {
        this.majListeNomColonnes();
        if (event.getTarget() instanceof Button) {//Si l'event vient d'un boutton
            Button targetButton = (Button) event.getTarget();// On récupère ce bouton
            if (targetButton.getId().startsWith("btnCreerTache")) {//Si c'est un bouton de création de tâche
                String nomColonne = extraireNomColonneDeID(targetButton.getId());//On récupère le nom de la colonne
                if (this.listeNomColonnes.contains(nomColonne)){//Si la colonne existe dans notre tableau
                    // On ouvre une fenetre de dialogue pour rentrer le nom de la tâche
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Création de Tâche");
                    dialog.setHeaderText("Entrer le texte de la tâche :");
                    dialog.setContentText("Texte :");
                    // Attendre que l'utilisateur entre le texte
                    dialog.showAndWait().ifPresent(texteTache -> {
                        // Créer une nouvelle tâche avec le texte et l'ajouter au modèle
                        tab.ajouterTache(texteTache, nomColonne);//On ajoute la tâche dans la colonne
                    });
                }
            }
        }
    }

    /**
     * methode majListeNomColonnes de la classe ControlCreationTache
     * met a jour la liste des noms des colonnes
     */
    public void majListeNomColonnes(){//Méthode pour créer une liste des noms de colonnes a partir de la liste des colonnes du tableau pour simplifier la méthode handle
        ArrayList<Colonne> lc = this.tab.getListeColonnes();
        this.listeNomColonnes = new ArrayList<>();
        for (Colonne c : lc){
            this.listeNomColonnes.add(c.getNomColonne());
        }
    }

    /**
     * methode extraireNomColonneDeID de la classe ControlCreationTache
     * @param idBouton identifiant du bouton que l on souhaite verifier
     * @return le nom de la colonne
     */
    public String extraireNomColonneDeID(String idBouton) {//Méthode pour récupérer la colonne dans laquelle ajouter la tâche
        if (idBouton != null && idBouton.startsWith("btnCreerTache")) {
            return idBouton.substring("btnCreerTache".length());
        }
        return null;
    }
}
