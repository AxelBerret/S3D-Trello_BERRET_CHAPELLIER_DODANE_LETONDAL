package com.example.application_trello;

import java.util.ArrayList;

public class Tableau {

    /**
     * attribut nomTableau de la classe Tableau
     * represente le nom du tableau (espace de travail)
     */
    private String nomTableau;

    /**
     * attribut listeObjets de la classe Tableau
     * represente la liste de tout les objets presents dans le tableau
     * (colonnes et taches)
     */
    private ArrayList<InterfaceListeTaches> listeObjets;

    /**
     * attribut archive de la classe Tableau
     * represente l archive du tableau
     */
    private Archive archive;


    /**
     * constructeur qui cree des objets de types Tableau
     * a partir des donnees passees en parametres
     * @param pNom nom que l on souhaite donner au tableau
     */
    public Tableau(String pNom) {
        this.nomTableau = pNom;
        this.listeObjets = new ArrayList<InterfaceListeTaches>();
    }


    /**
     * methode getNomTableau de la classe Tableau
     * @return le nom du tableau
     */
    public String getNomTableau() {return this.nomTableau;}

    /**
     * methode getColonnes de la classe Tableau
     * @return la liste des colonnes dans la liste des objets
     */
    public ArrayList<Colonne> getColonnes() {
        ArrayList<Colonne> listeColonnes = new ArrayList<Colonne>();
        for (int i = 0; i < this.listeObjets.size(); i++) {
            if (this.listeObjets.get(i) instanceof Colonne) {
                listeColonnes.add((Colonne)this.listeObjets.get(i));
            }
        }
        return listeColonnes;
    }

    /**
     * methode getArchive de la classe Tableau
     * @return l archive du tableau
     */
    public Archive getArchive() {return this.archive;}

    /**
     * methode getListeTaches de la classe Tableau
     * @return la liste des taches dans la liste des objets
     */
    public ArrayList<Tache> getListeTaches() {
        ArrayList<Tache> listeTaches = new ArrayList<Tache>();
        for (int i = 0; i < this.listeObjets.size(); i++) {
            if (this.listeObjets.get(i) instanceof Colonne) {
                for (int j = 0; j < this.listeObjets.get(i).getListeTaches().size(); j++) {
                    listeTaches.add((Tache)this.listeObjets.get(i).getListeTaches().get(j));
                }
            }
        }
        return listeTaches;
    }

    /**
     * methode ajouterColonne de la classe Tableau
     * @param col colonne que l on souhaite ajouter au tableau
     */
    public void ajouterColonne(Colonne col) {this.listeObjets.add(col);}

    /**
     * methode supprimerColonne de la classe Tableau
     * @param col colonne que l on souhaite supprimer du tableau
     */
    public void supprimerColonne(Colonne col) {this.listeObjets.remove(col);}

    public String toString(){
        String res = this.nomTableau;
        return res;
    }
}
