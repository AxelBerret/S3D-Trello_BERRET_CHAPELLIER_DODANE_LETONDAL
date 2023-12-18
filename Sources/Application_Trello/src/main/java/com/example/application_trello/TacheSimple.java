package com.example.application_trello;

import java.time.LocalDate;
import java.util.Date;

public class TacheSimple extends Tache {

    /**
     * constructeur qui cree des objets de types TacheSimple
     * a partir des donnees passees en parametres
     * @param nomTache nom que l on souhaite donner a la tache
     */
    public TacheSimple(String nomTache) {
        super(nomTache);
    }


    /**
     * methode setDateFin de la classe TacheSimple
     * @param dateF date de fin que l on souhaite donner a la tache
     */
    public void setDateFin(LocalDate dateF) {this.dateFin = dateF;}

    /**
     * methode toString de la classe TacheSimple
     * @return le mode d affichage pour les objets de types TacheSimple
     */
    @Override
    public String toString() {
        return "TacheSimple{" +
                "nomTache='" + nomTache + "'" +
                ", commentaire='" + commentaire + "'" +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", listeDependances=" + listeDependances +
                '}';
    }
}
