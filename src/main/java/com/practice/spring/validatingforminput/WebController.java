package com.practice.spring.validatingforminput;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

public class WebController {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }
}
