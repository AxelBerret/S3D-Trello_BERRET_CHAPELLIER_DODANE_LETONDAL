package com.example.application_trello;

import java.util.ArrayList;
import java.util.Objects;

public class Colonne implements InterfaceListeTaches {

    /**
     * attribut nomColonne de la classe Colonne
     * represente le nom de la colonne
     */
    private String nomColonne;

    /**
     * attribut listeTaches de la classe Colonne
     * represente la liste des taches presentes dans la colonne
     */
    private ArrayList<Tache> listeTaches;


    /**
     * constructeur qui cree des objets de types Colonne
     * a partir des donnees passees en prametres
     * @param pNom nom que l on souhaite donner a la colonne
     */
    public Colonne(String pNom) {
        this.nomColonne = nomColonne;
        this.listeTaches = new ArrayList<Tache>();
    }


    /**
     * methode getNomColonne de la classe Colonne
     * @return nomColonne
     */
    public String getNomColonne() {return this.nomColonne;}

    /**
     * methode ajoutertache de la classe Colonne
     * @param tache tache que l on souhaite ajouter a la liste des taches
     * de la colonne
     */
    public void ajouterTache(Tache tache) {this.listeTaches.add(tache);}

    /**
     * methode supprimer de la classe Colonne
     * @param tache tache que l on souhaite supprimer de la liste des taches
     * de la colonne
     */
    public void supprimerTache(Tache tache) {this.listeTaches.remove(tache);}

    /**
     * methode getTache de la classe Colonne
     * @param nomTache nom que l on souhaite posseder
     * @return la tahce voulue
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
     * methode getListeTaches de la classe Colonne
     * @return listeTaches
     */
    public ArrayList<Tache> getListeTaches() {return this.listeTaches;}

    /**
     * methode equals de la classe Colonne
     * @param obj
     * @return vrai si egales sinon faux
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Colonne colonne = (Colonne) obj;
        return Objects.equals(nomColonne, colonne.nomColonne) && Objects.equals(listeTaches, colonne.listeTaches);
    }
}
