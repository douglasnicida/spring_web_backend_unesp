package br.com.cam.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan(basePackages = {"br.com.cam.api.model"}) 
@EnableJpaRepositories(basePackages = {"br.com.cam.api.repository"})
@ComponentScan(basePackages = { "br.com.*" })
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration


public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

public void addCorsMapping(CorsRegistry registry){
	registry.addMapping("/camera/**")
	.allowedMethods("*")
	.allowedOrigins("*");
}