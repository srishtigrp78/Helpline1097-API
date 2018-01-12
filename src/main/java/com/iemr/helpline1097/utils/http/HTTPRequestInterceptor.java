package com.iemr.helpline1097.utils.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iemr.helpline1097.utils.response.OutputResponse;
import com.iemr.helpline1097.utils.sessionobject.SessionObject;
import com.iemr.helpline1097.utils.validator.Validator;

@Component
public class HTTPRequestInterceptor extends HandlerInterceptorAdapter
{
	private Validator validator;

	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	public void setValidator(Validator validator)
	{
		this.validator = validator;
	}

	private SessionObject sessionObject;

	@Autowired
	public void setSessionObject(SessionObject sessionObject)
	{
		this.sessionObject = sessionObject;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception
	{
		boolean status = true;
		logger.debug("In preHandle we are Intercepting the Request");
		String authorization = request.getHeader("Authorization");
		logger.debug("RequestURI::" + request.getRequestURI() + " || Authorization ::" + authorization);
		// if (authorization != null)
		// {
		try
		{
			String[] requestURIParts = request.getRequestURI().split("/");
			String requestAPI = requestURIParts[requestURIParts.length - 1];
			switch (requestAPI)
			{
				case "userAuthenticate":
				case "userAuthenticateNew":
				case "userAuthenticateV1":
				case "forgetPassword":
				case "setForgetPassword":
				case "changePassword":
				case "saveUserSecurityQuesAns":
				case "swagger-ui.html":
				case "ui":
				case "swagger-resources":
				case "api-docs":
					break;
				default:
					validator.checkKeyExists(authorization, request.getRemoteAddr());
					break;
			}
		} catch (Exception e)
		{
			OutputResponse output = new OutputResponse();
			output.setError(e);
			response.getOutputStream().print(output.toString());
			status = false;
		}
		// }
		return status;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception
	{
		logger.debug("In postHandle we are Intercepting the Request");
		String authorization = request.getHeader("Authorization");
		logger.debug("RequestURI::" + request.getRequestURI() + " || Authorization ::" + authorization);
		sessionObject.updateSessionObject(authorization, sessionObject.getSessionObject(authorization));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception
	{
		logger.debug("In afterCompletion Request Completed");
	}
}