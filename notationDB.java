package com.s4m.poo.basics;

import java.sql.*;
import java.util.ArrayList;

public class NotationDB {

    // Ajouter
    public static void insererNotation(Notation n, int idEtudiant) {
        String sql = "INSERT INTO notation(note, coef, id_etudiant) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, n.getNote());
            stmt.setDouble(2, n.getCoef());
            stmt.setInt(3, idEtudiant);
            stmt.executeUpdate();
            System.out.println("Note enregistrée avec succès pour " + idEtudiant);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer toutes les notes d’un étudiant
    public static ArrayList<Notation> getNotationsByEtudiant(int idEtudiant) {
        ArrayList<Notation> list = new ArrayList<>();
        String sql = "SELECT * FROM notation WHERE id_etudiant=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEtudiant);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                double note = rs.getDouble("note");
                double coef = rs.getDouble("coef");
                list.add(new Notation(note, coef));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
