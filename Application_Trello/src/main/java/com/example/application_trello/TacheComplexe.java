package com.example.application_trello;

import java.util.*;

public class TacheComplexe extends Tache implements InterfaceListeTaches {

    /**
     * attribut listeTaches de la classe TacheComplexe
     * represente la liste des sous taches de la tache complexe
     */
    private ArrayList<Tache> listeTaches;


    /**
     * constructeur qui cree des objets TacheComplexe
     * a partir des donnees passees en parametres
     * @param pNom nom que l on souhaite donner a la tache complexe
     */
    public TacheComplexe(String pNom) {super(pNom);}


    /**
     * methode setDateFin de la classe TacheComplexe
     * @param dateF date de fin que l on souhaite donner a la tache
     */
    public void setDateFin(Date dateF) {
        int dureeMax = 0;
        for (int i = 0; i < this.listeTaches.size(); i++) {
            if (this.listeTaches.get(i).dateFin.getTime() > dureeMax) {
                dureeMax = (int) this.listeTaches.get(i).dateFin.getTime();
            }
        }
        if (dateF.getTime() < dureeMax) this.dateFin.setTime(dureeMax);
        else this.dateFin = dateF;
    }

    /**
     * methode ajouterTache de la classe TacheComplexe
     * @param tache tache que l on souhaite ajouter a la liste des sous taches
     */
    public void ajouterTache(Tache tache) {this.listeTaches.add(tache);}

    /**
     * methode supprimerTache de la classe TacheComplexe
     * @param tache tache que l on souhaite supprimer de la liste des sous taches
     */
    public void supprimerTache(Tache tache) {this.listeTaches.remove(tache);}

    /**
     * methode getTache de la classe TacheComplexe
     * @param nomTache nom de la tache que l on souhaite posseder
     * @return la tache voulue
     */
    public Tache getTache(String nomTache) {
        Tache res = null;
        for (int i = 0; i < this.listeTaches.size(); i++) {
            if (this.listeTaches.get(i).nomTache.equals(nomTache)) {
                res = this.listeTaches.get(i);
            }
        }
        return res;
    }

    /**
     * methode getListeTaches de la classe TacheComplexe
     * @return la liste des sous taches
     */
    public ArrayList<Tache> getListeTaches() {return this.listeTaches;}
}
