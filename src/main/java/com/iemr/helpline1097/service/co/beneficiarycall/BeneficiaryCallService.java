package com.iemr.helpline1097.service.co.beneficiarycall;

import java.util.List;

import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;

public interface BeneficiaryCallService
{
	List<BeneficiaryCall> addCalltype(Long benificiaryCallId);

	List<BeneficiaryCall> getBeneficiaryCallsHistory(Long benificiaryCallId, Integer pageNo, Integer rows);

	List<BeneficiaryCall> getCallSummaryByCallID(Long benCallID);

	BeneficiaryCall createCall(Long beneficiaryRegID, boolean is1097);

	Integer closeCall(String beneficiaryCall);

	Integer updateBeneficiaryIDInCall(String beneficiaryCall);

	List<BeneficiaryCall> getBeneficiaryCallsHistory(Long benificiaryCallId, Integer calledServiceID, Integer pageNo,
			Integer rows);
}
