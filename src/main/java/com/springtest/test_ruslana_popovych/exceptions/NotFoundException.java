package com.springtest.test_ruslana_popovych.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class NotFoundException extends RuntimeException{
    private String message;

    //print error message in console
    public NotFoundException(){
        System.out.println("Sorry, we cant find name");;
    }

    public NotFoundException(String message) {
        super();
        this.message = message;
    }

}
