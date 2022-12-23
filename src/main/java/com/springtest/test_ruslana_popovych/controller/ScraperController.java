package com.springtest.test_ruslana_popovych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/test")
public class ScraperController {
    @Autowired
    ScraperService scraperService;

    @GetMapping(path = "/{prices}")
    public Set<ResponseDTO> getCex(@PathVariable String prices) {
        return  scraperService.getCrypto(prices);
    }
}
