package com.iemr.helpline1097.data.co.services;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_institutedirectorymapping")
@Data
public class DirectoryMapping
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InstituteDirMapID")
	@Expose
	private Long instituteDirMapID;

	@Column(name = "InstitutionID")
	@Expose
	private Integer institutionID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstitutionID", insertable = false, updatable = false)
	@Expose
	private InstitutionDetails institutionDetails;

	@Column(name = "InstituteDirectoryID")
	@Expose
	private Integer instituteDirectoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstituteDirectoryID", insertable = false, updatable = false)
	@Expose
	private Directory directory;

	@Column(name = "InstituteSubDirectoryID")
	@Expose
	private Integer instituteSubDirectoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstituteSubDirectoryID", insertable = false, updatable = false)
	@Expose
	private InstituteSubDirectory subDirectory;

	// @Column(name = "StateID")
	// @Expose
	// private Integer stateID;
	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "StateID", insertable = false, updatable = false)
	// @JsonIgnore
	// private States states;
	// @Column(name = "DistrictID")
	// @Expose
	// private Integer districtID;
	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "DistrictID", insertable = false, updatable = false)
	// private Districts m_district;
	// @Column(name = "BlockID")
	// @Expose
	// private Integer blockID;
	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "BlockID", insertable = false, updatable = false)
	// @JsonIgnore
	// private DistrictBlock block;
	// @Column(name = "DistrictBranchMappingID")
	// @Expose
	// private Integer districtBranchMappingID;
	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "DistrictBranchMappingID", insertable = false, updatable = false)
	// @JsonIgnore
	// private DistrictBranchMapping branch;

	@Expose
	@Column(name = "InstituteRouteDirectoryID")
	private Integer instituteRouteDirectoryID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
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

	public DirectoryMapping()
	{
	}

	public DirectoryMapping(Long instituteDirMapID, Integer institutionID, String institutionName, String address,
			String contactNo1, String contactNo2, String contactNo3)
	{
		this.instituteDirMapID = instituteDirMapID;
		this.institutionDetails =
				new InstitutionDetails(institutionID, institutionName, address, contactNo1, contactNo2, contactNo3);
	}

	public DirectoryMapping(Long instituteDirMapID, InstitutionDetails institution)
	{
		this.instituteDirMapID = instituteDirMapID;
		this.institutionDetails = institution;
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
