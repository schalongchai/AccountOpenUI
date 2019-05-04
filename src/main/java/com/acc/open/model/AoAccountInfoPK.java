package com.acc.open.model;

import java.io.Serializable;

/**
 * The primary key class for the AO_ACCOUNT_INFO database table.
 * 
 */

public class AoAccountInfoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private long acNo;


	private long cifNo;

	public AoAccountInfoPK() {
	}
	public long getAcNo() {
		return this.acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	public long getCifNo() {
		return this.cifNo;
	}
	public void setCifNo(long cifNo) {
		this.cifNo = cifNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AoAccountInfoPK)) {
			return false;
		}
		AoAccountInfoPK castOther = (AoAccountInfoPK)other;
		return 
			(this.acNo == castOther.acNo)
			&& (this.cifNo == castOther.cifNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.acNo ^ (this.acNo >>> 32)));
		hash = hash * prime + ((int) (this.cifNo ^ (this.cifNo >>> 32)));
		
		return hash;
	}
}