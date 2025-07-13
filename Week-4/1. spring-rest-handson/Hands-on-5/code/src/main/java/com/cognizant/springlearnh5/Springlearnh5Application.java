package com.cognizant.springlearnh5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Springlearnh5Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Springlearnh5Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Springlearnh5Application.class, args);
        displayCountry();
    }

    public static void displayCountry() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);

        LOGGER.debug("country : {}", country);
        LOGGER.debug("anotherCountry : {}", anotherCountry);

        LOGGER.info("END");
    }
}
