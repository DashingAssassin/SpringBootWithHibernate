package com.boothibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootWithHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernateApplication.class, args);
	}

}
