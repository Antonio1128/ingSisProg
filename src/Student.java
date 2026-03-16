import java.util.Objects;

public class Student extends Object {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String formatiedeStudiu;

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatiedeStudiu() {
        return formatiedeStudiu;
    }

    public Student(int nrMatricol, String prenume, String nume, String formatiedeStudiu)
    {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatiedeStudiu = formatiedeStudiu;
    }
    public String toString() {
        return nrMatricol + " " + prenume + " " + nume + " " + formatiedeStudiu;
    }
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return prenume.equals(student.prenume) &&
                nume.equals(student.nume) &&
                formatiedeStudiu.equals(student.formatiedeStudiu);
    }


    public int hashCode() {

        return Objects.hash(prenume, nume, formatiedeStudiu);
    }
}

