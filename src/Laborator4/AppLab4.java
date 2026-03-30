package Laborator4;
import java.util.Map;
import java.util.HashMap;

public class AppLab4 {
    static void main(String[] args) {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

 //4.5.1
        for (String nume : varste.keySet())
       System.out.println(nume+" "+ varste.get(nume));


   varste.put("Vlad",19);
   varste.put("Iulia",19);

   HashMap<String, Tanar> tineri=new HashMap<>();

for(String nume: varste.keySet()) {

    int varsta=varste.get(nume);
    String adress= adrese.get(nume);
    tineri.put(nume, new Tanar(nume, varsta, adress));
}
for (String nume : tineri.keySet()) {
            System.out.println(tineri.get(nume));
        }
    }


}
