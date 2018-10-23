package tools;

import com.google.gson.Gson;
import entity.CurrencyRates;

import javax.swing.*;

/**
 * Pars the data from the response in JSON and initializes CurrencyRates.class, Rates.class.
 */
public class ParseResponse {

    public static CurrencyRates parse(String response) {
        Gson gson = new Gson();
        CurrencyRates currencyRates = gson.fromJson(response, CurrencyRates.class);
        if (currencyRates.getRates().getRuble() == null) {
            JOptionPane.showMessageDialog(null, "Sorry, the API does not contain RUB information for the specified date");
            throw new NullPointerException("Sorry, the API does not contain RUB information for the specified date");
        }

        return currencyRates;
    }
}
