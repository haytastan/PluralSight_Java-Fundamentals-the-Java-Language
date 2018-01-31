package com.pluralsight.calcengine;

/**
 * Created by Jim on 10/10/2015.
 */
public class Adder extends CalculateBase {
//    public double x = 5;

    public Adder(){} // kullanılmadı
    public Adder(double leftVal, double rightVal){
        super(leftVal, rightVal); // links derived class to the base class
    }

    @Override
    public void calculate(){
        double value = getLeftVal() + getRightVal();
        // we use getters because fields are private
        setResult(value);
    }

//    public double y(){return x;}

}
