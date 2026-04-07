package Laborator5.advanced;

public class Lab5adv {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = (Integer) calculator.add(5).subtract(3).multiply(2).result();
        System.out.println(result);

        DoubleCalculator fCalculator = new DoubleCalculator(10);
        double result2 = (Double) fCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println(result2);
    }
}