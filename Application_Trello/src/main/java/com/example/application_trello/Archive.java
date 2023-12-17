package com.example.application_trello;

import java.util.ArrayList;

public class Archive {
    private ArrayList<Tache> listeTachesArchivees;
    private ArrayList<Colonne> listeColonnesArchivees;

    public Archive(){
        this.listeTachesArchivees = new ArrayList<Tache>();
        this.listeColonnesArchivees = new ArrayList<Colonne>();
    }

    public void archiverTache(Tache tache){
        this.listeTachesArchivees.add(tache);
    }

    public void archiverColonne(Colonne colonne){
        this.listeColonnesArchivees.add(colonne);
    }

    public void desarchiverTache(Tache tache){
        this.listeTachesArchivees.remove(tache);
    }

    public void desarchiverColonne(Colonne colonne){
        this.listeColonnesArchivees.remove(colonne);
    }

    public ArrayList<Tache> getListeTachesArchivees(){
        return this.listeTachesArchivees;
    }

    public ArrayList<Colonne> getListeColonnesArchivees(){
        return this.listeColonnesArchivees;
    }
}
