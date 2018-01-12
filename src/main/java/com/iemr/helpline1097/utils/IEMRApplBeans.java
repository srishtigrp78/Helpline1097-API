package com.iemr.helpline1097.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import com.iemr.helpline1097.utils.config.ConfigProperties;
import com.iemr.helpline1097.utils.gateway.email.EmailService;
import com.iemr.helpline1097.utils.gateway.email.GenericEmailServiceImpl;
import com.iemr.helpline1097.utils.km.KMService;
import com.iemr.helpline1097.utils.km.openkm.OpenKMServiceImpl;
import com.iemr.helpline1097.utils.redis.RedisStorage;
import com.iemr.helpline1097.utils.sessionobject.SessionObject;
import com.iemr.helpline1097.utils.validator.Validator;

@Configuration
public class IEMRApplBeans
{
	@Bean
	public KMService getOpenKMService()
	{
		KMService kmService = new OpenKMServiceImpl();
		return kmService;
	}

	@Bean
	public Validator getVaidator()
	{
		Validator validator = new Validator();
		return validator;
	}

	@Bean
	public EmailService getEmailService()
	{
		EmailService emailService = new GenericEmailServiceImpl();
		return emailService;
	}

	@Bean
	public JavaMailSender getJavaMailSender()
	{
		JavaMailSender mailSender = new JavaMailSenderImpl();
		return mailSender;
	}

	@Bean
	public ConfigProperties configProperties()
	{
		return new ConfigProperties();
	}

	@Bean
	public SessionObject sessionObject()
	{
		return new SessionObject();
	}

	@Bean
	public RedisStorage redisStorage()
	{
		return new RedisStorage();
	}

	@Bean
	public LettuceConnectionFactory connectionFactory()
	{
		return new LettuceConnectionFactory();
	}

	@Bean
	public RedisHttpSessionConfiguration redisSession()
	{
		return new RedisHttpSessionConfiguration();
	}
}
