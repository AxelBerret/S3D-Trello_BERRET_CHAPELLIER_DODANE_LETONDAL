package com.example.application_trello;

import java.util.ArrayList;

/**
 * classe Archive
 * represente l archive de l application
 * fait par Logan
 */
public class Archive {

    /**
     * attribut listeTachesArchivees de la classe Archive
     * represente la liste des taches archivees
     */
    private ArrayList<Tache> listeTachesArchivees;

    /**
     * attribut listeColonnesArchivees de la classe Archive
     * represente la liste des colonnes archivees
     */
    private ArrayList<Colonne> listeColonnesArchivees;


    /**
     * constructeur vide qui cree des objets de types Archive
     */
    public Archive(){
        this.listeTachesArchivees = new ArrayList<Tache>();
        this.listeColonnesArchivees = new ArrayList<Colonne>();
    }


    /**
     * methode archiverTache de la classe Archive
     * @param tache tache que l on souhaite archiver
     */
    public void archiverTache(Tache tache){
        this.listeTachesArchivees.add(tache);
    }


    /**
     * methode archiverColonne de la classe Archive
     * @param colonne colonne que l on souhaite archiver
     */
    public void archiverColonne(Colonne colonne){
        this.listeColonnesArchivees.add(colonne);
    }

    /**
     * methode desarchiverTache de la classe Archive
     * @param tache tache que l on souhaite desarchiver
     */
    public void desarchiverTache(Tache tache){
        this.listeTachesArchivees.remove(tache);
    }

    /**
     * methode desarchiverColonne de la classe Archive
     * @param colonne colonne que l on souhaite desarchiver
     */
    public void desarchiverColonne(Colonne colonne){
        this.listeColonnesArchivees.remove(colonne);
    }

    /**
     * methode getListeTachesArchivees de la classe Archive
     * @return la liste des taches archivees
     */
    public ArrayList<Tache> getListeTachesArchivees(){
        return this.listeTachesArchivees;
    }

    /**
     * methode getListeColonnesArchivees de la classe Archive
     * @return la liste des colonnes archivees
     */
    public ArrayList<Colonne> getListeColonnesArchivees(){
        return this.listeColonnesArchivees;
    }
}
