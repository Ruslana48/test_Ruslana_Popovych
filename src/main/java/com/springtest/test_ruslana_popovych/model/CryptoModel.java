package com.springtest.test_ruslana_popovych.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@Document(collection = "cryptoes")
public class CryptoModel {

    @Id
    private String id;
    private String cryptoName;
    private double Price;
    private Optional<Double> minPrice;
    private Optional<Double> maxPrice;

    public CryptoModel(String cryptoName, Optional<Double> minPrice, Optional<Double> maxPrice) {
        this.cryptoName = cryptoName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public CryptoModel(){
    }

    public CryptoModel(String id,String cryptoName, double price) {
        this.id=id;
        this.cryptoName = cryptoName;
        this.Price = price;
    }
    public CryptoModel(String cryptoName, double price) {
        this.cryptoName = cryptoName;
        this.Price = price;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "CryptoModel{" +
                "cryptoName='" + cryptoName + '\'' +
                ", price=" + Price +
                '}';
    }
}
