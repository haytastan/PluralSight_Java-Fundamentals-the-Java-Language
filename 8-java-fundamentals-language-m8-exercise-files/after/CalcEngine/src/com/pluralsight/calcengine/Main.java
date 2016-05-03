package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        MathEquation[] equations = new MathEquation[4];
        // array, MathEquation class'ı (subclass üzerinden değil)
        // doğrudan kullanmak için yaratılmış
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
//        alt:
//        MathEquation[] equations = {
//                new MathEquation('d', 100.0d, 50.0d),
//                new MathEquation('a', 25.0d, 92.0d),
//                new MathEquation('s', 225.0d, 17.0d),
//                new MathEquation('m', 11.0d, 3.0d)
//        };


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
        // tek object kullanılacağı için (sadece bölme işlemi yapılıyor)
        // array ile yaratılmamış

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double) leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        // polymorphism olur: eşitliğin sol tarafı super class sağ tarafı ise sub class
        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        // eşitliğin sağ tarafı ile array elemanları için instantion ve initialization işlemleri yapılıyor
        // subclass yaratılınca subclass'daki constructor otomatik olarak çağırılıyor
        };
//        alt:
//        CalculateBase[] calculators = new CalculateBase[4];
//        Divider d = new Divider(100.0d, 50.0d);
//        calculators[0] = d;
//        calculators[1] = new Adder(25.0d, 92.0d);
//        calculators[2] = new Subtracter(225.0d, 17.0d);
//        calculators[3] = new Multiplier(11.0d, 3.0d);
//        polymorphism ilişkisi var 4'ünde de

        for(CalculateBase calculator:calculators) {
            calculator.calculate(); // her subclass için farklı class'a göre hareket eder
            System.out.print("result=");
            System.out.println(calculator.getResult());
        }

//        Polymorphism örneği:
//        CalculateBase x = new Adder();
//        System.out.println(x.x);
//        System.out.println(x.y());

    }

}
/*
result = 2.0
result = 117.0
result = 208.0
result = 33.0

Using Overloads

result=2.25
result=2.0
result=2.25

Using Inheritance

result=2.0
result=117.0
result=208.0
result=33.0
 */
