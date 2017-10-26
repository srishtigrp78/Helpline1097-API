package com.iemr.helpline1097.service.co.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.InstitutionDetails;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.beneficiary.BenCalServiceCatSubcatMappingRepo;
import com.iemr.helpline1097.repository.co.services.DirectoryMappingRepository;
import com.iemr.helpline1097.repository.co.services.SubCategoryRepository;
import com.iemr.utils.config.ConfigProperties;
import com.iemr.utils.mapper.InputMapper;

/**
 * Author: Neeraj Kumar (298657) Date: 02-06-2017
 * 
 */

@Service
public class BenInformationCounsellingFeedbackReferralImpl implements BenInformationCounsellingFeedbackReferral
{

	private BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo;

	@Autowired
	public void getBenCalServiceCatSubcatMappingRepo(
			BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo)
	{
		this.benCalServiceCatSubcatMappingRepo = benCalServiceCatSubcatMappingRepo;
	}

	private SubCategoryRepository subCategoryRepository;

	@Autowired
	public void getSubCategoryRepository(SubCategoryRepository subCategoryRepository)
	{
		this.subCategoryRepository = subCategoryRepository;
	}

	private DirectoryMappingRepository directoryMappingRepository;

	@Autowired
	public void getDirectoryMappingRepository(DirectoryMappingRepository directoryMappingRepository)
	{
		this.directoryMappingRepository = directoryMappingRepository;
	}

	private ConfigProperties configProperties;

	@Autowired
	public void setConfigProperties(ConfigProperties configProperties)
	{
		this.configProperties = configProperties;
	}

	private InputMapper inputMapper;

	// @Override
	// @Transactional
	// public String saveBenCallServiceCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory)
	// {
	// Iterable<BenCallServicesMappingHistory> dataInserted = benCalServiceCatSubcatMappingRepo
	// .save(benCallServicesMappingHistory);
	// List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
	// String subCatFilePath = "";
	// for (BenCallServicesMappingHistory obj : dataInserted)
	// {
	// // subCatFilePath = getFilePath(obj.getSubCategoryID());
	// // resultSet.add(new SubCategoryDetails(obj.getSubCategoryID(),
	// // obj.getSubCategoryDetails().getSubCategoryName(), subCatFilePath));
	// resultSet.add(getFilePath(obj.getSubCategoryID()));
	// }
	// // return new Gson().toJson(resultSet);
	// return resultSet.toString();
	// }

	@Override
	@Transactional
	public String saveBenCallServiceCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory)
	{
		List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
		for (BenCallServicesMappingHistory obj : benCallServicesMappingHistory)
		{
			SubCategoryDetails subCatFile = getFilePath(obj.getSubCategoryID());
			if (subCatFile != null)
			{
				benCalServiceCatSubcatMappingRepo.save(obj);
				resultSet.add(subCatFile);
			}
		}
		return resultSet.toString();
	}

	private SubCategoryDetails getFilePath(Integer subCategoryID)
	{
		Set<Objects[]> resultSet = subCategoryRepository.findFilePathBySubCategoryId(subCategoryID);
		SubCategoryDetails details = null;
		for (Object[] objects : resultSet)
		{
			if (objects != null && objects.length >= 3)
			{
				String fileUID = (String) objects[0];
				String subCatName = (String) objects[1];
				String subCatDesc = (String) objects[2];
				String fileUIDAsURI = null;
				if (fileUID != null && fileUID.trim().length() > 0)
				{
					String dmsPath = configProperties.getPropertyByName("km-base-path");
					String dmsProtocol = configProperties.getPropertyByName("km-base-protocol");
					String userName = configProperties.getPropertyByName("km-guest-user");
					String userPassword = configProperties.getPassword("km-guest-user");
					fileUIDAsURI = dmsProtocol + "://" + userName + ":" + userPassword + "@" + dmsPath
							+ "/Download?uuid=" + fileUID;
				}
				details = new SubCategoryDetails(subCatDesc, subCatName, fileUIDAsURI);
			}
		}
		return details;
	}

	// @Override
	// @Transactional
	// public String saveBenCallServiceCOCatSubCat(Iterable<BenCallServicesMappingHistory>
	// benCallServicesMappingHistory)
	// {
	// Iterable<BenCallServicesMappingHistory> dataInserted = benCalServiceCatSubcatMappingRepo
	// .save(benCallServicesMappingHistory);
	// List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
	// String subCatFilePath = "";
	// for (BenCallServicesMappingHistory obj : dataInserted)
	// {
	// // subCatFilePath = getFilePath(obj.getSubCategoryID());
	// // resultSet.add(new SubCategoryDetails(obj.getCoSubCategoryID(), "", subCatFilePath));
	// resultSet.add(getFilePath(obj.getCoSubCategoryID()));
	// }
	// // return new Gson().toJson(resultSet);
	// return resultSet.toString();
	// }

	@Override
	@Transactional
	public String saveBenCallServiceCOCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory)
	{
		List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
		for (BenCallServicesMappingHistory obj : benCallServicesMappingHistory)
		{
			SubCategoryDetails subCatFile = getFilePath(obj.getCoSubCategoryID());
			if (subCatFile != null)
			{
				benCalServiceCatSubcatMappingRepo.save(obj);
				resultSet.add(subCatFile);
			}
		}
		return resultSet.toString();
	}

	@Override
	public String saveBenCalReferralMapping(String referralRequest)
	{
		List<DirectoryMapping> resultSet = new ArrayList<DirectoryMapping>();
		try
		{
			BenCallServicesMappingHistory[] reqArray = new Gson().fromJson(referralRequest,
					BenCallServicesMappingHistory[].class);
			InstitutionDetails[] institutes = inputMapper.gson().fromJson(referralRequest, InstitutionDetails[].class);
			DirectoryMapping[] directories = inputMapper.gson().fromJson(referralRequest, DirectoryMapping[].class);
			for (int idx = 0; idx < institutes.length; idx++)
			{
				Set<Objects[]> dirMaps = null;

				if (institutes[idx].getDistrictBranchMappingID() != null)
				{
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteSubDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID(), institutes[idx].getBlockID(),
							institutes[idx].getDistrictBranchMappingID());
				} else if (institutes[idx].getBlockID() != null)
				{
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteSubDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID(),
							institutes[idx].getBlockID());
				} else
				{
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteSubDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID());
				}
				DirectoryMapping maps = new DirectoryMapping();
				for (Object[] objects : dirMaps)
				{
					if (objects != null && objects.length == 2)
					{
						maps = new DirectoryMapping((Long) objects[0], (InstitutionDetails) objects[1]);
						resultSet.add(maps);
						reqArray[idx].setInstituteDirMapID((Long) objects[0]);
						benCalServiceCatSubcatMappingRepo.save(reqArray[idx]);
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultSet.toString();
	}

	// @Override
	// public String saveBenCalFeedbackMapping(String feedbackRequest) {
	// List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
	// // Get institute branch mapping ID and institution name
	// try {
	// JSONObject request = new JSONObject(feedbackRequest);
	// BenCallServicesMappingHistory requestMapping = new
	// Gson().fromJson(feedbackRequest,
	// BenCallServicesMappingHistory.class);
	// List<BenCallServicesMappingHistory> requestMappingList = new
	// ArrayList<BenCallServicesMappingHistory>();
	// // update history for the request
	// requestMappingList.add(requestMapping);
	// Iterable<BenCallServicesMappingHistory> dataInserted =
	// benCalServiceCatSubcatMappingRepo
	// .save(requestMappingList);
	// String subCatFilePath = "";
	// for (BenCallServicesMappingHistory obj : dataInserted) {
	// subCatFilePath =
	// subCategoryRepository.findFilePathBySubCategoryId(obj.getSubCategoryID());
	// resultSet.add(new SubCategoryDetails(obj.getSubCategoryID(), "",
	// subCatFilePath));
	// }
	// } catch (JsonSyntaxException | JSONException e) {
	// e.printStackTrace();
	// }
	// return new Gson().toJson(resultSet);
	// }
}
