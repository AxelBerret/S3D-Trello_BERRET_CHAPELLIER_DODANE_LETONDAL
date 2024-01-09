package com.example.application_trello;

import java.time.LocalDate;
import java.util.*;

/**
 * classe TaccheComplexe
 * represente une tache comptenant des sous taches
 * fait par Axel
 */

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
    public TacheComplexe(String pNom) {
        super(pNom);
        this.listeTaches = new ArrayList<Tache>();
    }

    public TacheComplexe(TacheSimple ts){
        super(ts.getNomTache());
        this.commentaire = ts.getCommentaire();
        this.dateDebut = ts.getDateDebut();
        this.dateFin = ts.getDateFin();
        this.listeDependances = ts.getListeDependances();
    }


    /**
     * methode setDateFin de la classe TacheComplexe
     * @param dateF date de fin que l on souhaite donner a la tache
     */
    public void setDateFin(LocalDate dateF) {
        this.dateFin = dateF;
        for (int i = 0; i < this.listeTaches.size(); i++) {
            if (this.dateFin.getYear() < this.listeTaches.get(i).getDateFin().getYear()) {
                this.dateFin = this.listeTaches.get(i).getDateFin();
                System.out.println("iteration"+i+" 1 "+this.dateFin.toString());
            }
            else if (this.dateFin.getDayOfYear() < this.listeTaches.get(i).getDateFin().getDayOfYear()) {
                this.dateFin = this.listeTaches.get(i).getDateFin();
                System.out.println("iteration"+i+" 2 "+this.dateFin.toString());
            }
        }
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

    public String toString(){
        String res = "";
        for (Tache taches : this.listeTaches){
            res += "-" + taches.toString() + "\n";
        }
        return res;
    }
}
