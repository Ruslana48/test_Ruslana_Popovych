package com.springtest.test_ruslana_popovych.controller;

import com.springtest.test_ruslana_popovych.model.CryptoModel;

import java.util.List;

public interface CryptoInterface {
    List<CryptoModel>findAll();
    List<CryptoModel> findAllByCurrencyPair(String pair);
}
