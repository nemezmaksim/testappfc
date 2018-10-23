package tools;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * Checks input Amount field is correct.
 */
public class AmountFieldCheck {

    private static Pattern DIGIT_PATTERN = Pattern.compile(
            "\\d+(\\.\\d+)?");

    private boolean matchesDate(String date) {
        return DIGIT_PATTERN.matcher(date).matches();
    }

    public void checkNumeric(String amount) {
        boolean result = DIGIT_PATTERN.matcher(amount).matches();
        if (!result) {
            JOptionPane.showMessageDialog(null, "Please enter correct amount");
            throw new NumberFormatException("Field does not contain digits");
        }
    }


}
