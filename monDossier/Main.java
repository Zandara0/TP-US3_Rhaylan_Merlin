import com.s4m.poo.basics.Etudiant;
import com.s4m.poo.basics.EtudiantDB;
import com.s4m.poo.basics.Notation;
import com.s4m.poo.basics.NotationDB;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notation[] notes1 = {
                new Notation(12, 2),
                new Notation(15, 3),
                new Notation(8, 1)
        };
        Etudiant e1 = new Etudiant("Ines", notes1);
        e1.afficher();

        // Enregistrer dans la base
        int idEtu = EtudiantDB.insererEtudiant(e1);
        for (Notation n : notes1) {
            NotationDB.insererNotation(n, idEtu);
        }

        // Afficher tous les étudiants enregistrés
        System.out.println("\nListe des étudiants en base :");
        for (Etudiant e : EtudiantDB.getTousEtudiants()) {
            System.out.println("- " + e.getNom());
        };
            }
        }
