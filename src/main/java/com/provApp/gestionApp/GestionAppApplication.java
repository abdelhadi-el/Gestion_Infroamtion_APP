package com.provApp.gestionApp;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.provApp.gestionApp.views.HomePage;

@SpringBootApplication @Component 
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/// @Data
public class GestionAppApplication /* implements CommandLineRunner */{

	static ConfigurableApplicationContext context ;
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		context = (ConfigurableApplicationContext) new SpringApplicationBuilder(GestionAppApplication.class).headless(false).web(WebApplicationType.NONE).run(args);;
		HomePage window = context.getBean(HomePage.class); 
		window.setAppContext(context);
		window.getPageModel().getFrame().setVisible(true);
	}
	
	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}
