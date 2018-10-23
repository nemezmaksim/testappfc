package entity;

import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("RUB")
    private Double ruble;

    public Double getRuble() {
        return ruble;
    }

    public void setRuble(Double ruble) {
        this.ruble = ruble;
    }

}
