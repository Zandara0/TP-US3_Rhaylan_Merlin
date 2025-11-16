import com.s4m.poo.basics.*;

public class LanceurProgramme {

    public static void main(String[] args) {

        NoteElement[] notes = {
                new NoteElement(14, 2),
                new NoteElement(9, 1),
                new NoteElement(17, 3)
        };

        FicheEtudiant etu = new FicheEtudiant("Ines", notes);
        etu.afficher();

        int id = EtudiantDAO.inserer(etu);

        for (NoteElement n : notes) {
            NoteDAO.ajouter(n, id);
        }

        System.out.println("\nListe des étudiants enregistrés :");
        for (FicheEtudiant f : EtudiantDAO.recupererTous()) {
            System.out.println("→ " + f.getNom());
        }
    }
}
