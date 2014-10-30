package com.oomoque.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wallet")
public class Wallet {
	
	private String walletId;
	private String walletKey;
	private Date createdDate;
	private Date modifiedDate;
	private Date lastSyncTime;
	private Boolean lastSyncStatus;
	
	@Id
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	
	public String getWalletKey() {
		return walletKey;
	}
	public void setWalletKey(String walletKey) {
		this.walletKey = walletKey;
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
	public Date getLastSyncTime() {
		return lastSyncTime;
	}
	public void setLastSyncTime(Date lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	public Boolean getLastSyncStatus() {
		return lastSyncStatus;
	}
	public void setLastSyncStatus(Boolean lastSyncStatus) {
		this.lastSyncStatus = lastSyncStatus;
	}
	
	
}
