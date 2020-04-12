package com.practice.spring;

import com.practice.spring.hello.Person;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ClientCacheApplication(name = "AccessGenFireDataRestApplication", logLevel = "debug")
@EnableEntityDefinedRegions(basePackageClasses = Person.class,
clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
