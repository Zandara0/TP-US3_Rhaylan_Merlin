package com.s4m.poo.basics;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO {

    public static void ajouter(NoteElement note, int idEtudiant) {
        String sql = "INSERT INTO notation(note, coef, id_etudiant) VALUES (?, ?, ?)";

        try (Connection conn = ConnexionBdd.obtenirConnexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, note.getValeur());
            ps.setDouble(2, note.getCoef());
            ps.setInt(3, idEtudiant);
            ps.executeUpdate();

            System.out.println("Note ajoutée à l'étudiant ID : " + idEtudiant);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<NoteElement> recupererPour(int id) {
        ArrayList<NoteElement> liste = new ArrayList<>();
        String sql = "SELECT note, coef FROM notation WHERE id_etudiant=?";

        try (Connection conn = ConnexionBdd.obtenirConnexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                liste.add(new NoteElement(rs.getDouble("note"), rs.getDouble("coef")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }
}
