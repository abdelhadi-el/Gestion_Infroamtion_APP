package com.provApp.gestionApp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.provApp.gestionApp", "com.provApp.gestionApp.controlleurs", "com.provApp.gestionApp.models", "com.provApp.gestionApp.persistence", "com.provApp.gestionApp.views"})
@EnableJpaRepositories
public class conf {

}
