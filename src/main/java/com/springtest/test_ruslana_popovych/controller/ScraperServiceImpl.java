package com.springtest.test_ruslana_popovych.controller;

import com.springtest.test_ruslana_popovych.controller.ResponseDTO;
import com.springtest.test_ruslana_popovych.controller.ScraperService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ScraperServiceImpl implements ScraperService {
    //Reading data from property file to a list
    String url="https://cex.io/";

    @Override
    public Set<ResponseDTO> getCrypto(String vehicleModel) {
        Set<ResponseDTO> responseDTOS = new HashSet<>();
        if (url.contains("cex")) {
            //method to extract data from Ikman.lk
            extractDataFromCex(responseDTOS, url + vehicleModel);
        }
        return responseDTOS;
    }
    private void extractDataFromCex(Set<ResponseDTO> responseDTOS, String url) {

        try {            //loading the HTML to a Document Object
            Document document = Jsoup.connect(url).get();            //Selecting the element which contains the ad list
            Element element = document.getElementsByClass(".cex-ui-section-content").first();
            //getting all the <a> tag elements inside the content div tag
            Elements elements = element.getElementsByTag("tr");
            //traversing through the elements
            for (Element e: elements) {
                ResponseDTO responseDTO = new ResponseDTO();

                if (!StringUtils.isEmpty(e.attr("title")) ) {                    //mapping data to the model class
                    responseDTO.setCurrencyName(e.attr("td"));
                    responseDTO.setPrice(Double.parseDouble(e.attr("td")));
                }
                if (responseDTO.getPrice() != 0) responseDTOS.add(responseDTO);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
