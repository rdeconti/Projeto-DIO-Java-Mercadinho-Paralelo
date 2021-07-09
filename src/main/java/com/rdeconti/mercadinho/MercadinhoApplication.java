// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rdeconti.mercadinho")
public class MercadinhoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "mercadinho");
		SpringApplication.run(MercadinhoApplication.class, args);
	}

}