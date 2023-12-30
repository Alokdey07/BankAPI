package com.easybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@Component Scans({ @Component Scan("com.eazybytes.accounts.controller) })
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Account microservice rest api Documentation",
		description = "EasyBank Accounts microservice Rest Api Documentation",
		version = "v1",
		contact = @Contact(name = "Alok Dey",
		email = "alokdeykv@gmail.com",url = "https://chat.openai.com/"),
		license = @License(name = "Alok Dey", url = "https://chat.openai.com/")
),externalDocs = @ExternalDocumentation(
		description = "EasyBank Account microservice documentation",
		url = "https://chat.openai.com/"
))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
