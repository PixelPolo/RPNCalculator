package RPNCalculator.utils;

import javafx.event.ActionEvent;

public class ButtonChecker {

    private static String valuePressed = "";
    private static StringBuilder numberSB = new StringBuilder();


    public static void checkButtons(ActionEvent e) {
        valuePressed = Converter.getStringValueOfButtonPressed(e);
        checkNumericValueAndPushIntoStack(valuePressed);
        checkOperatorAndComputes(valuePressed);
        checkSwapButton(valuePressed);
        checkCEAndCButtons(valuePressed);
    }


    public static void resetGlobalVar() {
        valuePressed = "";
        numberSB = new StringBuilder();
    }


    public static void checkNumericValueAndPushIntoStack(String valuePressed) {
        // fill the StringBuilder with digits, "." and "(-)"
        if (valuePressed.matches("\\d")) numberSB.append(valuePressed);
        else if (valuePressed.matches("\\.") && numberSB.length() == 0) numberSB.append("0.");
        else if (valuePressed.matches("\\.") && !numberSB.toString().contains(".")) numberSB.append(".");
        else if (valuePressed.matches("\\(-\\)") && numberSB.length() == 0) numberSB.insert(0, "-0.");
        else if (valuePressed.matches("\\(-\\)") && !numberSB.toString().contains("-")) numberSB.insert(0, "-");
        // operators and swap buttons reset the StringBuilder
        else if (valuePressed.matches("[+\\-*/]") || valuePressed.matches("Swap")) numberSB = new StringBuilder();
        // Push a String into the Stack if Enter is pressed
        String numericValue = new String(numberSB);
        if (numericValue.length() != 0 && valuePressed.contains("Enter")) {
            Stack.push(Converter.strDoubleStrFormatter(numericValue));
            resetGlobalVar();
        }
    }


    public static void checkOperatorAndComputes(String valuePressed) {
        double result = 0;
        if (valuePressed.matches("[+\\-*/]")) {
            double numbA = Stack.getTopDouble();
            double numbB = Stack.getTopDouble();
            if (valuePressed.matches("\\+")) result = numbA + numbB;
            else if (valuePressed.matches("-")) result = numbA - numbB;
            else if (valuePressed.matches("\\*")) result = numbA * numbB;
            else if (valuePressed.matches("/")) result = numbA / numbB;
            Stack.push(String.valueOf(result));
            resetGlobalVar();
        }
    }


    public static void checkSwapButton(String valuePressed) {
        if (valuePressed.matches("Swap") && Stack.size > 1) {
            String temp = Stack.stackArray[Stack.size-1];
            Stack.stackArray[Stack.size-1] = Stack.stackArray[Stack.size-2];
            Stack.stackArray[Stack.size-2] = temp;
        }
    }


    public static void checkCEAndCButtons(String valuePressed) {
        if (valuePressed.matches("CE")) Stack.resetStack();
        if (valuePressed.matches("C") && Stack.size != 0) Stack.removeTop();
    }
}
