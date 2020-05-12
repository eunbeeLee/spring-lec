package com.practice.spring.consumingrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
@Slf4j
public class ConsumingRestApplication {

    public static void main(String[]args){
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    //해당 타입의 빈객체가 생성된다.
    //CommandLineRunner : 구동 시점에 실행 되는 코드가 자바 문자열 아규먼트 배열에 접근해야할 필요가 있는 경우에 사용
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
