package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import com.example.application_trello.Views.VueTache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Controleur qui en principe va, lorsqu'on clique sur une tâche quelconque, ouvrir une fenêtre affichant plus de détails
//Et qui va permettre de consulter les sous-tâches et les dépendances, et d'en ajouter ou d'en supprimer.
//Classe écrite par Titouan
public class ControlModificationTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlModificationTache
     * represente le modele que l on va utiliser
     */
    private Tableau tab;

    /**
     * attribut tache de la classe ControlModificationTache
     * represente la tache que l on va modifier
     */
    private Tache tache;


    /**
     * constructeur qui cree des objets ControlModificationTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en tant que modele
     * @param tt tache que l on souhaite modifier
     */
    public ControlModificationTache(Tableau t, Tache tt){
        this.tab = t;
        this.tache = tt;
    }


    /**
     * methode getTab de la classe ControlModificationTache
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode handle de la classe ControlModificationTache
     * @param event
     */
    public void handle(ActionEvent event) {
        Stage stageModification = new Stage();
        stageModification.setTitle(tache.getNomTache());

        VueTache vueModificationTache = new VueTache(this.tache, this.tab);
        this.tab.enregistrerObservateur(vueModificationTache);

        Scene sceneModification = new Scene(vueModificationTache, 750, 500);

        stageModification.setScene(sceneModification);
        stageModification.show();  // Utilisez show() au lieu de showAndWait()

        // Appelez la méthode actualiser après avoir montré la fenêtre
        vueModificationTache.actualiser(this.tab);
    }
}