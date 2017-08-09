package com.eightlegged.smabackend;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName SmabackendApplication.java
 * @Project smabackend
 * @Date 2017. 8. 5.
 */

@SpringBootApplication
public class SmabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmabackendApplication.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
		HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
		factory.setEntityManagerFactory(emf);
		return factory;
	}
}
