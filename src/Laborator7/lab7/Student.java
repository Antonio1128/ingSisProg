package Laborator7.lab7;

public final class Student {
    private final int nrMatricol;
    private final String prenume;
    private final String nume;
    private final String formatiedeStudiu;
    private final float nota;

    public Student(int nrMatricol, String prenume, String nume, String formatiedeStudiu, float nota) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatiedeStudiu = formatiedeStudiu;
        this.nota = nota;
    }

    public int getNrMatricol() { return nrMatricol; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatiedeStudiu() { return formatiedeStudiu; }
    public float getNota() { return nota; }

    @Override
    public String toString() {
        return nrMatricol + " " + prenume + " " + nume + " " + formatiedeStudiu + " " + nota;
    }
}