package com.springtest.test_ruslana_popovych.model;

import lombok.Data;

import java.util.List;

@Data
public class SortedPage {
    private String cryptoName;
    private Integer page_number;
    private List<Double> sortedPriceList;

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public Integer getPage_number() {
        return page_number;
    }

    public void setPage_number(Integer page_number) {
        this.page_number = page_number;
    }

    public List<Double> getSortedPriceList() {
        return sortedPriceList;
    }

    public void setSortedPriceList(List<Double> sortedPriceList) {
        this.sortedPriceList = sortedPriceList;
    }
}
