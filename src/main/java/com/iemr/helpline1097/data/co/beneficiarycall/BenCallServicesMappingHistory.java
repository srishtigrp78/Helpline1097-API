package com.iemr.helpline1097.data.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Neeraj Kumar (298657). Date: 02-06-2017. Purpose: 1097 service taken by Beneficiary pojo....
 * 
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_bencall1097servicesmapping")
@Data
public class BenCallServicesMappingHistory
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BenCall97ServiceMapID")
	@Expose
	private Long benCall97ServiceMapID;

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BenCallID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private BeneficiaryCall beneficiaryCall;

	@Column(name = "SubServiceID")
	@Expose
	private Integer subServiceID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubServiceID", insertable = false, updatable = false, referencedColumnName = "SubServiceID")
	@JsonIgnore
	@Expose
	private SubServices subServices;

	@Column(name = "CategoryID")
	@Expose
	private Integer categoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CategoryID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private CategoryDetails categoryDetails;

	@Column(name = "SubCategoryID")
	@Expose
	private Integer subCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubCategoryID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private SubCategoryDetails subCategoryDetails;

	@Column(name = "COCategoryID")
	@Expose
	private Integer coCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COCategoryID", insertable = false, updatable = false, referencedColumnName = "categoryID")
	@JsonIgnore
	@Expose
	private CategoryDetails coCategoryDetails;

	@Column(name = "COSubCategoryID")
	@Expose
	private Integer coSubCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COSubCategoryID", insertable = false, updatable = false, referencedColumnName = "subCategoryID")
	@JsonIgnore
	@Expose
	private SubCategoryDetails coSubCategoryDetails;

	// COCategoryID int 10 √ null
	// m_category
	// COSubCategoryID int 10 √ null
	// m_subcategory
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FeedbackID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private FeedbackDetails feedbackDetails;

	@Column(name = "InstituteDirMapID")
	@Expose
	private Long instituteDirMapID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstituteDirMapID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private DirectoryMapping instituteDirectoryMapping;

	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	@Expose
	private List<DirectoryMapping> referrals = new ArrayList<DirectoryMapping>();
	@Transient
	@Expose
	private List<FeedbackDetails> feedbacks = new ArrayList<FeedbackDetails>();
	@Transient
	@Expose
	private List<SubCategoryDetails> counsellings = new ArrayList<SubCategoryDetails>();
	@Transient
	@Expose
	private List<SubCategoryDetails> informations = new ArrayList<SubCategoryDetails>();

	public BenCallServicesMappingHistory()
	{

	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID,
			Integer categoryID, Integer subCategoryID, Boolean deleted, String createdBy)
	{
		// this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = categoryID;
		this.subCategoryID = subCategoryID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID, Boolean deleted,
			Integer coCategoryID, Integer coSubCategoryID, String createdBy)
	{
		// this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = coCategoryID;
		this.subCategoryID = coSubCategoryID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(Long beneficiaryRegID, Long benCallID, Integer subServiceID, Long feedbackID,
			Boolean deleted, String createdBy)
	{
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.feedbackID = feedbackID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID,
			Long instituteDirMapID, String createdBy, Boolean deleted)
	{
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.instituteDirMapID = instituteDirMapID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Integer categoryID, CategoryDetails categoryDetails,
			Integer subCategoryID, SubCategoryDetails subCategoryDetails, Long feedbackID,
			FeedbackDetails feedbackDetails, Long instituteDirMapID, DirectoryMapping instituteDirectoryMapping,
			String createdBy, Timestamp createdDate, Integer coCategoryID, CategoryDetails coCategoryDetails,
			Integer coSubCategoryID, SubCategoryDetails coSubCategoryDetails)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.feedbackID = feedbackID;
		this.feedbackDetails = feedbackDetails;
		this.instituteDirMapID = instituteDirMapID;
		this.instituteDirectoryMapping = instituteDirectoryMapping;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.coCategoryID = coCategoryID;
		this.coCategoryDetails = coCategoryDetails;
		this.coSubCategoryDetails = coSubCategoryDetails;
		this.coCategoryID = coSubCategoryID;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, Integer categoryID, Integer subCategoryID, Long feedbackID, Long instituteDirMapID,
			String createdBy, Timestamp createdDate)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = categoryID;
		this.subCategoryID = subCategoryID;
		this.feedbackID = feedbackID;
		this.instituteDirMapID = instituteDirMapID;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Integer categoryID, CategoryDetails categoryDetails,
			Integer subCategoryID, SubCategoryDetails subCategoryDetails, String createdBy, Timestamp createdDate)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, CategoryDetails categoryDetails, Integer categoryID,
			SubCategoryDetails subCategoryDetails, Integer subCategoryID, String createdBy, Timestamp createdDate)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Long feedbackID, FeedbackDetails feedbackDetails,
			String createdBy, Timestamp createdDate)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.feedbackID = feedbackID;
		this.feedbackDetails = feedbackDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Long instituteDirMapID,
			DirectoryMapping instituteDirectoryMapping, String createdBy, Timestamp createdDate)
	{
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.instituteDirMapID = instituteDirMapID;
		this.instituteDirectoryMapping = instituteDirectoryMapping;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Long getBenCall97ServiceMapID()
	{
		return benCall97ServiceMapID;
	}

	public Long getBeneficiaryRegID()
	{
		return beneficiaryRegID;
	}

	public Long getBenCallID()
	{
		return benCallID;
	}

	public BeneficiaryCall getBeneficiaryCall()
	{
		return beneficiaryCall;
	}

	public Integer getSubServiceID()
	{
		return subServiceID;
	}

	public Integer getCategoryID()
	{
		return categoryID;
	}

	public Integer getSubCategoryID()
	{
		return subCategoryID;
	}

	public Long getFeedbackID()
	{
		return feedbackID;
	}

	public Long getInstituteDirMapID()
	{
		return instituteDirMapID;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setInstituteDirMapID(Long instituteDirMapID)
	{
		this.instituteDirMapID = instituteDirMapID;
	}

	/**
	 * @return the subServices
	 */
	public SubServices getServicesMaster1097()
	{
		return subServices;
	}

	/**
	 * @return the categoryDetails
	 */
	public CategoryDetails getCategoryDetails()
	{
		return categoryDetails;
	}

	/**
	 * @return the subCategoryDetails
	 */
	public SubCategoryDetails getSubCategoryDetails()
	{
		return subCategoryDetails;
	}

	/**
	 * @return the coCategoryID
	 */
	public Integer getCoCategoryID()
	{
		return coCategoryID;
	}

	/**
	 * @return the coCategoryDetails
	 */
	public CategoryDetails getCoCategoryDetails()
	{
		return coCategoryDetails;
	}

	/**
	 * @return the coSubCategoryID
	 */
	public Integer getCoSubCategoryID()
	{
		return coSubCategoryID;
	}

	/**
	 * @return the coSubCategoryDetails
	 */
	public SubCategoryDetails getCoSubCategoryDetails()
	{
		return coSubCategoryDetails;
	}

	/**
	 * @return the feedbackDetails
	 */
	public FeedbackDetails getFeedbackDetails()
	{
		return feedbackDetails;
	}

	/**
	 * @return the instituteDirectoryMapping
	 */
	public DirectoryMapping getInstituteDirectoryMapping()
	{
		return instituteDirectoryMapping;
	}

	public void setInstituteDirectoryMapping(DirectoryMapping instituteDirectoryMapping)
	{
		this.instituteDirectoryMapping = instituteDirectoryMapping;
	}

	/**
	 * @return the outputMapper
	 */
	public OutputMapper getOutputMapper()
	{
		return outputMapper;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
