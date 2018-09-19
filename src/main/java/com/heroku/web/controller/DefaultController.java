/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    @ResponseBody
    public String about() {
        return "<h1> About us </h1>";
    }
  
}
