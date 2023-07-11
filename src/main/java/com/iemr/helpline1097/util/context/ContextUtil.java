/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
