package com.pluralsight.calcengine;

/**
 * Created by Jim on 10/18/2015.
 */
public class CalculateHelper {
    private static final char ADD_SYMBOL = '+'; // named constant
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathCommand command;
    double leftValue;
    double rightValue;
    double result;
    // sırasıyla 1. left value - right value 2. command 3. result hesaplanıyor

    public void process(String statement) {
        // statement örneği: add 1.0 2.0
        String[] parts = statement.split(" "); // statement parçalara ayrıldı
        String commandString = parts[0]; // add
        leftValue = Double.parseDouble(parts[1]); // 1.0
        rightValue = Double.parseDouble(parts[2]); // 2.0

        setCommandFromString(commandString);
        // string command has been translated into math command enum

        // according to command we get the appropriate CalculateBase
        // derived class to do the work
        CalculateBase calculator = null;
        // CalculateBase tek işlem barındırdığından array ile yaratılmamış
        switch (command) {
            case Add: // no need to write enum name in switch sta (sadece tanımlarken zorunluydu)
                calculator = new Adder(leftValue, rightValue); // polymorphism
                // subclass constructor called
                break;
            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate(); // subclass called through base class
        result = calculator.getResult();


    }

    private void setCommandFromString(String commandString) {
        // add -> MathCommand.Add
        // we are trying to take the string value and convert that into
        // MathCommand.Add (enum)

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
        // == olmazdı equals yerine
        // enum toString ile stringe çevrildi ve stringe ait equals metodu kullanıldı
            command = MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString() {
        // 1.0 + 2.0 = 3.0
        char symbol = ' '; // initialized
        switch(command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        // StringBuilder consists of 20 characters (for memory efficiency)
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }


}
