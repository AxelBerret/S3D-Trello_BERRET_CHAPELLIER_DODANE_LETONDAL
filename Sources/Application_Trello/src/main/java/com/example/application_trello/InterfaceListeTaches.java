package com.example.application_trello;

import java.util.ArrayList;
/**
 * interface InterfaceListeTaches
 * fait par Titouan
 */
public interface InterfaceListeTaches {

    /**
     * methode ajouterTache de l interface InterfaceListeTaches
     * @param tache tache que l on souhaite ajouter a liste des taches
     */
    public void ajouterTache(Tache tache);

    /**
     * methode supprimerTache de l interface InterfaceListeTaches
     * @param tache tache que l on souhaite supprimer de la liste des taches
     */
    public void supprimerTache(Tache tache);

    /**
     * methode getTache de l interface InterfaceListeTaches
     * @param nomTache nom de la tache que l on souhaite posseder
     * @return la tache voulue
     */
    public Tache getTache(String nomTache);

    /**
     * methode getListeTaches de l interface InterfaceListeTaches
     * @return la liste des taches
     */
    public ArrayList<Tache> getListeTaches();
}
