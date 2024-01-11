package com.example.application_trello.Objects;

import com.example.application_trello.Objects.Observateur;

/**
 * interface Sujet
 * fait par Titouan
 */
public interface Sujet {

    /**
     * methode enregistrerObservateur de l interface Sujet
     * @param o observateur que l on veut enregistrer
     */
    public void enregistrerObservateur(Observateur o);

    /**
     * methode supprimerObservateur de l interface Sujet
     * @param o observateur que l on supprimer
     */
    public void supprimerObservateur(Observateur o);

    /**
     * methode notifierObservateurs de l interface Sujet
     */
    public void notifierObservateurs();
}
