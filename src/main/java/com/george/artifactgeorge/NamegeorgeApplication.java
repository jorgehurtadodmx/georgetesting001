package com.george.artifactgeorge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NamegeorgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamegeorgeApplication.class, args);

		MyFirstClass myFirstClass = new MyFirstClass();
		System.out.println(myFirstClass.sayHello());
	}

}
