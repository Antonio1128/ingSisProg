package Laborator10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport{
    public void doExport(List<Student> studenti)

    {
        for (Student s : studenti) {
            System.out.println(s);
        }

    }
}
