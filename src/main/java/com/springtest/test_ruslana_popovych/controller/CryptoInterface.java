package com.springtest.test_ruslana_popovych.controller;

import com.springtest.test_ruslana_popovych.model.CryptoModel;

import java.util.List;

public interface CryptoInterface {
    public List<CryptoModel> sortingAndPaginationPages(String cryptoName, int page_number, int page_size);
}
