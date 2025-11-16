package com.s4m.poo.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_notes";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "12345678";

    private static Connection connexionUnique = null;

    public static Connection obtenirConnexion() {
        try {
            if (connexionUnique == null || connexionUnique.isClosed()) {
                connexionUnique = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
                System.out.println("Connexion réussie à la base de données.");
            }
        } catch (SQLException e) {
            System.err.println("Échec de la connexion.");
            e.printStackTrace();
        }
        return connexionUnique;
    }
}
