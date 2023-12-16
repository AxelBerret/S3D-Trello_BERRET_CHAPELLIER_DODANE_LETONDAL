package com.example.application_trello;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
public class Tache {
    protected String nomTache;
    protected String commentaire;
    protected Date dateDebut;
    protected Date dateFin;
    protected ArrayList<Tache> listeDependances;

    public Tache(String pNom){
        this.nomTache = pNom;
    }

    public void setCommentaire(String com){
        this.commentaire = com;
    }

    public void setDateDebut(Date dateD){
        this.dateDebut = dateD;
    }

    public void setDateFin(Date dateF){
        this.dateFin = dateF;
    }

     public void ajouterDependance(Tache tache){
        this.listeDependances.add(tache);
     }

     public void retirerDependance(Tache tache){
        this.listeDependances.remove(tache);
     }

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
