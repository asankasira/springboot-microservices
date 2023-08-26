package org.asanka.javaguide;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition (
	info = @Info(
			title = "Spring Boot REST api project",
			description = "Spring Boot REST api demo project",
			version = "1.0.0",
			contact = @Contact(
					name = "Asanka Siriwardena",
					email = "asankas@gmail.com"
			),
			license = @License(
					name = "MIT",
					url = "mit license"
			)
	),
    externalDocs = @ExternalDocumentation(
			description = "Refer external documentation",
			url = "External Docs"
	)
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
