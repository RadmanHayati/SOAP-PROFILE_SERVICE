package com.radmanhayati.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;


@EnableWs
@Configuration
public class WebServiceConfig {


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.radmanhayati.profile.soap.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri("http://localhost:8080/api/ws");

        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setReadTimeout(5000);
        messageSender.setConnectionTimeout(5000);

        webServiceTemplate.setMessageSender(messageSender);
        return webServiceTemplate;
    }
}