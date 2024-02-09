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
package com.iemr.helpline1097.service.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;
import com.iemr.helpline1097.data.co.beneficiarycall.CallType;
import com.iemr.helpline1097.repository.co.beneficiarycall.BeneficiaryCallRepository;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

@Service
public class BeneficiaryCallServiceImpl implements BeneficiaryCallService
{
	private BeneficiaryCallRepository beneficiaryCallRepository;

	@Autowired
	private void setBeneficiaryCallRepository(BeneficiaryCallRepository beneficiaryCallRepository)
	{
		this.beneficiaryCallRepository = beneficiaryCallRepository;
	}

	@Override
	public List<BeneficiaryCall> addCalltype(Long benificiaryCallId)
	{
		List<BeneficiaryCall> benCalls = new ArrayList<BeneficiaryCall>();
		ArrayList<Objects[]> queryResult =
				beneficiaryCallRepository.findCallsByBenefeciaryID(benificiaryCallId, PageRequest.of(0, 1000));
		for (Object[] objects : queryResult)
		{
			if (queryResult != null && queryResult.size() >= 8)
			{
				String benCallServicesMappingHistories = OutputMapper.gson().toJson(objects[1]);
				BeneficiaryCall beneficiaryCall = new BeneficiaryCall((Long) objects[0],
						benCallServicesMappingHistories, (Integer) objects[2], (Boolean) objects[3],
						(Timestamp) objects[4], (String) objects[5], (String) objects[6], (Integer) objects[7]);
				benCalls.add(beneficiaryCall);
			}
		}
		return benCalls;
	}

	@Override
	public BeneficiaryCall createCall(Long beneficiaryRegID, boolean is1097)
	{
		BeneficiaryCall benCalls = new BeneficiaryCall(beneficiaryRegID, is1097, "system");
		BeneficiaryCall savedCalls = beneficiaryCallRepository.save(benCalls);
		return savedCalls;
	}

	@Override
	public Integer closeCall(String request)
	{
		Integer updateCounts = 0;
		BeneficiaryCall benificiaryCallId = new Gson().fromJson(request, BeneficiaryCall.class);
		updateCounts = beneficiaryCallRepository.closeCall(benificiaryCallId.getBenCallID(),
				benificiaryCallId.getRemarks(), new Timestamp(Calendar.getInstance().getTimeInMillis()),
				benificiaryCallId.getCallClosureType(), benificiaryCallId.getDispositionStatusID());
		return updateCounts;
	}

	@Override
	public List<BeneficiaryCall> getBeneficiaryCallsHistory(Long benificiaryCallId, Integer pageNo, Integer rows)
	{
		List<BeneficiaryCall> benCalls = new ArrayList<BeneficiaryCall>();
		ArrayList<Objects[]> queryResult = beneficiaryCallRepository.findCallsHistoryByBenefeciaryID(benificiaryCallId,
				PageRequest.of(pageNo, rows));
		for (Object[] objects : queryResult)
		{
			if (objects != null && objects.length >= 9)
			{
				BeneficiaryCall beneficiaryCall = new BeneficiaryCall((Long) objects[0], (Timestamp) objects[1],
						(String) objects[2], (Long) objects[3], (Long) objects[4], (Long) objects[5],
						(Timestamp) objects[6], (Long) objects[7], (CallType) objects[8]);
				benCalls.add(beneficiaryCall);
			}
		}
		return benCalls;
	}

	@Override
	public List<BeneficiaryCall> getBeneficiaryCallsHistory(Long benificiaryCallId, Integer calledServiceID,
			Integer pageNo, Integer rows)
	{
		List<BeneficiaryCall> benCalls = new ArrayList<BeneficiaryCall>();
		ArrayList<Objects[]> queryResult = beneficiaryCallRepository.findCallsHistoryByBenefeciaryID(benificiaryCallId,
				calledServiceID, PageRequest.of(pageNo, rows));
		for (Object[] objects : queryResult)
		{
			if (objects != null && objects.length >= 9)
			{
				BeneficiaryCall beneficiaryCall = new BeneficiaryCall((Long) objects[0], (Timestamp) objects[1],
						(String) objects[2], (Long) objects[3], (Long) objects[4], (Long) objects[5],
						(Timestamp) objects[6], (Long) objects[7], (CallType) objects[8]);
				benCalls.add(beneficiaryCall);
			}
		}
		return benCalls;
	}

	@Override
	public List<BeneficiaryCall> getCallSummaryByCallID(Long benCallID)
	{
		List<BeneficiaryCall> benCalls = new ArrayList<BeneficiaryCall>();
		ArrayList<Objects[]> queryResult = beneficiaryCallRepository.findCallSummaryByCallID(benCallID);
		for (Object[] objects : queryResult)
		{
			if (objects != null && objects.length >= 8)
			{
				BeneficiaryCall beneficiaryCall = new BeneficiaryCall((Long) objects[0], (Timestamp) objects[1],
						(String) objects[2], (Long) objects[3], (Long) objects[4], (Long) objects[5],
						(Timestamp) objects[6], (Long) objects[7], (CallType) objects[8]);
				benCalls.add(beneficiaryCall);
			}
		}
		return benCalls;
	}

	@Override
	public Integer updateBeneficiaryIDInCall(String request)
	{
		Integer updateCounts = 0;
		BeneficiaryCall benificiaryCallId = new Gson().fromJson(request, BeneficiaryCall.class);
		updateCounts = beneficiaryCallRepository.updateBeneficiaryIDInCall(benificiaryCallId.getBenCallID(),
				benificiaryCallId.getBeneficiaryRegID());
		return updateCounts;
	}
}
