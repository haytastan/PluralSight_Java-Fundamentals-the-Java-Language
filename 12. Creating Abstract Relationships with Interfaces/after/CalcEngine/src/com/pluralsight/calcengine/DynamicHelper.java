package com.pluralsight.calcengine;

/**
 * Created by Jim on 11/16/2015.
 */
public class DynamicHelper {
    // dinamik olmasının sebebi yeni işlemlerin (e.g. üs alma)
    // DynamicHelper class'da değişiklik yapmadan eklenebilmesi
    private MathProcessing[] handlers; // önce null sonra new Adder() ve new PowerOf() store ediliyor
    // !!! handlers arrayi sayesinde enuma gerek kalmıyor ve equalsIgnoreCase metodu flexible oluyor
    // array for-each loop ile kullanılmak üzere (toptan) store edildi

    public DynamicHelper(MathProcessing[] handlers) { // array (variable misali) set edilebilir
        this.handlers = handlers;
    }

    public String process(String statement) {
        // IN: add 1.0 2.0
        // OUT: 1.0 + 2.0 = 3.0

        String[] parts = statement.split(MathProcessing.SEPARATOR);
        // MathProcessing.SEPARATOR: implicitly static constant
        String keyword = parts[0]; // add

        MathProcessing theHandler = null; // interface olduğu için

        for(MathProcessing handler:handlers) {
            if(keyword.equalsIgnoreCase(handler.getKeyword())) {
                // MathProcessing x = newAdder() -> x.getKeyword() gibi (?)
                // getKeyword metodu arraydeki objectlere ait
                theHandler = handler; // polymorphism olur: MathProcessing theHandler = new Adder() (?)
                break;
            }
        }

        double leftVal = Double.parseDouble(parts[1]); // 1.0
        double rightVal = Double.parseDouble(parts[2]); // 2.0

        double result = theHandler.doCalculation(leftVal, rightVal);

//        alt kısım copy paste CalculateHelper class'dan
        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();

    }
}
