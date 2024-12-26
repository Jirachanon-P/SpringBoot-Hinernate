package com._stspringcrud.frist_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import utils.EntitesOrganizer;

@SpringBootApplication
@EntityScan( basePackages = "com._stspringcrud")
@ComponentScan(basePackages = "com._stspringcrud")
@EnableJpaRepositories(basePackages = "com._stspringcrud")
public class FristCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FristCrudApplication.class, args);

		EntitesOrganizer organizer = new EntitesOrganizer();
		organizer.execute();		
	}
}
