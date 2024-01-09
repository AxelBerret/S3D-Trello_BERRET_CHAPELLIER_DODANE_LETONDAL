package com.example.application_trello.Objects;

import com.example.application_trello.Objects.Observateur;

/**
 * interface Sujet
 * fait par Titouan
 */
public interface Sujet {
    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateurs();
}
