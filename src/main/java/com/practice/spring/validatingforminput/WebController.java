package com.practice.spring.validatingforminput;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

/**
 * WebMvcConfigurer :
 *
 */
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm){
        return "form";
    }

    /**
     * BindingResult 에는 모델의 바인딩 작업 중에 발생한 타입 변환 오류 정보와
     * 검증 작업에서 발생한 검증 오류 정보가 모두 저장된다.
     */
    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }

}
