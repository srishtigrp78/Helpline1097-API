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
package com.iemr.helpline1097.service.everwell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iemr.helpline1097.data.everwell.EverwellGuidelines;
import com.iemr.helpline1097.repository.everwell.EverwellGuidelinesRepo;
import com.iemr.helpline1097.utils.exception.IEMRException;

@Service
public class EverwellSeviceImpl implements EverwellService {
	@Autowired
	private EverwellGuidelinesRepo everwellGuidelinesRepo;

	@Override
	public String saveGuidelines(String request) throws IEMRException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			EverwellGuidelines everwell = objectMapper.readValue(request, EverwellGuidelines.class);
			String alreadyExists = null;
			Map<String, String> map1 = new HashMap<String, String>();
			if (everwell.getId() == null) {
				List<EverwellGuidelines> check = everwellGuidelinesRepo.checkIfDocAlreadyexists(everwell.getCategory(),
						everwell.getProviderServiceMapID());
				if (check.size() > 0) {
					alreadyExists = "Document for this category already exists,please delete and add again";

					map1.put("data", alreadyExists);
				} else
					everwell = everwellGuidelinesRepo.save(everwell);
			} else
				everwell = everwellGuidelinesRepo.save(everwell);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", everwell);
			if (alreadyExists != null)
				return new Gson().toJson(map1);
			return new Gson().toJson(map);
		} catch (Exception e) {
			throw new IEMRException(e.getMessage());
		}
	}

	@Override
	public String fetchGuidelines(String request) throws IEMRException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			EverwellGuidelines everwell = objectMapper.readValue(request, EverwellGuidelines.class);
			List<EverwellGuidelines> ev = new ArrayList<EverwellGuidelines>();
			if (everwell.getAdherencePercentage() == null)
				ev = everwellGuidelinesRepo.findByProviderServiceMapID(everwell.getProviderServiceMapID());
			else if (everwell.getAdherencePercentage() > 95)
				ev = everwellGuidelinesRepo.findGuidelinesByCategory("> 95 adherence percentage",
						everwell.getProviderServiceMapID());
			else if (everwell.getAdherencePercentage() <= 95)
				ev = everwellGuidelinesRepo.findGuidelinesByCategory("<= 95 adherence percentage",
						everwell.getProviderServiceMapID());
			else
				ev = null;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", ev);
			return new Gson().toJson(map);
		} catch (Exception e) {
			throw new IEMRException(e.getMessage());
		}
	}

	@Override
	public String deleteGuideline(String request) throws IEMRException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			EverwellGuidelines everwell = objectMapper.readValue(request, EverwellGuidelines.class);
			int a = 0;
			String alreadyExists = null;
			Map<String, String> map1 = new HashMap<String, String>();
			if (everwell.getId() == null) {
				throw new IEMRException("Auto increment id cannot be null");
			} else {
				a = everwellGuidelinesRepo.deleteGuideline(everwell.getId(), everwell.getModifiedBy());
			}
			if (a > 0)
				return "Guideline deleted successfully";
			else
				return "Row with id does not exist";
		} catch (Exception e) {
			throw new IEMRException(e.getMessage());
		}
	}
}
