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
package com.iemr.helpline1097.data.co.beneficiary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
public class M_Promoservice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="GenderID")
	private Long id;

	@Expose
	private String pamphlet;
	@Expose
	private String radio;
	@Expose
	private String television;
	@Expose
	private String familyFriends;
	@Expose
	private String healthcareWorker;
	@Expose
	private String others;
	@Expose
	private String notDisclosed;
	
	public M_Promoservice() {
		
	}
	
	public M_Promoservice(String pamphlet,String radio,String television, String familyFriends, String healthcareWorker,String others,String notDisclosed) {
		
		this.pamphlet = pamphlet;
		this.radio = radio;
		this.television = television;
		this.familyFriends = familyFriends;
		this.healthcareWorker = healthcareWorker;
		this.others = others;
		this.notDisclosed = notDisclosed;
	}
	
	public Long getId() {
		return id;
	}

	public String getPamphlet() {
		return pamphlet;
	}

	public void setPamphlet(String pamphlet) {
		this.pamphlet = pamphlet;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getTelevision() {
		return television;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public String getFamilyFriends() {
		return familyFriends;
	}

	public void setFamilyFriends(String familyFriends) {
		this.familyFriends = familyFriends;
	}

	public String getHealthcareWorker() {
		return healthcareWorker;
	}

	public void setHealthcareWorker(String healthcareWorker) {
		this.healthcareWorker = healthcareWorker;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getNotDisclosed() {
		return notDisclosed;
	}

	public void setNotDisclosed(String notDisclosed) {
		this.notDisclosed = notDisclosed;
	}
	
	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls().setLongSerializationPolicy(LongSerializationPolicy.STRING);
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
