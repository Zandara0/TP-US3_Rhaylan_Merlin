package com.s4m.poo.basics;

public class NoteElement {

    private final double valeur;
    private final double coef;

    public NoteElement(double valeur, double coef) {
        this.valeur = valeur;
        this.coef = coef;
    }

    public double getValeur() { return valeur; }
    public double getCoef() { return coef; }

    public void afficher() {
        System.out.println("Note : " + valeur + " | Coef : " + coef);
    }
}
