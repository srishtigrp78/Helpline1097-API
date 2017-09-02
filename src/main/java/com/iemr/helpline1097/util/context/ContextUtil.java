package com.iemr.helpline1097.util.context;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class ContextUtil {

	public Object getDTOBean(List<Objects[]> lists, String className){
		
		Object bean;
		try {
				bean = Class.forName(className).newInstance();
			
				Field[] fields = bean.getClass().getDeclaredFields();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
