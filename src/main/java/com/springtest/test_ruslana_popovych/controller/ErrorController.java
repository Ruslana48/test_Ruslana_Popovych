package com.springtest.test_ruslana_popovych.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ErrorController {
    @Controller
    public class CustomErrorController extends ErrorController {


        @RequestMapping("/error")
        @ResponseBody
        String error(HttpServletRequest request) {
            return "<h1>Error occurred</h1>";
        }


        public String getErrorPath() {
            return "/error";
        }
    }
}
