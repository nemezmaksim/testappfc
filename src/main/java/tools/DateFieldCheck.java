package tools;

import javax.swing.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Checks input BuyDate field is correct.
 */
public class DateFieldCheck {

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");

    private boolean matchesDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    private boolean checkActualDate(String date) {
        boolean result = true;

        LocalDate localDate = LocalDate.parse(date);
        LocalDate nowDate = LocalDate.now();

        if (localDate.getYear() < 1999 || localDate.isAfter(nowDate)) {
            result = false;
        }

        return result;
    }


    public boolean isValidDate(String date) {
        boolean result = true;

        if (matchesDate(date) == false) {
            JOptionPane.showMessageDialog(null, "Please enter correct date in format yyyy-mm-dd");
            result = false;
            return result;
        } else {
            if (!checkActualDate(date)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter actual date. We keep historical rates for any day from 1999 to the current time.");
                result = false;
                return result;
            }
        }

        return result;
    }


}
