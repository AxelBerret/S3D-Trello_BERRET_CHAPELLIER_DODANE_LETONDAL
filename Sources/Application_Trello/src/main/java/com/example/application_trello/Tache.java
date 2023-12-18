package com.example.application_trello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
public abstract class Tache {

    /**
     * attribut nomTache de la classe Tache
     * represente le nom de la tache
     */
    protected String nomTache;

    /**
     * attribut commentaire de la classe Tache
     * represente les commentaires que l on peut faire
     * en contenu de tache
     */
    protected String commentaire;

    /**
     * attribut dateDebut de la classe Tache
     * represente la date de debut de la tache
     */
    protected LocalDate dateDebut;

    /**
     * atttribut dateFin de la classe Tache
     * represente la date de fin de la tache
     */
    protected LocalDate dateFin;

    /**
     * attribut listeDependances de la classe Tache
     * represente la liste des dependances de la tache
     */
    protected ArrayList<Tache> listeDependances;


    /**
     * constructeur qui cree un objet de type Tache
     * a partir des donnees passees en parametres
     * @param pNom nom que l on souhaite donner a la tache
     */
    public Tache(String pNom) {
        this.nomTache = pNom;
        this.commentaire = "";
        this.dateDebut = null;
        this.dateFin = null;
        this.listeDependances = new ArrayList<Tache>();
    }


    /**
     * methode getNomTache de la classe Tache
     * @return le nom de la tache
     */
    public String getNomTache() {return this.nomTache;}

    /**
     *
     * @return
     */
    public String getCommentaire() {
        return this.commentaire;
    }

    /**
     *
     * @return
     */
    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    /**
     *
     * @return
     */
    public LocalDate getDateFin() {
        return this.dateFin;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tache> getListeDependances() {
        return this.listeDependances;
    }

    /**
     * methode setCommentaire de la classe Tache
     * @param com commentaire que l on souhaite donner a la tache
     */
    public void setCommentaire(String com){
        this.commentaire = com;
    }

    /**
     * methode setDateDebut de la classe Tache
     * @param dateD date de debut que l on souhaite donner a la tache
     */
    public void setDateDebut(LocalDate dateD) {this.dateDebut = dateD;}

    /**
     * methode setDateFin de la classe Tache
     * @param dateF date de fin que l on souhaite donner a la tache
     */
    public abstract void setDateFin(LocalDate dateF);

    /**
     * methode ajouterDependance de la classe Tache
     * @param tache tache que l on souhaite ajouter en dependances
     */
     public void ajouterDependance(Tache tache) {this.listeDependances.add(tache);}

    /**
     * methode retirerDependance de la classe Tache
     * @param tache tache que l on souhaite retirer des dependances
     */
     public void retirerDependance(Tache tache) {this.listeDependances.remove(tache);}

    /**
     * methode equals de la classe Tache
     * @param obj
     * @return vrai si egales sinon faux
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tache autreTache = (Tache) obj;
        return Objects.equals(nomTache, autreTache.nomTache) &&
                Objects.equals(commentaire, autreTache.commentaire) &&
                Objects.equals(dateDebut, autreTache.dateDebut) &&
                Objects.equals(dateFin, autreTache.dateFin) &&
                Objects.equals(listeDependances, autreTache.listeDependances);
    }
}
