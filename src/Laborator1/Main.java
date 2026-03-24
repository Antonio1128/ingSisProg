package Laborator1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {


    /* public static boolean existaStudent(List<Student> lista , Student s)
     {
     for(Student student :lista )
     {
         if (student.getNume().equals(s.getNume()) && student.getPrenume().equals(s.getPrenume()) && student.getFormatiedeStudiu().equals(s.getFormatiedeStudiu()))

         return true;
     }
       return false;
 }*/
    public static void main(String[] args) throws IOException {

       // Student s1 = new Student(591, "Antonio", "Popelca", "ISM21/1");
        //  System.out.println(s1);


    /*    List<Student> listaStudenti = new ArrayList<>();

        listaStudenti.add(new Student(596, "Sergiu ", "Tanase", "ISM21/1"));
        listaStudenti.add(new Student(242, "Claudiu", "Stefan", "ISM21/1"));
        listaStudenti.add(new Student(112, "Maria", "Popa", "TI21/1"));

        for (Student s : listaStudenti) {
            System.out.println(s);
        }
        Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println("Prezent:Alis Popa? " + existaStudent(listaStudenti, s2));

        Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Prezent Maria Popa? " + existaStudent(listaStudenti, s3));
    }*/
     /*   Set<Student> setStudenti = new HashSet();
        setStudenti.add(new Student(596, "Sergiu ", "Tanase", "ISM21/1"));
        setStudenti.add(new Student(242, "Claudiu", "Stefan", "ISM21/1"));
        setStudenti.add(new Student(112, "Maria", "Popa", "TI21/1"));

        Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println(s1.getNume()+" "+setStudenti.contains(s2));

        Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Prezent Maria Popa?"+setStudenti.contains(s3));

        */
//3.5.2
        String continut = new String(Files.readAllBytes(Paths.get("src/Laborator1/students_in.txt")));
        String[] linii = continut.split("\n");

        List<Student> studenti = new ArrayList<>();

        for (String linie : linii) {
            String[] campuri = linie.split(",");
            studenti.add(new Student(
                    Integer.parseInt(campuri[0].trim()),
                    campuri[1].trim(),
                    campuri[2].trim(),
                    campuri[3].trim()
            ));
        }

        for (Student s : studenti) {
            System.out.println(s);
        }


        studenti.sort(( a, b) -> a.getNume().compareTo(b.getNume()));


        Path outputPath = Paths.get("src/Laborator1/students_out.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            for (Student s : studenti) {
                writer.write(s.toString());
                writer.newLine();
            }
        }

        //3.5.3

        studenti.sort((a, b) -> {
            int dupa_formatie = a.getFormatiedeStudiu().compareTo(b.getFormatiedeStudiu());
            if (dupa_formatie != 0) {
                return dupa_formatie;
            }
            return a.getNume().compareTo(b.getNume());
        });


        Path outputPath2 = Paths.get("src/Laborator1/students_out_sorted.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath2)) {
            for (Student s : studenti) {
                writer.write(s.toString());
                writer.newLine();
            }
        }
    }
}
