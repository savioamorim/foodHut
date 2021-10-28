package com.cotemig.foodHut.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LojaRestController {

    @RequestMapping(value = "/loja", method = RequestMethod.GET)
    public String teste() {
        return "Hello World!";
    }
}
