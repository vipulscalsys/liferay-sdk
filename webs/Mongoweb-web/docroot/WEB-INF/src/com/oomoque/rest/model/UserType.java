package com.oomoque.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userType")
public class UserType {
	
	private String userTypeId;
	private String userTypeName;
	private Date createdDate;
	private Date modifiedDate;
	
	@Id
	public String getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
