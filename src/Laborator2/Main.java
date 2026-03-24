package Laborator2;
 import java.util.*;


public class  Main {
    public static void main(String[] args){

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
    int p=4;
        List<Integer> xPlusYLimitedByP = new ArrayList();
        Random rand= new Random();

        for (int i =0;i<5;i++)
        {
            x.add(rand.nextInt(11));
        }
        for (int i =0;i<5;i++)
        {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println(x);
        System.out.println(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println("xPlusY="+xPlusY);

        for(Integer val: x)
        {
            if (y.contains(val))
            {
                zSet.add(val);
            }
        }

        System.out.println("zSet = " + zSet );


        for(Integer val:x)
        {
            if(!y.contains(val))
            {
                xMinusY.add(val);
            }

        }

        System.out.println("xMinusY = "+xMinusY);


        for(Integer val : xPlusY)
        {

            if(val<=p)
            {
                xPlusYLimitedByP.add(val);
            }
            System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP );
        }
    }


}
