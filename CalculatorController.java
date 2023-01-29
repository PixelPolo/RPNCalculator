package RPNCalculator;

import RPNCalculator.utils.ButtonChecker;
import RPNCalculator.utils.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label
            stackLabel1, stackLabel2, stackLabel3, stackLabel4,
            stackLabel5, stackLabel6, stackLabel7, stackLabel8,
            stackSizeLabel;

    @FXML
    protected void buttonPressed(ActionEvent e) {
        ButtonChecker.checkButtons(e);
        updateScreen();
    }

    @FXML
    protected void updateScreen() {
        stackSizeLabel.setText("Stack size : " + Stack.size);
        stackLabel1.setText(Stack.stackArray[0]);
        stackLabel2.setText(Stack.stackArray[1]);
        stackLabel3.setText(Stack.stackArray[2]);
        stackLabel4.setText(Stack.stackArray[3]);
        stackLabel5.setText(Stack.stackArray[4]);
        stackLabel6.setText(Stack.stackArray[5]);
        stackLabel7.setText(Stack.stackArray[6]);
        stackLabel8.setText(Stack.stackArray[7]);
    }
}
