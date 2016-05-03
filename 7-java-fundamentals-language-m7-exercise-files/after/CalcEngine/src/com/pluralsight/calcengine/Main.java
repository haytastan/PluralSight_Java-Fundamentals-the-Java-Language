package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');
//        tek object kullanılacağı için array ile yaratılmamış. alt:

//        MathEquation[] equationOverload = new MathEquation[1];
//        equationOverload[0] = new MathEquation('d');
//        for(MathEquation equation : equationOverload) {
//            equation.execute(leftDouble, rightDouble);
//            System.out.print("result=");
//            System.out.println(equation.getResult());
//
//            equation.execute(leftInt, rightInt);
//            System.out.print("result=");
//            System.out.println(equation.getResult());
//
//            equation.execute((double)leftInt, rightInt);
//            System.out.print("result=");
//            System.out.println(equation.getResult());
//        }

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
//        widening conversion to double (automatic) would have been done if
//        execute method with int parameters didn't exist
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
//        automatic upcasting is done and execute method with
//        double parameters is called
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

    }

}