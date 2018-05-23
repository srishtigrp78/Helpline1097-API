package com.iemr.helpline1097.data.co.beneficiarycall;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_bencall")
@Data
public class BeneficiaryCall
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;
	@OneToMany(mappedBy = "beneficiaryCall", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;

	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Expose
	@Column(name = "CalledServiceID")
	private Integer calledServiceID;
	@Expose
	@Column(name = "is1097")
	private Boolean is1097;
	@Expose
	@Column(name = "CallTime")
	private Timestamp callTime;
	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Column(name = "ServicesProvided")
	private String servicesProvided;

	@Expose
	@Column(name = "CallClosureType")
	private String callClosureType;

	@Expose
	@Column(name = "DispositionStatusID")
	private Integer dispositionStatusID;

	@Expose
	@Column(name = "CallReceivedUserID")
	private Integer callReceivedUserID;

	@Expose
	@Column(name = "CallEndUserID")
	private Integer callEndUserID;
	@Column(name = "Category")
	private String category;
	@Column(name = "SubCategory")
	private String subCategory;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Column(name = "CallTypeID")
	@Expose
	private Integer callTypeID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CallTypeID", insertable = false, updatable = false)
	@Expose
	private CallType callTypeObj;

	@Expose
	@Transient
	private Long informationServices;

	@Expose
	@Transient
	private Long feedbackServices;

	@Expose
	@Transient
	private Long referralServices;

	@Expose
	@Transient
	private Long counsellingServices;

	public Long getBenCallID()
	{
		return benCallID;
	}

	public List<BenCallServicesMappingHistory> getBenCallServicesMappingHistories()
	{
		return benCallServicesMappingHistories;
	}

	public Long getBeneficiaryRegID()
	{
		return beneficiaryRegID;
	}

	public Integer getCalledServiceID()
	{
		return calledServiceID;
	}

	public Boolean getIs1097()
	{
		return is1097;
	}

	public Timestamp getCallTime()
	{
		return callTime;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public String getServicesProvided()
	{
		return servicesProvided;
	}

	public String getCallClosureType()
	{
		return callClosureType;
	}

	public Integer getDispositionStatusID()
	{
		return dispositionStatusID;
	}

	public Integer getCallReceivedUserID()
	{
		return callReceivedUserID;
	}

	public Long getInformationServices()
	{
		return informationServices;
	}

	public Long getFeedbackServices()
	{
		return feedbackServices;
	}

	public Long getReferralServices()
	{
		return referralServices;
	}

	public Integer getCallEndUserID()
	{
		return callEndUserID;
	}

	public String getCategory()
	{
		return category;
	}

	public String getSubCategory()
	{
		return subCategory;
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

	public BeneficiaryCall()
	{

	}

	public BeneficiaryCall(Long benCallID, String benCallServicesMappingHistories, Integer calledServiceID,
			Boolean is1097, Timestamp callTime, String remarks, String callClosureType, Integer dispositionStatusID)
	{
		this.benCallID = benCallID;
		Type listType = new TypeToken<List<String>>()
			{
			}.getType();
		this.benCallServicesMappingHistories = new Gson().fromJson(benCallServicesMappingHistories, listType);
		this.calledServiceID = calledServiceID;
		this.is1097 = is1097;
		this.callTime = callTime;
		this.remarks = remarks;
		this.callClosureType = callClosureType;
		this.dispositionStatusID = dispositionStatusID;
	}

	public BeneficiaryCall(Long benCallID, Timestamp callTime, String remarks, Long informationServices,
			Long feedbackServices, Long referralServices, Timestamp createdDate, Long counsellingServices,
			CallType callTypeObj)
	{
		this.benCallID = benCallID;
		this.callTime = callTime;
		this.remarks = remarks;
		this.informationServices = new Long((informationServices > 0) ? 1 : 0);
		this.feedbackServices = new Long((feedbackServices > 0) ? 1 : 0);
		this.referralServices = new Long((referralServices > 0) ? 1 : 0);
		this.counsellingServices = new Long((counsellingServices > 0) ? 1 : 0);
		this.createdDate = createdDate;
		this.callTypeObj = callTypeObj;
	}

	public BeneficiaryCall(Long beneficiaryRegID, Boolean is1097, String createdBy)
	{
		this.beneficiaryRegID = beneficiaryRegID;
		this.is1097 = is1097;
		this.createdBy = createdBy;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
