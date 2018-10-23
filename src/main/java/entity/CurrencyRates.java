package entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRates {

    @SerializedName("date")
    private String date;
    @SerializedName("rates")
    private Rates rates;
    @SerializedName("base")
    private String base;

    public CurrencyRates(String date, Rates rates, String base) {
        this.date = date;
        this.rates = rates;
        this.base = base;
    }

    public CurrencyRates() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }


    @Override
    public String toString() {
        return "CurrencyRates{" +
                "date='" + date + '\'' +
                ", rates=" + rates.getRuble() +
                ", base='" + base + '\'' +
                '}';
    }
}
