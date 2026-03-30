package Laborator1;

import java.util.Objects;

public class Student extends Object {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String formatiedeStudiu;
    private float nota;




    public float getNota(){return nota;}

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatiedeStudiu() {
        return formatiedeStudiu;
    }

    public int getNrMatricol() {
        return nrMatricol;
    }

    public Student(int nrMatricol, String prenume, String nume, String formatiedeStudiu)
    {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatiedeStudiu = formatiedeStudiu;
    }
    public String toString() {
        return nrMatricol + " " + prenume + " " + nume + " " + formatiedeStudiu+" "+nota;
    }
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return nrMatricol == student.getNrMatricol();
    }

    public void setNota(float nota)
    {
        this.nota=nota;

    }

    public int hashCode() {

        return Objects.hash(nrMatricol);
    }
}

