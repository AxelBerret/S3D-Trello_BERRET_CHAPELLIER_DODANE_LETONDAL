package com.example.application_trello;

/**
 * interface Sujet
 * fait par Titouan
 */
public interface Sujet {
    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateurs();
}
