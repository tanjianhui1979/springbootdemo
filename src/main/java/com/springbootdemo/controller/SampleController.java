package com.springbootdemo.controller;


import com.springbootdemo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@ImportResource(locations = {"classpath*:spring/*.xml"})
@Controller
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        sampleService.doIt();
        return "Hello World!";
    }
}