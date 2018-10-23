package controller;

import calculate.Calculate;
import entity.CurrencyRates;
import tools.AmountFieldCheck;
import tools.DateFieldCheck;
import tools.HttpClient;
import tools.ParseResponse;
import view.ViewForm;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Handling button click
 */
public class Controller {

    private ViewForm viewForm;
    private CurrencyRates currentDate;
    private CurrencyRates buyDate;
    private Calculate calculate;
    private HttpClient httpClient;

    public Controller(ViewForm viewForm, CurrencyRates currentDate, CurrencyRates buyDate, Calculate calculate, HttpClient httpClient) {
        this.viewForm = viewForm;
        this.currentDate = currentDate;
        this.buyDate = buyDate;
        this.calculate = calculate;
        this.httpClient = httpClient;
    }

    public void initController() {
        viewForm.getCalculateButton().addActionListener(e -> {

            if (!checkInputDate()) {
                return;
            }
            checkInputAmount();

            String getResponseCurrentDate = httpClient
                    .doGetRequest(httpClient.createURL(LocalDate.now().toString()));
            String getResponseBuyDate = httpClient
                    .doGetRequest(httpClient.createURL(viewForm.getBuyDateField().getText()));

            currentDate = ParseResponse.parse(getResponseCurrentDate);
            buyDate = ParseResponse.parse(getResponseBuyDate);
            double total = calculateTotal();

            if (total > 0) {
                viewForm.getProfitLossField().setForeground(Color.GREEN);
                viewForm.getProfitLossField().setText(String.valueOf(converDoubleToBigDecimalRounded(total)));
            } else if (total < 0) {
                viewForm.getProfitLossField().setForeground(Color.RED);
                viewForm.getProfitLossField().setText(String.valueOf(converDoubleToBigDecimalRounded(total)));
            }
        });
    }

    private boolean checkInputDate() {
        DateFieldCheck dateFieldCheck = new DateFieldCheck();
        boolean result = dateFieldCheck.isValidDate(viewForm.getBuyDateField().getText().trim());
        return result;
    }

    private void checkInputAmount() {
        AmountFieldCheck amountFieldCheck = new AmountFieldCheck();
        amountFieldCheck.checkNumeric(viewForm
                .getAmountField().getText().trim());
    }

    private double calculateTotal() {
        double total = calculate.calculateProfitLoss(viewForm.getAmountField().getText(),
                currentDate.getRates().getRuble(),
                buyDate.getRates().getRuble());
        return total;
    }

    private BigDecimal converDoubleToBigDecimalRounded(double d) {
        BigDecimal bd = new BigDecimal(d);
        BigDecimal rounded = bd.setScale(2, RoundingMode.FLOOR);
        return rounded;
    }


}
