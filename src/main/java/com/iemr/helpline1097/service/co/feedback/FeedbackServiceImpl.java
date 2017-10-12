package com.iemr.helpline1097.service.co.feedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.data.co.feedback.FeedbackRequestDetails;
import com.iemr.helpline1097.repository.co.beneficiary.BenCalServiceCatSubcatMappingRepo;
import com.iemr.helpline1097.repository.co.feedback.FeedbackRepository;
import com.iemr.utils.config.ConfigProperties;
import com.iemr.utils.http.HttpUtils;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	/***
	 * Neeraj code start.....
	 * 
	 */
	private BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo;

	@Autowired
	public void getBenCalServiceCatSubcatMappingRepo(
			BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo) {
		this.benCalServiceCatSubcatMappingRepo = benCalServiceCatSubcatMappingRepo;
	}

	/***
	 * Neeraj code End.....
	 * 
	 */

	/**
	 * Feedback Repository
	 */
	private FeedbackRepository feedbackRepository;

	@Autowired
	public void setFeedbackRepository(FeedbackRepository feedbackRepository) {

		this.feedbackRepository = feedbackRepository;
	}

	private InputMapper inputMapper = new InputMapper();

	private ConfigProperties properties;

	@Autowired
	public void setProperties(ConfigProperties properties) {
		this.properties = properties;
	}

	@Override
	public List<FeedbackDetails> getFeedbackRequests(long id) {

		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		ArrayList<Objects[]> lists = feedbackRepository.findByBeneficiaryID(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 6) {
				feedbackList.add(new FeedbackDetails((Long) objects[0], (Short) objects[1], (Short) objects[2],
						(Short) objects[3], (String) objects[4], (String) objects[5]));
			}
		}
		return feedbackList;
	}

	@Override
	public List<FeedbackDetails> getFeedbackRequest(long id) {

		List<FeedbackDetails> feedbackList = new ArrayList<FeedbackDetails>();
		ArrayList<Objects[]> lists = feedbackRepository.findByFeedbackID(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 6) {
				feedbackList.add(new FeedbackDetails((Long) objects[0], (Short) objects[1], (Short) objects[2],
						(Short) objects[3], (String) objects[4], (String) objects[5]));
			}
		}
		return feedbackList;
	}

	@Override
	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails) {

		/*
		 * String feedbackDetailsJson = new
		 * Gson().toJson(payload.get("feedbackDetails")); String
		 * feedbackRequestDetailsJson = new
		 * Gson().toJson(payload.get("feedbackRequestDetails"));
		 * 
		 * FeedbackDetails feedbackDetails = (FeedbackDetails) new
		 * Gson().fromJson(feedbackDetailsJson, FeedbackDetails.class);
		 * FeedbackRequestDetails[] feedbackRequestArray =
		 * (FeedbackRequestDetails[]) new
		 * Gson().fromJson(feedbackRequestDetailsJson,
		 * FeedbackRequestDetails[].class);
		 */

		List<FeedbackRequestDetails> feedbackRequestList = feedbackDetails.getFeedbackRequestDetails();

		for (FeedbackRequestDetails frd : feedbackRequestList) {

			frd.setFeedback(feedbackDetails);
		}

		feedbackDetails.setFeedbackRequestDetails(feedbackRequestList);

		return feedbackRepository.save(feedbackDetails);
	}

	@Override
	public String updateFeedback(FeedbackDetails feedbackDetails) {
		return null;
	}

	/***
	 * Neeraj code start.....
	 * 
	 */

	/***
	 * Author: Neeraj kumar (298657), Date: 04-06-2017, Purpose: Save customer
	 * feedback in to T_Feeedback and return feedbackID and save into
	 * m_BenCall1097ServicesMapping table
	 **/
	// @Override
	// // public String saveFeedbackFromCustomer(Iterable<FeedbackDetails>
	// // feedbackDetails) {
	// public String saveFeedbackFromCustomer(String feedbackDetails) {
	//
	// Map<String, Long> resMap = new HashMap<String, Long>();
	// FeedbackDetails[] feedbackDetailsArray =
	// inputMapper.gson().fromJson(feedbackDetails, FeedbackDetails[].class);
	// Iterable<FeedbackDetails> feedbackSavedData = null;
	// GsonBuilder builder = new GsonBuilder();
	// builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	// // Type listType = new TypeToken<List<FeedbackDetails>>(){}.getType();
	// List<FeedbackDetails> feedbackDetailsList =
	// Arrays.asList(feedbackDetailsArray);
	// // List<FeedbackDetails> feedbackDetailsList=
	// // builder.create().fromJson(feedbackDetails, listType);
	// feedbackSavedData = feedbackRepository.save(feedbackDetailsList);
	// if (feedbackSavedData != null) {
	// List<BenCallServicesMappingHistory> obj = new ArrayList<>();
	// for (FeedbackDetails f : feedbackSavedData) {
	// BenCallServicesMappingHistory benCallServicesMappingHistory = new
	// BenCallServicesMappingHistory(
	// f.getBeneficiaryRegID(), f.getBenCallID(), f.getServiceID(),
	// f.getFeedbackID(), false,
	// f.getCreatedBy());
	// obj.add(benCallServicesMappingHistory);
	// }
	// Iterable<BenCallServicesMappingHistory> dataInserted =
	// benCalServiceCatSubcatMappingRepo.save(obj);
	// for (BenCallServicesMappingHistory m : dataInserted) {
	// resMap.put("feedBackId", m.getFeedbackID());
	// }
	// } else {
	// resMap.put("feedBackId", (long) 0);
	// }
	// System.out.println(resMap.toString());
	// return new Gson().toJson(resMap);
	// }
	/***
	 * Neeraj code End.....
	 * @throws Exception 
	 * 
	 */
	@Override
	public String saveFeedbackFromCustomer(String feedbackDetails) throws Exception {
		Map<String, Long> resMap = new HashMap<String, Long>();
		OutputResponse response = createFeedback(feedbackDetails);
		resMap.put("feedBackId", (long) 0);
		if (response.isSuccess()) {
			logger.info(response.getData());
			FeedbackDetails[] feedbackSavedData = inputMapper.gson().fromJson(response.getData(),
					FeedbackDetails[].class);
			// feedbackSavedData = inputMapper.gson().fromJson();
			if (feedbackSavedData != null) {
				List<BenCallServicesMappingHistory> obj = new ArrayList<>();
				for (FeedbackDetails f : feedbackSavedData) {
					BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory(
							f.getBeneficiaryRegID(), f.getBenCallID(), f.getSubServiceID(), f.getFeedbackID(), false,
							f.getCreatedBy());
					obj.add(benCallServicesMappingHistory);
				}
				Iterable<BenCallServicesMappingHistory> dataInserted = benCalServiceCatSubcatMappingRepo.save(obj);
				for (BenCallServicesMappingHistory m : dataInserted) {
					resMap.put("feedBackId", m.getFeedbackID());
				}
			}
		} else {
			throw new Exception(response.getErrorMessage());
		}
		return new Gson().toJson(resMap);
	}

	private OutputResponse createFeedback(String feedbackDetails) {
		HttpUtils utils = new HttpUtils();
		String responseStr = utils.post(
				properties.getPropertyByName("common-url") + "/" + properties.getPropertyByName("create-feedback"),
				feedbackDetails);
		OutputResponse response = inputMapper.gson().fromJson(responseStr, OutputResponse.class);
//		response.setResponse(responseStr);
		return response;
	}
}
