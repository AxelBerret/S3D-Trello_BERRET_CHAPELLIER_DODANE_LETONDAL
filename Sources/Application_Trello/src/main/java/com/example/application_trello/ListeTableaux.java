package com.example.application_trello;

import java.util.ArrayList;

public class ListeTableaux {

    /**
     * attribut tableaux de la classe ListeTableaux
     * represente la liste des tableaux editables
     */
    private ArrayList<Tableau> tableaux;


    /**
     * constructeur vide qui cree des objets de type ListeTableaux
     */
    public ListeTableaux() {this.tableaux = new ArrayList<Tableau>();}


    /**
     * methode ajouterTableau de la classe ListeTableau
     * @param tab tableau que l on souhaite ajouter a la liste des tableaux
     */
    public void ajouterTableau(Tableau tab) {this.tableaux.add(tab);}

    /**
     * methode supprimerTableau de la classe ListeTableau
     * @param tab tableau que l on souhaite supprimer de la liste des tableaux
     */
    public void supprimerTableau(Tableau tab) {this.tableaux.remove(tab);}

    /**
     * methode getTableau de la classe ListeTableaux
     * @param nomTab nom du tableau que l on souhaite posseder
     * @return le tableau voulu
     */
    public Tableau getTableau(String nomTab) {
        Tableau res = null;
        for (int i = 0; i < this.tableaux.size(); i++) {
            if (this.tableaux.get(i).getNomTableau().equals(nomTab)) {
                res = this.tableaux.get(i);
            }
        }
        return res;
    }

    /**
     * methode getListeTableaux de la classe ListeTableaux
     * @return la liste des tableaux editables
     */
    public ArrayList<Tableau> getListeTableaux() {return this.tableaux;}
}
