public class Student {
    private int nrMatricol;
    private String prenume;
    private String nume;
    private String formatiedeStudiu;


    public Student(int nrMatricol, String prenume, String nume, String formatiedeStudiu) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatiedeStudiu = formatiedeStudiu;
    }

    public String toString() {
        return "nr matricol: " + nrMatricol + "\n" + "prenume: " + prenume + "\n" + "nume: " + nume + "\n" + "formatie de studiu: " + formatiedeStudiu;
    }
}
