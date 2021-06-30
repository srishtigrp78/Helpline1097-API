package com.iemr.helpline1097.util.context;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.helpline1097.controller.co.services.CommonController;

public class ContextUtil
{
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	public Object getDTOBean(List<Objects[]> lists, String className)
	{

		Object bean;
		try
		{
			bean = Class.forName(className).newInstance();

			Field[] fields = bean.getClass().getDeclaredFields();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		return null;
	}

}
