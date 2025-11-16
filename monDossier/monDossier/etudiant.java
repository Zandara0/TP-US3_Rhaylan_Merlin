package com.s4m.poo.basics;

public class Etudiant {

        private String nom;
        private double moyenne;
        private String avis;
        private Notation[] notes;

        public Etudiant(String nom, Notation[] notes) {
            this.nom = nom;
            this.notes = notes;
            this.moyenne = calculMoyenne();
            this.avis = calculAvis();
        }

        // Calcul de la moyenne
        private double calculMoyenne() {
            double Somme = 0;
            double sommeCoef = 0;
            for (Notation n : notes) {
                Somme += n.getNote() * n.getCoef();
                sommeCoef += n.getCoef();
            }
            return (sommeCoef != 0) ? Somme / sommeCoef : 0;
        }

        //Déterminer l'avis de passage
        private String calculAvis() {
            if (moyenne >= 10)
                return "Admis";
            else if (moyenne >= 8)
                return "Rattrapage";
            else
                return "Non admis";
        }

    public String getNom() {
        return nom;
    }
        public double getMoyenne() {
            return moyenne;
        }

        public String getAvis() {
            return avis;
        }

        //  Afficher
        public void afficher() {
            System.out.println("Étudiant : " + nom);
            System.out.println("Notes : ");
            for (Notation n : notes) {
                n.afficher();
            }
            System.out.println("Moyenne : " + moyenne +", Avis : " + avis);
        }



}
