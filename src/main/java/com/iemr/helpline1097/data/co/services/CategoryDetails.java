package com.iemr.helpline1097.data.co.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_Category")
public class CategoryDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "CategoryID")
	private Integer categoryID;
	@JsonIgnore
	@OneToMany(mappedBy = "categoryDetails", fetch = FetchType.LAZY)
	@Transient
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;

	@Expose
	@Column(name = "SubServiceID")
	private Integer subServiceID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubServiceID", insertable = false, updatable = false)
	@Expose
	private SubServices subServices;

	@Expose
	@Column(name = "CategoryName")
	private String categoryName;
	@Expose
	@Column(name = "CategoryDesc")
	private String categoryDesc;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryDetails")
	@Transient
	@JsonIgnore
	private Set<SubCategoryDetails> subCategories;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Integer getCategoryID()
	{
		return categoryID;
	}

	public Integer getSubServiceID()
	{
		return subServiceID;
	}

	public void setCategoryID(Integer categoryID)
	{
		this.categoryID = categoryID;
	}

	public String getCategoryName()
	{
		return this.categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public String getCategoryDesc()
	{
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc)
	{
		this.categoryDesc = categoryDesc;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public CategoryDetails()
	{
	}

	public CategoryDetails(Integer CategoryID, String CategoryName)
	{
		this.categoryID = CategoryID;
		this.categoryName = CategoryName;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
