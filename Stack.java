package RPNCalculator.utils;

public class Stack {

    static final int MAX = 25;
    public static String[] stackArray = new String[MAX];
    public static int size = 0;


    public static void push(String value) {
        stackArray[size++] = value;
    }


    public static void removeTop() {
        stackArray[size-1] = null;
        size--;
    }


    public static double getTopDouble() {
        if (size > 0) {
            double value = Converter.getDouble(stackArray[size-1]);
            stackArray[(size--) - 1] = null;
            return value;
        }
        return 0.0;
    }


    public static void resetStack() {
        stackArray = new String[MAX];
        size = 0;
    }
}
