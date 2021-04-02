package com.example.demo;

import com.vaadin.flow.server.VaadinSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.setProperty;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		setProperty("vaadin.i18n.provider", II18NProviderImpl.class.getName());
		SpringApplication.run(DemoApplication.class, args);
	}

}
