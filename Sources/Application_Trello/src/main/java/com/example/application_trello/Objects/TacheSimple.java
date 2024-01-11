package com.example.application_trello.Objects;

import com.example.application_trello.Objects.Tache;

import java.time.LocalDate;

/**
 * classe TacheSimple
 * represente une tache simple de l application
 * fait par Titouan
 */
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
     * @param dateD date de fin que l on souhaite donner a la tache
     */
    public void setDateDebut(LocalDate dateD) {this.dateDebut = dateD;}


    /**
     * methode setDateFin de la classe TacheSimple
     * @param dateF date de fin que l on souhaite donner a la tache
     */
    public void setDateFin(LocalDate dateF) {this.dateFin = dateF;}

    /**
     * Méthode getDateDebut de la classe TacheSimple
     *
     * @return la date de début de la tâche
     */
    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    /**
     * Méthode getDateFin de la classe TacheSimple
     *
     * @return la date de fin de la tâche
     */
    public LocalDate getDateFin() {
        return this.dateFin;
    }

    /**
     * methode toString de la classe TacheSimple
     * @return le mode d affichage pour les objets de types TacheSimple
     */
    @Override
    public String toString() {
        String res = "";
        res += "nom Tache : "+this.nomTache+"\n";
        if (this.listeDependances.size() > 0) {
            for (int i = 0; i < this.listeDependances.size(); i++) {
                res += "- dependance "+i+" : "+this.listeDependances.get(i)+"\n";
            }
        }
        else {
            res += "cette tache ne comporte aucune dependance ...";
        }
        return res;
    }
}
