package Laborator7.lab7;

import Laborator7.lab7.forms.Circle;
import Laborator7.lab7.forms.Form;
import Laborator7.lab7.forms.Square;
import Laborator7.lab7.forms.Triangle;
import Laborator7.lab7.util.PasswordMaker;


import Laborator7.lab7.Student;
import java.util.LinkedHashSet;
import java.util.Set;


public class Main {
    static Set<Student> imparteInDouaFormatii(Set<Student> studenti,
                                              String formatia1, String formatia2) {
        Set<Student> rezultat = new LinkedHashSet<>();
        int total = studenti.size();
        int dimF1 = (total % 2 == 0) ? total / 2 : total / 2 + 1;
        int index = 0;
        for (Student st : studenti) {
            rezultat.add(schimbaFormatia(st, index < dimF1 ? formatia1 : formatia2));
            index++;
        }
        return rezultat;
    }

    static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(st.getNrMatricol(), st.getPrenume(),
                st.getNume(), nouaFormatie, st.getNota());
    }
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());


        // 7.6.3
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(1, "Ion", "Popescu", "", 9.5f));
        studenti.add(new Student(2, "Maria", "Ionescu", "", 8.0f));
        studenti.add(new Student(3, "Andrei", "Popa", "", 7.5f));
        studenti.add(new Student(4, "Elena", "Stan", "", 9.0f));
        studenti.add(new Student(5, "Vlad", "Matei", "", 6.5f));
        studenti.add(new Student(6, "Ana", "Dumitrescu", "", 8.5f));
        studenti.add(new Student(7, "Cristian", "Radu", "", 7.0f));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("\n7.6.3 Studenti dupa impartire:");
        studenti.forEach(s -> System.out.println("  " + s));
    }
}
