package com.test.telefonica.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("morenovictorzapata@gmail.com");
        contact.setName("Víctor Moreno Zapata");

        return new OpenAPI()
                .info(new Info().title("Test API Telefonica").version("Api V1").contact(contact));
    }
}