package com.pluralisght.typeconversion;

public class Main {

    public static void main(String[] args) {
        float floatVal = 1.0f;
        double doubleVal = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        System.out.println((double)longVal);

        short result1 = (short)byteVal; // short opsiyonel
        double res = byteVal;
        System.out.println(byteVal);
        System.out.println(res);

        System.out.println(byteVal - doubleVal); // upcasting otomatik
        short result2 = (short)(byteVal - longVal);

        float result3 = (float)(longVal - doubleVal);
        // whenever we have integer type and floating point type
        // the result will be floating point type

        long result4 = (long)(shortVal - longVal + floatVal + doubleVal);

        System.out.println("Success");
    }
}
/*
5.0
7
7.0
3.0
Success
 */
