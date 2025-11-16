package com.s4m.poo.basics;

import java.sql.*;
import java.util.ArrayList;

public class EtudiantDAO {

    public static int inserer(FicheEtudiant etu) {
        String requete = "INSERT INTO etudiant(nom, moyenne, avis) VALUES (?, ?, ?)";
        int idGenere = -1;

        try (Connection conn = ConnexionBdd.obtenirConnexion();
             PreparedStatement ps = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, etu.getNom());
            ps.setDouble(2, etu.getMoyenne());
            ps.setString(3, etu.getAvis());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) idGenere = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGenere;
    }

    public static ArrayList<FicheEtudiant> recupererTous() {
        ArrayList<FicheEtudiant> liste = new ArrayList<>();
        String sql = "SELECT nom FROM etudiant";

        try (Connection conn = ConnexionBdd.obtenirConnexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nom = rs.getString("nom");
                liste.add(new FicheEtudiant(nom, new NoteElement[0]));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }
}
