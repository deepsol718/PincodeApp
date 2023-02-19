package com.deepak.pincode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ComponentScan("com.deepak.pincode")

@SpringBootApplication
@RestController
public class PincodeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PincodeApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PincodeApplication.class);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World from Tomcat";
	}

}
