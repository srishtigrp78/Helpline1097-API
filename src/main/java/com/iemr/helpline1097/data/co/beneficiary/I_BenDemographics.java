package com.iemr.helpline1097.data.co.beneficiary;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "i_Bendemographics")
public class I_BenDemographics {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Expose
	private Long BenDemographicsID;
	@Expose
	private Long BeneficiaryRegID;
	@Expose
	private Integer EducationID;
	@Expose
	private Integer OccupationID;
	@Expose
	private Integer IncomeStatusID;
	@Expose
	private Integer CommunityID;
	@Expose
	private Integer PreferredLangID;
	@Expose
	private Integer ReligionID;
	@Expose
	private Blob isPhoto;
	@Expose
	private String PhotoFilePath;
	@Expose
	private Long IsBiometric;
	@Expose
	private String BiometricFilePath;
	@Expose
	private String AddressLine1;
	@Expose
	private String AddressLine2;
	@Expose
	private String AddressLine3;
	@Expose
	private String AddressLine4;
	@Expose
	private String AddressLine5;
	@Expose
	private Integer CityID;
	@Expose
	private Integer StateID;
	@Expose
	private Integer CountryID;
	@Expose
	private String PinCode;
	@Expose
	private Integer IsAddPresent;
	@Expose
	private Integer IsAddPermanent;
	@Expose
	private Long Deleted;
	@Expose
	private String CreatedBy;
	private String ModifiedBy;
	
	public I_BenDemographics() {
		super();
	}
	
	public I_BenDemographics(long benDemographicsID, Long beneficiaryRegID, Integer educationID, Integer occupationID,
			Integer incomeStatusID, Integer communityID, Integer preferredLangID, Integer religionID, Blob isPhoto,
			String photoFilePath, Long isBiometric, String biometricFilePath, String addressLine1, String addressLine2,
			String addressLine3, String addressLine4, String addressLine5, Integer cityID, Integer stateID,
			Integer countryID, String pinCode, Integer isAddPresent, Integer isAddPermanent, Long deleted,
			String createdBy, String modifiedBy) {
		super();
		BenDemographicsID = benDemographicsID;
		BeneficiaryRegID = beneficiaryRegID;
		EducationID = educationID;
		OccupationID = occupationID;
		IncomeStatusID = incomeStatusID;
		CommunityID = communityID;
		PreferredLangID = preferredLangID;
		ReligionID = religionID;
		this.isPhoto = isPhoto;
		PhotoFilePath = photoFilePath;
		IsBiometric = isBiometric;
		BiometricFilePath = biometricFilePath;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		AddressLine3 = addressLine3;
		AddressLine4 = addressLine4;
		AddressLine5 = addressLine5;
		CityID = cityID;
		StateID = stateID;
		CountryID = countryID;
		PinCode = pinCode;
		IsAddPresent = isAddPresent;
		IsAddPermanent = isAddPermanent;
		Deleted = deleted;
		CreatedBy = createdBy;
		ModifiedBy = modifiedBy;
	}

	public Long getBenDemographicsID() {
		return BenDemographicsID;
	}

	public void setBenDemographicsID(long benDemographicsID) {
		BenDemographicsID = benDemographicsID;
	}

	public Long getBeneficiaryRegID() {
		return BeneficiaryRegID;
	}

	public void setBeneficiaryRegID(long beneficiaryRegID) {
		BeneficiaryRegID = beneficiaryRegID;
	}

	public Integer getEducationID() {
		return EducationID;
	}

	public void setEducationID(int educationID) {
		EducationID = educationID;
	}

	public Integer getOccupationID() {
		return OccupationID;
	}

	public void setOccupationID(int occupationID) {
		OccupationID = occupationID;
	}

	public Integer getIncomeStatusID() {
		return IncomeStatusID;
	}

	public void setIncomeStatusID(Integer incomeStatusID) {
		IncomeStatusID = incomeStatusID;
	}

	public Integer getCommunityID() {
		return CommunityID;
	}

	public void setCommunityID(Integer communityID) {
		CommunityID = communityID;
	}

	public Integer getPreferredLangID() {
		return PreferredLangID;
	}

	public void setPreferredLangID(Integer preferredLangID) {
		PreferredLangID = preferredLangID;
	}

	public Integer getReligionID() {
		return ReligionID;
	}

	public void setReligionID(Integer religionID) {
		ReligionID = religionID;
	}

	public Blob getIsPhoto() {
		return isPhoto;
	}

	public void setIsPhoto(Blob isPhoto) {
		this.isPhoto = isPhoto;
	}

	public String getPhotoFilePath() {
		return PhotoFilePath;
	}

	public void setPhotoFilePath(String photoFilePath) {
		PhotoFilePath = photoFilePath;
	}

	public Long getIsBiometric() {
		return IsBiometric;
	}

	public void setIsBiometric(long isBiometric) {
		IsBiometric = isBiometric;
	}

	public String getBiometricFilePath() {
		return BiometricFilePath;
	}

	public void setBiometricFilePath(String biometricFilePath) {
		BiometricFilePath = biometricFilePath;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		AddressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return AddressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		AddressLine4 = addressLine4;
	}

	public String getAddressLine5() {
		return AddressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		AddressLine5 = addressLine5;
	}

	public Integer getCityID() {
		return CityID;
	}

	public void setCityID(Integer cityID) {
		CityID = cityID;
	}

	public Integer getStateID() {
		return StateID;
	}

	public void setStateID(Integer stateID) {
		StateID = stateID;
	}

	public Integer getCountryID() {
		return CountryID;
	}

	public void setCountryID(Integer countryID) {
		CountryID = countryID;
	}

	public String getPinCode() {
		return PinCode;
	}

	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}

	public Integer getIsAddPresent() {
		return IsAddPresent;
	}

	public void setIsAddPresent(Integer isAddPresent) {
		IsAddPresent = isAddPresent;
	}

	public Integer getIsAddPermanent() {
		return IsAddPermanent;
	}

	public void setIsAddPermanent(Integer isAddPermanent) {
		IsAddPermanent = isAddPermanent;
	}

	public Long getDeleted() {
		return Deleted;
	}

	public void setDeleted(long deleted) {
		Deleted = deleted;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	
	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls();
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
