package Lab2;
 import java.util.*;


public class  Main {
    public static void main(String[] args){

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();

        Random rand= new Random();

        for (int i =0;i<5;i++)
        {
            x.add(rand.nextInt(11));
        }
        for (int i =0;i<5;i++)
        {
            y.add(rand.nextInt(11));
        }
        xPlusY.addAll(x);
        xPlusY.addAll(y);
    }
}
