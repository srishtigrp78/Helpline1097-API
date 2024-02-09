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
package com.iemr.helpline1097.service.co.beneficiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.InstitutionDetails;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.beneficiary.BenCalServiceCatSubcatMappingRepo;
import com.iemr.helpline1097.repository.co.services.DirectoryMappingRepository;
import com.iemr.helpline1097.repository.co.services.SubCategoryRepository;
import com.iemr.helpline1097.utils.config.ConfigProperties;
import com.iemr.helpline1097.utils.mapper.InputMapper;

@Service
public class BenInformationCounsellingFeedbackReferralImpl implements BenInformationCounsellingFeedbackReferral {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo;

	@Autowired
	public void getBenCalServiceCatSubcatMappingRepo(
			BenCalServiceCatSubcatMappingRepo benCalServiceCatSubcatMappingRepo) {
		this.benCalServiceCatSubcatMappingRepo = benCalServiceCatSubcatMappingRepo;
	}

	private SubCategoryRepository subCategoryRepository;

	@Autowired
	public void getSubCategoryRepository(SubCategoryRepository subCategoryRepository) {
		this.subCategoryRepository = subCategoryRepository;
	}

	private DirectoryMappingRepository directoryMappingRepository;

	@Autowired
	public void getDirectoryMappingRepository(DirectoryMappingRepository directoryMappingRepository) {
		this.directoryMappingRepository = directoryMappingRepository;
	}

	private ConfigProperties configProperties;

	@Autowired
	public void setConfigProperties(ConfigProperties configProperties) {
		this.configProperties = configProperties;
	}

	private InputMapper inputMapper;

	@Override
	@Transactional
	public String saveBenCallServiceCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory) {
		List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
		for (BenCallServicesMappingHistory obj : benCallServicesMappingHistory) {
			SubCategoryDetails subCatFile = getFilePath(obj.getSubCategoryID());
			if (subCatFile != null) {
				benCalServiceCatSubcatMappingRepo.save(obj);
				resultSet.add(subCatFile);
			}
		}
		return resultSet.toString();
	}

	private SubCategoryDetails getFilePath(Integer subCategoryID) {
		Set<Objects[]> resultSet = subCategoryRepository.findFilePathBySubCategoryId(subCategoryID);
		SubCategoryDetails details = null;
		for (Object[] objects : resultSet) {
			if (objects != null && objects.length >= 3) {
				String fileUID = (String) objects[0];
				String subCatName = (String) objects[1];
				String subCatDesc = (String) objects[2];
				String fileUIDAsURI = null;
				if (fileUID != null && fileUID.trim().length() > 0) {
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

	@Override
	@Transactional
	public String saveBenCallServiceCOCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory) {
		List<SubCategoryDetails> resultSet = new ArrayList<SubCategoryDetails>();
		for (BenCallServicesMappingHistory obj : benCallServicesMappingHistory) {
			SubCategoryDetails subCatFile = getFilePath(obj.getCoSubCategoryID());
			if (subCatFile != null) {
				benCalServiceCatSubcatMappingRepo.save(obj);
				resultSet.add(subCatFile);
			}
		}
		return resultSet.toString();
	}

	@Override
	public String saveBenCalReferralMapping(String referralRequest) {
		List<DirectoryMapping> resultSet = new ArrayList<DirectoryMapping>();
		try {
			BenCallServicesMappingHistory[] reqArray = new Gson().fromJson(referralRequest,
					BenCallServicesMappingHistory[].class);
			InstitutionDetails[] institutes = inputMapper.gson().fromJson(referralRequest, InstitutionDetails[].class);
			DirectoryMapping[] directories = inputMapper.gson().fromJson(referralRequest, DirectoryMapping[].class);
			for (int idx = 0; idx < institutes.length; idx++) {
				Set<Objects[]> dirMaps = null;

				if (institutes[idx].getDistrictBranchMappingID() != null) {
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID(), institutes[idx].getBlockID(),
							institutes[idx].getDistrictBranchMappingID());
				} else if (institutes[idx].getBlockID() != null) {
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID(),
							institutes[idx].getBlockID());
				} else {
					dirMaps = directoryMappingRepository.findAciveInstituteDirectories(
							directories[idx].getInstituteDirectoryID(), directories[idx].getInstituteDirectoryID(),
							institutes[idx].getStateID(), institutes[idx].getDistrictID());
				}
				DirectoryMapping maps = new DirectoryMapping();
				BenCallServicesMappingHistory hist = null;
				for (Object[] objects : dirMaps) {
					hist = inputMapper.gson().fromJson(reqArray[idx].toString(), BenCallServicesMappingHistory.class);
					if (objects != null && objects.length >= 2) {
						maps = new DirectoryMapping((Long) objects[0], (InstitutionDetails) objects[1]);
						resultSet.add(maps);
						hist.setInstituteDirMapID((Long) objects[0]);
						benCalServiceCatSubcatMappingRepo.save(hist);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return resultSet.toString();
	}

}
