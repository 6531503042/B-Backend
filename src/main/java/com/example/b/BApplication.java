package com.example.b;

import com.example.b.config.StorageProperties;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;

import javax.print.attribute.standard.Media;

@Log4j2
@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class, Media.class})
public class BApplication {

    public static void main(String[] args) {
        SpringApplication.run(BApplication.class, args);
    }

    @Bean
    @Scope
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
