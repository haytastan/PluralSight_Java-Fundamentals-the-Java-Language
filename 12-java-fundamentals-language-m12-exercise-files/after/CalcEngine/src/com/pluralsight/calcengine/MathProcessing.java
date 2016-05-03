package com.pluralsight.calcengine;

/**
 * Created by Jim on 11/16/2015.
 */
public interface MathProcessing { // !!! CalculateHelper class'daki final variable'lara gerek kalmadı
    String SEPARATOR = " "; // variables are constants in interface
    String getKeyword(); // add
    char getSymbol(); // +
    double doCalculation(double leftVal, double rightVal);
//    getKeyword, getSymbol, doCalculation are abstract methods implemented by subclass
}
