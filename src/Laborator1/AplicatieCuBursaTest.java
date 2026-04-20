package Laborator1;
import org.junit.jupiter.api.*;
import java.util.List;

public class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {

        List<StudentBursieri> lista = appCuBursa.genereaza();


        List<StudentBursieri> sortata = appCuBursa.sorteaza(lista);


        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursieri s1 = sortata.get(i);
            StudentBursieri s2 = sortata.get(i + 1);

            int cmpFormatie = s1.getFormatiedeStudiu().compareTo(s2.getFormatiedeStudiu());
            if (cmpFormatie != 0) {
                Assertions.assertTrue(cmpFormatie <= 0);
                continue;
            }

            int cmpNume = s1.getNume().compareTo(s2.getNume());
            if (cmpNume != 0) {
                Assertions.assertTrue(cmpNume <= 0);
                continue;
            }

            int cmpPrenume = s1.getPrenume().compareTo(s2.getPrenume());
            if (cmpPrenume != 0) {
                Assertions.assertTrue(cmpPrenume <= 0);
                continue;
            }

            int cmpNota = Float.compare(s1.getNota(), s2.getNota());
            if (cmpNota != 0) {
                Assertions.assertTrue(cmpNota <= 0);
                continue;
            }

            Assertions.assertTrue(
                    Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa()) <= 0
            );
        }
    }
}