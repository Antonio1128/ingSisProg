package Laborator3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {

    public static void main(String[] args) throws IOException {
//3.5.1
        String continut = new String(Files.readAllBytes(Paths.get("src/Laborator3/in.txt")));
        String[] linii = continut.split("\n");
//a
        for(String linie :linii)
        {
            System.out.println(linie+"\n");

        }
//b
        for (String linie : linii) {
            String[] propozitii = linie.split("\\.");
            for (String propozitie : propozitii) {
                System.out.println(propozitie.trim() + ".");
            }
        }

   //c
        Path outputPath = Paths.get("src/Laborator3/out.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            for (String linie : linii) {
                writer.write(linie + "\n");
                writer.newLine();
            }

            for (String linie : linii) {
                String[] propozitii = linie.split("\\.");
                for (String propozitie : propozitii) {
                    writer.write(propozitie.trim() + ".");
                    writer.newLine();
                }
            }
        }

    }
}
