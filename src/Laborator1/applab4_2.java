package Laborator1;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

//4.5.2
public class applab4_2 {
    public static void main(String[] args) {

        HashMap<String, Student> studenti = new HashMap<>();


        try (BufferedReader br = new BufferedReader(
                new FileReader("src/Laborator1/students_in.txt"))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] parti = linie.split(",");
                int matricol   = Integer.parseInt(parti[0]);
                String prenume = parti[1];
                String nume    = parti[2];
                String grupa   = parti[3];
                Student s = new Student(matricol, prenume, nume, grupa);
                studenti.put(parti[0], s);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(
                new FileReader("src/Laborator1/note_anon.txt"))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] parti  = linie.split(",");
                String matricol = parti[0];
                float nota      = Float.parseFloat(parti[1]);
                Student s = studenti.get(matricol); // O(1)
                if (s != null) s.setNota(nota);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }



        for (Student s : studenti.values()) {
            System.out.println(s);
        }
//4.5.3
        float notaM = gasesteNota("Bianca", "Popescu", studenti);
        float notaN = gasesteNota("Ioan", "Popa", studenti);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);

    }
    static float gasesteNota(String prenume, String nume,
                             HashMap<String, Student> studenti) {


        HashMap<String, Student> dupa_nume = new HashMap<>();
        for (Student s : studenti.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            dupa_nume.put(cheie, s);
        }


        String cheie = prenume + "-" + nume;
        Student gasit = dupa_nume.get(cheie);

        if (gasit != null) {
            return gasit.getNota();
        } else {
            return 0.0f;
        }
}
}
