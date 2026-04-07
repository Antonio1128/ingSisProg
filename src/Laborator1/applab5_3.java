package Laborator1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class applab5_3 {

    static void writeToFile(String filename, Collection<? extends Student> studenti) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (Student s : studenti) {
                fw.write(s.toString() + "\n");
            }
            System.out.println("salvat in " + filename);
        } catch (IOException e) {
            System.out.println("eroare la scriere: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Set<StudentBursieri> bursieri = new HashSet<>();

        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        writeToFile("src/Laborator1/bursieri_out.txt", bursieri);
    }
}