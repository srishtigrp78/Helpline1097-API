package com.iemr.helpline1097.service.everwell;


import com.iemr.helpline1097.utils.exception.IEMRException;

public interface EverwellService {
	public String saveGuidelines(String request) throws IEMRException;
	public String fetchGuidelines(String request) throws IEMRException;
	public String deleteGuideline(String request) throws IEMRException;
}
