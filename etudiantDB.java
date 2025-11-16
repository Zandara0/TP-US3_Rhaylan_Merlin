package com.s4m.poo.basics;

import java.sql.*;
import java.util.ArrayList;

public class EtudiantDB {

    public static int insererEtudiant(Etudiant e) {
        String sql = "INSERT INTO etudiant(nom, moyenne, avis) VALUES (?, ?, ?)";
        int id = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, e.getNom());
            stmt.setDouble(2, e.getMoyenne());
            stmt.setString(3, e.getAvis());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public static ArrayList<Etudiant> getTousEtudiants() {
        ArrayList<Etudiant> list = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nom = rs.getString("nom");
                double moyenne = rs.getDouble("moyenne");
                String avis = rs.getString("avis");
                list.add(new Etudiant(nom, new Notation[0])); // ou tu pourrais aussi charger les notations
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
