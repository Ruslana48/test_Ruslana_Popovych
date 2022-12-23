package com.springtest.test_ruslana_popovych.controller;

import lombok.Data;

@Data
public class ResponseDTO {
    String currencyName;
    double price;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
