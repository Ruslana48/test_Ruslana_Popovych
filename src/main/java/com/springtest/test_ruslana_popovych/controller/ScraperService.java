package com.springtest.test_ruslana_popovych.controller;

import com.springtest.test_ruslana_popovych.controller.ResponseDTO;

import java.util.Set;

public interface ScraperService {
    Set<ResponseDTO> getCrypto(String vehicleModel);
}
