import java.util.ArrayList;
import java.util.List;

public class Main {


    public static boolean existaStudent(List<Student> lista , Student s)
    {
    for(Student student :lista )
    {
        if (student.getNume().equals(s.getNume()) && student.getPrenume().equals(s.getPrenume()) && student.getFormatiedeStudiu().equals(s.getFormatiedeStudiu()))

        return true;
    }
      return false;
}
    public static void main(String[] args) {

        Student s1 = new Student(591, "Antonio", "Popelca", "ISM21/1");
      //  System.out.println(s1);

        List<Student> listaStudenti = new ArrayList<>();

        listaStudenti.add(new Student(596, "Sergiu ", "Tanase", "ISM21/1"));
        listaStudenti.add(new Student(242, "Claudiu", "Stefan", "ISM21/1"));
        listaStudenti.add(new Student(112, "Maria", "Popa", "TI21/1"));

        for (Student s : listaStudenti) {
            System.out.println(s);
        }
        Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println("Prezent? Alis Popa? " + existaStudent(listaStudenti, s2));

        Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Prezent: Maria Popa? " + existaStudent(listaStudenti, s3));
    }

}

