package com.omada.pithia.config;

import com.omada.pithia.service.*;
import com.omada.pithia.ui.view.Pithia;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ServicesConfiguration {

    @Bean
    public XrhstesService xrhstesService(){
        return new XrhstesServiceInMemory();
    }

    @Bean
    public ThewriesService thewriesService(){
        return new ThewriesServiceInMemory();
    }

    @Bean
    public ErgasthriaService ergasthriaService(){
        return new ErgasthriaServiceInMemory();
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("labels","errors");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

}
