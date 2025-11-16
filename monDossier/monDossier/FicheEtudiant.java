package com.s4m.poo.basics;

public class FicheEtudiant {

    private final String nomComplet;
    private final NoteElement[] notes;
    private final double moyenne;
    private final String avis;

    public FicheEtudiant(String nomComplet, NoteElement[] notes) {
        this.nomComplet = nomComplet;
        this.notes = notes;
        this.moyenne = calculerMoyenne();
        this.avis = determinerAvis();
    }

    private double calculerMoyenne() {
        double total = 0;
        double totalCoef = 0;

        for (NoteElement n : notes) {
            total += n.getValeur() * n.getCoef();
            totalCoef += n.getCoef();
        }

        return totalCoef == 0 ? 0 : total / totalCoef;
    }

    private String determinerAvis() {
        if (moyenne >= 10) return "Admis";
        if (moyenne >= 8) return "Rattrapage";
        return "Non admis";
    }

    public String getNom() { return nomComplet; }
    public double getMoyenne() { return moyenne; }
    public String getAvis() { return avis; }

    public void afficher() {
        System.out.println("Étudiant : " + nomComplet);
        System.out.println("Notes :");
        for (NoteElement n : notes) n.afficher();
        System.out.println("Moyenne : " + moyenne + " | Avis : " + avis);
    }
}
