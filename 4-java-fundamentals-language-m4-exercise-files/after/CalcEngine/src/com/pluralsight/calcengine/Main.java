package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        // parallel arrays
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
//	    double val1 = 100.0d;
//        double val2 = 50.0d;
//        double result;
//        char opCode = 'd';

        for(int i = 0; i < opCodes.length; i++) {
            switch(opCodes[i]) {
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'd':
                    results[i] = rightVals[i] != 0.0d ? leftVals[i] / rightVals[i] : 0.0d;
//            if(val2 != 0.0d)
//                result = val1 / val2;
//            else
//                result = 0.0d;
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                default:
                    System.out.println("Error - invalid opCode");
                    results[i] = 0.0d;
                    break;
            }
        } // first for loop executes the operation and stores the value in results
        // second for loop prints the result
        for(double theResult : results) {
            System.out.print("result = ");
            System.out.println(theResult);
        }
    }
}
/*
result = 2.0
result = 117.0
result = 208.0
result = 33.0
 */
