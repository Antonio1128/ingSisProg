package Laborator9;


import java.util.*;
import java.util.stream.*;

public class lab9 {

    public static void main(String[] args) {

        //Problema931();

       // Problema932();

        Problema933();
    }


    public static void Problema931() {
        Random random = new Random();
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21)) // [cite: 301]
                .boxed()
                .collect(Collectors.toList());
        System.out.println("lista initiala: " + numere);


        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("a) suma: " + suma);


        numere.stream().max(Comparator.naturalOrder()).ifPresent(m -> System.out.println("b) max: " + m));
        numere.stream().min(Comparator.naturalOrder()).ifPresent(m -> System.out.println("b) min: " + m));


        List<Integer> filtrata = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) elemente [10..20]: " + filtrata);


        List<Double> numereDouble = numere.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("d) lista Double: " + numereDouble);


        boolean gasit12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("e) contine 12: " + gasit12);
    }


    public static void Problema932() {
        String text = "acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));


        List<String> lungi = cuvinte.stream()
                .filter(s -> s.length() >= 5)
                .peek(s -> {})
                .collect(Collectors.toList());
        System.out.println("a) auvinte >= 5 caractere: " + lungi + " (total: " + lungi.size() + ")");


        List<String> ordonate = lungi.stream().sorted().collect(Collectors.toList());
        System.out.println("b) lista ordonata: " + ordonate);


        cuvinte.stream()
                .filter(s -> s.startsWith("p"))
                .findFirst()
                .ifPresent(s -> System.out.println("c)eElement cu 'p': " + s));
    }


    public static void Problema933() {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70f),
        new Student(1024,"Ioan","Mihalcea","ISM141/1", 10.0f),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90f),
                new Student(1029,"Bianca","Popescu","TI131/1", 10.0f),
                new Student(1029,"Maria","Pana","TI131/2", 4.10f),
                new Student(1029,"Gabriela","Mohanu","TI131/2", 7.33f),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20f),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12f),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22f)
        );


        System.out.print("a) nota 10: ");
        studentiCuNote.stream().filter(s -> s.getNota() == 10).forEach(s -> System.out.print(s.getNume() + " "));


        System.out.print("\nb) nota < 5: ");
        studentiCuNote.stream().filter(s -> s.getNota() < 5).forEach(s -> System.out.print(s.getNume() + " "));

        List<Float> noteMin4 = studentiCuNote.stream()
                .map(s -> s.getNota() < 4 ? 4.0f : s.getNota())
                .collect(Collectors.toList());
        System.out.println("\nc) note (min 4): " + noteMin4);


        double suma = studentiCuNote.stream()
                .map(Student::getNota)
                .reduce(0f, Float::sum);
        System.out.println("d) suma notelor: " + suma);


        System.out.println("e) media: " + (suma / studentiCuNote.size()));
    }
}

