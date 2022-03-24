package com.bel.faultmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// SpringBoot by default expects an embeded 
//datasource to be configured. without configuring datasource application will not start.
//To disable automatic datasource configuration use (exclude = DataSourceAutoConfiguration.class)
//attribute for @SpringBootApplication
@ComponentScan(basePackages = "com.bel.*") //add component scan to fix 404 Not Found Error

//To enabble JPA repository
@EntityScan(basePackages = "com.bel.*")
@EnableJpaRepositories(basePackages = "com.bel.*")
public class FaultManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaultManagementApplication.class, args);
		
		System.out.println("FaultManagementApplication.main()");
	}

}
