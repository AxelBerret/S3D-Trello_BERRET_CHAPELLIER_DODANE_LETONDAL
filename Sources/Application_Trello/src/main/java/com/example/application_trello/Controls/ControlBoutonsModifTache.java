package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import com.example.application_trello.Views.VueTache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class ControlBoutonsModifTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlBoutonsModifTache
     * represente le modele que l on modifiera
     */
    private Tableau tab;

    /**
     * attribut listeNomTaches de la classe ControlBoutonsModifTaches
     * reresente la liste des noms des taches
     */
    private ArrayList<String> listeNomTaches;


    /**
     * constructeur qui cree des objets de types ControlBoutonsModifTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on va utiliser en tant que modele
     */
    public ControlBoutonsModifTache(Tableau t){
        this.tab = t;
        this.majListeNomTaches();
    }


    /**
     * methode handle de la classe ControlBoutonsModifTache
     * @param event
     */
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button) {
            Button targetButton = (Button) event.getTarget();//Si l'event vient d'un boutton
            if (targetButton.getId().startsWith("addDependButton")) {//Si c'est un bouton d'ajout de dépendance
                String nomTache = extraireNomTacheID(targetButton.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();//On récupère l'instance de la VueTache en cours d'éxécution (oui c'est sûrement un peu bancal mais c'est la première solution fonctionnelle que j'ai trouvée)
                    String dep = vt.getDependanceSelectionnee();//On récupère le nom de la dépendance à ajouter à cette tâche
                    // On ajoute la dépendance a la tâche
                    if (dep != null){
                        this.tab.ajouterDependance(nomTache, dep);
                        vt.resetDependanceSelectionnee();
                    }
                }
            } else if (targetButton.getId().startsWith("addSousTacheButton")) {//Sinon si c'est un bouton d'ajout de sous-tâche
                String nomTache = extraireNomTacheID(targetButton.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();//On récupère l'instance de la VueTache en cours d'éxécution
                    String st = vt.getSousTacheSelectionnee();//On récupère le nom de la sous-tâche à ajouter à cette tâche
                    // On ajoute la st a la tâche
                    if (st != null){
                        this.tab.ajouterSousTache(nomTache, st);
                        vt.resetSousTacheSelectionnee();
                    }
                }
            }
        } else if(event.getTarget() instanceof DatePicker) {//Si l'event vient d'un datePicker
            DatePicker targetDatePicker = (DatePicker) event.getTarget();//On le récupère
            if (targetDatePicker.getId().startsWith("setDateDebut")) {//Si c'est un bouton d'ajout de date de début
                String nomTache = extraireNomTacheID(targetDatePicker.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();//On récupère l'instance de la VueTache en cours d'éxécution
                    LocalDate dd = vt.getDateDebutSelectionnee();//On récupère la date à assigner à la tâche
                    this.tab.setDateDebut(nomTache, dd);// On ajoute la date à la tâche
                }
            } else if(targetDatePicker.getId().startsWith("setDateFin")){
                String nomTache = extraireNomTacheID(targetDatePicker.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();//On récupère l'instance de la VueTache en cours d'éxécution
                    LocalDate df = vt.getDateFinSelectionnee();//On récupère le nom de la sous-tâche à ajouter à cette tâche
                    this.tab.setDateFin(nomTache, df);//On ajoute la date à la tâche
                }
            }
        }
    }

    /**
     * methode majListeNomTaches de la classe ControlBoutonsModifTache
     * met a jour la liste de noms des taches
     */
    public void majListeNomTaches(){
        ArrayList<Tache> lt = this.tab.getListeTaches();
        this.listeNomTaches = new ArrayList<>();
        for (Tache t : lt){
            this.listeNomTaches.add(t.getNomTache());
        }
    }

    /**
     * methode extraireNomTacheID de la classe ControlBoutonsModifTache
     * @param idBouton identifiant du bouton que l on souhaite verifier
     * @return le nom de la tache
     */
    public String extraireNomTacheID(String idBouton) {//Méthode pour récupérer le nom de la tache depuis l'ID d'un boutton/datePicker
        String[] prefixes = {"addDependButton", "addSousTacheButton", "setDateDebut", "setDateFin"};
        for (String prefix : prefixes) {
            if (idBouton != null && idBouton.startsWith(prefix)) {
                return idBouton.substring(prefix.length());
            }
        }
        return null;
    }
}
