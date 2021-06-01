package com.iemr.helpline1097.service.everwell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.helpline1097.data.everwell.EverwellGuidelines;
import com.iemr.helpline1097.repository.everwell.EverwellGuidelinesRepo;
import com.iemr.helpline1097.utils.exception.IEMRException;
import com.iemr.helpline1097.utils.mapper.InputMapper;

@Service
public class EverwellSeviceImpl implements EverwellService {
	@Autowired
	private EverwellGuidelinesRepo everwellGuidelinesRepo;
	private InputMapper inputMapper = new InputMapper();
	public String saveGuidelines(String request) throws IEMRException
	{
		try
		{
		EverwellGuidelines everwell =
				inputMapper.gson().fromJson(request, EverwellGuidelines.class);
		everwell=everwellGuidelinesRepo.save(everwell);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("data",everwell);
		return new Gson().toJson(map);
		}
		catch(Exception e)
		{
			throw new IEMRException(e.getMessage());
		}
	}
	public String fetchGuidelines(String request) throws IEMRException
	{
		try
		{
		EverwellGuidelines everwell =
				inputMapper.gson().fromJson(request, EverwellGuidelines.class);
		List<EverwellGuidelines> ev=new ArrayList<EverwellGuidelines>();
		if(everwell.getAdherencePercentage()==null)
			ev=everwellGuidelinesRepo.findByProviderServiceMapID(everwell.getProviderServiceMapID());
		else if(everwell.getAdherencePercentage()>95)
			ev=everwellGuidelinesRepo.findGuidelinesByCategory("greater than 95 adherence percentage", everwell.getProviderServiceMapID());
		else if(everwell.getAdherencePercentage()<=95)
			ev=everwellGuidelinesRepo.findGuidelinesByCategory("less than or equal to 95 adherence percentage", everwell.getProviderServiceMapID());
		else
			ev=null;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("data",ev);
		return new Gson().toJson(map);
		}
		catch(Exception e)
		{
			throw new IEMRException(e.getMessage());
		}
	}
}
