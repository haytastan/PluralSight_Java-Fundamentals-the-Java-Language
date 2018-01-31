package com.pluralsight.myapp;

import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtracter;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.Divider;

public class Main {

    public static void main(String[] args) {
//        useMathEquation();
//        useCalculatorBase();
//        useCalculateHelper();
//        CalculateBase class is used through CalculateHelper.
//        CalculateBase class is still accessed since being extended by Adder class
//        commented out sections might be used and might call new methods

//        System.out.println(new Adder().x()); // ref variable'a gerek yok

        String[] statements = {
                "add 25.0 92.0",       // 25.0 + 92.0 = 117.0
                "power 5.0 2.0"        // 5.0 ^ 2.0 = 25.0
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                // array (argument olarak) toptan yollandı
                // DynamicHelper class'daki metodun parametresi array olacak ve arrayi
                // ayırmak için for-each loop kullanılacak
                new Adder(),
                new PowerOf()
        });
        /** alt:
         * MathProcessing[] mp = {new Adder(), new PowerOf()}; // !!!polymorphism var!!!
         * DynamicHelper helper = new DynamicHelper(mp);
         */

        for(String statement:statements) {
            String output = helper.process(statement);
            // array (argument olarak) tek tek yollandı for-each loop ile
            // DynamicHelper class'daki metodun parametresi String olacak ve arrayi
            // ayırmak için for loop gerekmeyecek
            System.out.println(output);
        }

    }

    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0",             // Error: incorrect number of values
                "add xx 25.0",         // Error: non-numeric data
                "addX 0.0 0.0",        // Error: invalid command
                "divide 100.0 50.0",   // 100.0 / 50.0 = 2.0
                "add 25.0 92.0",       // 25.0 + 92.0 = 117.0
                "subtract 225.0 17.0", // 225.0 - 17.0 = 108.0
                "multiply 11.0 3.0"    // 11.0 * 3.0 = 33.0
        };

        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements) {
            try {
                helper.process(statement); // array argument olarak tek tek yollandı
                System.out.println(helper);
            } catch(InvalidStatementException e) {
                System.out.println(e.getMessage());
                if(e.getCause() != null)
                    System.out.println("  Original exception: " + e.getCause().getMessage());
            }
        }
    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations) {
            // arrayin for loop ile tek tek ayrılması zorunlu
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
//        array'e gerek yok, tek instance yeterli

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double) leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());
    }

    static void useCalculatorBase() {
        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = { // !!!polymorphism var!!!
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators) {
            // arrayin for loop ile tek tek ayrılması zorunlu
            calculator.calculate();
            System.out.print("result=");
            System.out.println(calculator.getResult());
        }
    }
}
