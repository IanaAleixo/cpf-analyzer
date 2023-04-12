package com.cpfanalyzer.cpfanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cpfanalyzer.controllers"})
@EntityScan(basePackages = {"com.cpfanalyzer.models"})
@EnableJpaRepositories("com.cpfanalyzer.repository")
public class CpfAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpfAnalyzerApplication.class, args);
	}

}
