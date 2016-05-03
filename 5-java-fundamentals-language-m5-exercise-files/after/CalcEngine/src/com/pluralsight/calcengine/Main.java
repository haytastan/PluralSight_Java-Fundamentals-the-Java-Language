package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
//        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

        // MathEquation array is created above and individual
        // instances of MathEquation is created below
        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100.0d, 50.0d, 'd');
        /*for each loop olmasa her bir array elemanı için
        aşağıdaki işlemler yapılacaktı:

        equations[0].execute();
        System.out.print("result = ");
        System.out.println(equations[0].getResult());*/
        equations[1] = create(25.0d, 92.0d, 'a');
        equations[2] = create(225.0d, 17.0d, 's');
        equations[3] = create(11.0d, 3.0d, 'm');
        // instance of MathEquation is returned rather than
        // directly creating for each of the array members like below
        // equations[0] = equation demek ile aynı

        /*create metodu kullanılmadan ve MathEquation
        class'ında constructor yaratılarak:

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d, 50.0d, 'd');
        equations[1] = new MathEquation(25.0d, 92.0d, 'a');
        equations[2] = new MathEquation(225.0d, 17.0d, 's');
        equations[3] = new MathEquation(11.0d, 3.0d, 'm');

        parametre olmasaydı for loop kullanılabilirdi*/


//      for each member of MathEquation array for each loop is executed
        for(MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        // returns instance of MathEquation
        // and sets the variables for MathEquation class
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);

        return equation;
    }
}
