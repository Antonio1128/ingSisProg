package Laborator1;

import java.util.Objects;

public class StudentBursieri extends Student {

    private double cuantumBursa;

    public StudentBursieri(int nrMatricol, String prenume, String nume,
                           String formatiedeStudiu, float nota, double cuantumBursa) {
        super(nrMatricol, prenume, nume, formatiedeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }


    public String toString() {
        return super.toString() + " bursa=" + cuantumBursa;
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursieri that = (StudentBursieri) o;
        return Double.compare(cuantumBursa, that.cuantumBursa) == 0;
    }


    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}