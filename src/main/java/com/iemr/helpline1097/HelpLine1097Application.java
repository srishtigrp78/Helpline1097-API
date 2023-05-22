package com.iemr.helpline1097;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.iemr.helpline1097.utils.IEMRApplBeans;

/**
 * @author VI314759
 *
 */
@SpringBootApplication
@ComponentScan
@EnableCaching(proxyTargetClass = true)
public class HelpLine1097Application extends SpringBootServletInitializer
{
	@Bean
	public IEMRApplBeans instantiateBeans()
	{
		return new IEMRApplBeans();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(helpLine1097Application, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(new Class[] { HelpLine1097Application.class });
	}

	private static Class<HelpLine1097Application> helpLine1097Application = HelpLine1097Application.class;
}
