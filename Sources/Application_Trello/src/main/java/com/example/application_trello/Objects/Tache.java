package com.example.application_trello.Objects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

/**
 * classe abstract Tache
 * represente une tache de l application
 * fait par Axel, Sacha, Titouan et Logan
 */
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
    protected Colonne colonneParent;


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
        this.colonneParent = null;
    }



    /**
     * methode getNomTache de la classe Tache
     * @return le nom de la tache
     */
    public String getNomTache() {return this.nomTache;}

    /**
     * methode getCommentaire de la classe Tache
     * @return commentaire de la tache
     */
    public String getCommentaire() {
        return this.commentaire;
    }

    /**
     * methode getDateDebut de la classe Tache
     * @return la date de debut de la tache
     */
    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    /**
     * methode getDateFin de la classe Tache
     * @return la date de fin de la tache
     */
    public LocalDate getDateFin() {
        return this.dateFin;
    }

    /**
     * methode getListeDependances de la classe Tache
     * @return la liste des dependances de la tache
     */
    public ArrayList<Tache> getListeDependances() {
        return this.listeDependances;
    }

    public Colonne getColonneParent(){
        return this.colonneParent;
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
     * methode setColonneParent de la classe Tache
     * @param c colonne que l on souhaite ajouter en tant que parent
     */
    public void setColonneParent(Colonne c){
        this.colonneParent = c;
    }

    /**
     * methode ajouterDependance de la classe Tache
     * @param tache tache que l on souhaite ajouter en dependances
     */
     public void ajouterDependance(Tache tache) {
         if (!this.listeDependances.contains(tache)){
             this.listeDependances.add(tache);
         }
     }

    /**
     * methode retirerDependance de la classe Tache
     * @param tache tache que l on souhaite retirer des dependances
     */
     public void retirerDependance(Tache tache) {this.listeDependances.remove(tache);}

    /**
     * methode determinerBaseDate de la classe Tache
     * @param tableau le tableau auquel appartient la tâche
     * @return la date de début la plus ancienne parmi toutes les tâches du tableau
     */
    public static LocalDate determinerBaseDate(Tableau tableau) {
        LocalDate minDate = LocalDate.MAX;

        for (Colonne colonne : tableau.getListeColonnes()) {
            for (Tache tache : colonne.getListeTaches()) {
                if (tache.getDateDebut() != null && tache.getDateDebut().isBefore(minDate)) {
                    minDate = tache.getDateDebut();
                }
            }
        }

        return minDate;
    }

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

    /**
     * methode toString de la classe Tache
     * @return le mode d affichage console pour les objets de types Tache
     */
    public abstract String toString();

    /**
     * methode getDuree de la classe Tache
     * @return la durée de la tâche en jours
     */
    public int getDuree() {
        if (dateDebut != null && dateFin != null) {
            return (int) ChronoUnit.DAYS.between(dateDebut, dateFin);
        } else {
            return 0;
        }
    }
}
