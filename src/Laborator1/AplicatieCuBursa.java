package Laborator1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AplicatieCuBursa {

    public static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursieri> lista = instanta.genereaza();
        for (StudentBursieri student : lista) {
            System.out.println(student);
        }

        List<StudentBursieri> sortata = instanta.sorteaza(lista);
        for (StudentBursieri student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursieri> genereaza() {
        List<StudentBursieri> lista = new ArrayList<>();
        lista.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        lista.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        lista.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));
        lista.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        lista.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 100.00));
        return lista;
    }

    public List<StudentBursieri> sorteaza(List<StudentBursieri> lst) {
        lst.sort(Comparator
                .comparing(StudentBursieri::getFormatiedeStudiu)
                .thenComparing(StudentBursieri::getNume)
                .thenComparing(StudentBursieri::getPrenume)
                .thenComparingDouble(s -> s.getNota())
                .thenComparingDouble(StudentBursieri::getCuantumBursa)
        );
        return lst;
    }
}
