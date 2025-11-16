package com.s4m.poo.basics;

public class Notation {

        private double note;
        private double coef;

        public Notation(double note, double coef) {
            this.note = note;
            this.coef = coef;
        }

        public double getNote() {
            return note;
        }

        public double getCoef() {
            return coef;
        }

        public void afficher() {
            System.out.println("Note : " + note + "  Coefficient : " + coef);
        }


}
