package com.pluralsight.calcengine;

/**
 * Created by Jim on 10/10/2015.
 */
public class Adder extends CalculateBase implements MathProcessing{
//    we could have had the CalculateBase class implement the MathProcessing interface
//    if we wanted all classes that inherit from the CalculateBase class to implement the interface
    public Adder(){}
    public Adder(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        // setRightVal(rightVal) ve setLeftVal(leftVal) için 11. projede constructor kullanılmıştı
        calculate();

        return getResult();
//        calculate ve getResult metodları 11. projede CalculateHelper class'da idi
    }

//    public boolean x() {
//        return false;
//    }
}
