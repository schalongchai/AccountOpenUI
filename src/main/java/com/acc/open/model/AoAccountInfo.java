package com.acc.open.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AO_ACCOUNT_INFO database table.
 * 
 */

public class AoAccountInfo  {



	private AoAccountInfoPK id;

	
	private String acBrno;


	private BigDecimal acIntrate;

	private Date acOpendate;


	private String acPassbookNo;


	private String acRestFlag;


	private String acStatus;


	private String accountType;


	private String atmNumber;


	private Date closedDate;


	private String productType;
	
	public AoAccountInfo() {
	}

	public AoAccountInfoPK getId() {
		return this.id;
	}

	public void setId(AoAccountInfoPK id) {
		this.id = id;
	}

	public String getAcBrno() {
		return this.acBrno;
	}

	public void setAcBrno(String acBrno) {
		this.acBrno = acBrno;
	}

	public BigDecimal getAcIntrate() {
		return this.acIntrate;
	}

	public void setAcIntrate(BigDecimal acIntrate) {
		this.acIntrate = acIntrate;
	}

	public Date getAcOpendate() {
		return this.acOpendate;
	}

	public void setAcOpendate(Date acOpendate) {
		this.acOpendate = acOpendate;
	}

	public String getAcPassbookNo() {
		return this.acPassbookNo;
	}

	public void setAcPassbookNo(String acPassbookNo) {
		this.acPassbookNo = acPassbookNo;
	}

	public String getAcRestFlag() {
		return this.acRestFlag;
	}

	public void setAcRestFlag(String acRestFlag) {
		this.acRestFlag = acRestFlag;
	}

	public String getAcStatus() {
		return this.acStatus;
	}

	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAtmNumber() {
		return this.atmNumber;
	}

	public void setAtmNumber(String atmNumber) {
		this.atmNumber = atmNumber;
	}

	public Date getClosedDate() {
		return this.closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}