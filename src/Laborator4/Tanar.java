package Laborator4;

public class Tanar {

    private String name;
    private int age;
    private String adress;

    public String getName()
    {
        return name;

    }
    public int getAge()
    {
        return age;
    }
    public String getAdress()
    {
        return adress;
    }

    public Tanar(String name) {
        this.name = name;
    }

    public Tanar(String name, int age, String adress)
    {
        this.name=name;
        this.age=age;
        this.adress=adress;
    }

public String toString(){
    return "nume: "+name+", "+"varsta: "+age+", "+"adresa: "+adress;
    }
}





