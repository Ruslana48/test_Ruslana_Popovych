package com.springtest.test_ruslana_popovych.controller;

import com.springtest.test_ruslana_popovych.exceptions.NotFoundException;
import com.springtest.test_ruslana_popovych.model.CryptoModel;
import com.springtest.test_ruslana_popovych.model.SortedPage;
import com.springtest.test_ruslana_popovych.repository.CryptoRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.management.Query;
import javax.swing.*;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cryptocurrencies")
@Slf4j
@ResponseStatus(HttpStatus.OK)
public class CryptoController{
    @Autowired
    CryptoRepository repository;

    @GetMapping
    public String list(){
        return "index";
    }

    @GetMapping("/findAllCryptoes")
    public List<CryptoModel> getCryptoes(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    @GetMapping("/minprice")
    public Optional<Double> getMinPriceByName(@QueryParam("name") String name){
        return Optional.of(repository.findAll().stream().filter(c->c.getCryptoName().contains(name)).mapToDouble(CryptoModel::getPrice).min().getAsDouble());
    }

    @GetMapping("/maxprice")
    public Optional<Double> getMaxPriceByName(@QueryParam("name") String name){
        //if name mo exist exception print error message in console
        return Optional.ofNullable(Optional.of(repository.findAll().stream().filter(c -> c.getCryptoName().contains(name)).findFirst().orElseThrow(() -> new NotFoundException())).stream().mapToDouble(CryptoModel::getPrice).max().getAsDouble());
    }

    @GetMapping("/csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName="report.csv";
        String headerKey="Report";
        String headerValue="attachment; filename="+fileName;
        response.setHeader(headerKey,headerValue);

        List<CryptoModel>cryptoModels=repository.findAll();
        ICsvBeanWriter csvBeanWriter=new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String []csvHeader={"cryptoName","maxprice","minprice"};
        csvBeanWriter.writeHeader(csvHeader);
        CryptoModel tmpModel=null;
        Set<CryptoModel> cryptoModelHashSet = new HashSet<>();
        for (CryptoModel model:cryptoModels){
            Optional<Double>tmpMinPrice=getMinPriceByName(model.getCryptoName());
            Optional<Double>tmpMaxPrice=getMaxPriceByName(model.getCryptoName());
            tmpModel=new CryptoModel(model.getCryptoName(),tmpMinPrice,tmpMaxPrice);
            cryptoModelHashSet.add(tmpModel);
        }
        for (CryptoModel model:cryptoModelHashSet){
            System.out.println(model);
            String []nameMapping={"cryptoName", "maxprice","minprice"};
            csvBeanWriter.write(model,nameMapping);
        }
        csvBeanWriter.close();
    }

    @GetMapping("/")
    public SortedPage listPagination(@RequestParam String name, @RequestParam Optional<Integer> page,@RequestParam Optional<Integer> size){
        SortedPage sortedPage = new SortedPage();
        List<Double> priceList = repository.findAll().stream().filter(c->c.getCryptoName().contains(name))
                .map(CryptoModel::getPrice)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int pageNumber = page.orElse(0);
        int sizeNumber = size.orElse(10);
        sortedPage.setSortedPriceList(priceList
                .subList(pageNumber * sizeNumber, pageNumber * sizeNumber + sizeNumber));
        sortedPage.setCryptoName(name);
        sortedPage.setPage_number(pageNumber);
        return sortedPage;
    }

}
