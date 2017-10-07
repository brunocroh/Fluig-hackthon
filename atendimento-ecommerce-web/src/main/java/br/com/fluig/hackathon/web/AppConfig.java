package br.com.fluig.hackathon.web;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.conector.fluig.framework.parametrizacao.WebServiceUserProperties;
import br.com.fluig.hackathon.BasicPackage;

@Configuration
@ComponentScan(basePackageClasses = { BasicPackage.class})
@EnableWebMvc
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml" })
public class AppConfig {


	public static String getRaizAplicacao() {
		return "/pcsist/produtos/conectores";
	}
	
	public static String getConfigFilePath() {
		return AppConfig.getRaizAplicacao() + "/config/app.properties";
	}

	@Bean
	public static PropertiesConfiguration propertiesConfiguration() {
		try {
			File conf = new File(AppConfig.getConfigFilePath());
			PropertiesConfiguration config = new PropertiesConfiguration(conf);
			WebServiceUserProperties.user = config.getString("service.user");
			WebServiceUserProperties.password = config.getString("service.password");
			WebServiceUserProperties.url = config.getString("service.url");
			WebServiceUserProperties.company = config.getInt("service.company");

			return config;
		
		} catch (Exception e) {
			return new PropertiesConfiguration();
		}
	}
	
	 @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurerAdapter() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**");
           }
       };
   }

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));

	}

	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}
}
