package Laborator10;

import java.util.List;

public class Exporter {
    void startExport(IStudentiExport strategyInstance, List<Student> student)
    {
        strategyInstance.doExport(student);
    }
}
