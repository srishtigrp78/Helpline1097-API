package com.iemr.helpline1097.controller.co.callhandling;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.controller.co.services.CommonController;
import com.iemr.helpline1097.data.co.calltype.M_Calltype;
import com.iemr.helpline1097.service.co.callhandling.IEMRCalltypeServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RequestMapping(value = "/call")
@RestController
public class CalltypeController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	private IEMRCalltypeServiceImpl iEMRCalltypeServiceImpl;

	@CrossOrigin()
	@RequestMapping(value = "/addType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String addCallType(@RequestBody String request) {

		OutputResponse response = new OutputResponse();
		try {
			M_Calltype payload = inputMapper.gson().fromJson(request, M_Calltype.class);
			M_Calltype m_calltype = iEMRCalltypeServiceImpl.addCalltype(payload);

			if (m_calltype != null) {
				response.setResponse("callType Added");
			} else {
				response.setResponse("Failed to add callType");
			}
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getTypes/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String getAllCallTypes(@PathVariable("id") int id) {

		OutputResponse response = new OutputResponse();
		try {
			M_Calltype m_calltypes = iEMRCalltypeServiceImpl.getAllCalltypes(id);

			response.setResponse(m_calltypes.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

}
