package RPNCalculator.utils;

import javafx.event.ActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    public static String getStringValueOfButtonPressed(ActionEvent e) {
        String regex = "'.*'";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(e.getSource().toString());
        String value;
        if (m.find()) {
            value = m.group();
            value = value.replace("'", "");
            if (value.equals("x")) value = value.replace("x", "*");
        } else {
            value = "";
        }
        return value;
    }


    public static boolean checkIfOperators (String str) {
        return str.matches("[+\\-*/]");
    }


    public static double getDouble(String str) {
        if (str != null && !checkIfOperators(str)) {
            return Double.parseDouble(str);
        }
        return 0;
    }


    public static String strDoubleStrFormatter(String str) {
        if (str != null) {
            if (checkIfOperators(str)) return str;
            else return String.valueOf(Double.parseDouble(str));
        }
        return "0";
    }
}
