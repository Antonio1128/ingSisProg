package Laborator5;
import java.lang.Math;

import static java.lang.Math.pow;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state)
    {
        super(state);
    }

    public AdvancedCalculator divide(int value)
    {
        if(value!=0)
        {
            setState(getState()/value);
            return this;
        }

        else
        {
            System.out.println("error/0");
            return this;
        }


    }
    public AdvancedCalculator power(int value) {
        setState((int) pow(getState(), value));
        return this;
    }
    public AdvancedCalculator rdcl(int n) {
        if (getState() < 0) {
            System.out.println("eroare <0");
            return this;
        }
        setState((int) pow(getState(), 1.0 / n));
        return this;
    }
}


