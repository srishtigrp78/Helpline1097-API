package com.iemr.helpline1097.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper
{
	static GsonBuilder builder;

	public OutputMapper()
	{
		if (builder == null)
		{
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.serializeNulls().setLongSerializationPolicy(LongSerializationPolicy.STRING);
		}
	}

	public static Gson gson()
	{
		return builder.create();
	}
}