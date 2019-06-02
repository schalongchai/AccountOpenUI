package com.acc.open.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the AO_BULK_DETAIL database table.
 * 
 */

public class AoBulkDetail implements Serializable {

	private AoBulkFile aoBulkFile;
	
	private Long id_detail;
	
	private Long id_file;
    
	private Long seq;

    private String acBranch;

	private BigDecimal acNo;

	private String acOpenType;

	private Date acOpendate;

	private String acProductType;

	private String acStatus;

	private BigDecimal amountIncome;

	private Date birthDate;

	private BigDecimal cifNo;

	private BigDecimal citizenID;

	private String customerType;

	private String documentType;

	private Date expireDate;

	private String firstNameEn;

	private String firstNameTh;

	private String homeExt;

	private String homeNumber;

	private String invValField;

	private Date issueDate;

	private String lastNameEn;

	private String lastNameTh;

	private String midleNameEn;

	private String midleNameTh;

	private String missingField;

	private String mobileNumber;

	private String nationality;

	private String occupation;

	private String offExt;

	private String offNumber;

	private String prefixEn;

	private String prefixTh;

	private String reqFieldPassed;

	private String sourceIncome;

	private String valFieldPassed;

	private String wkAddrCountry;

	private String wkAddrDisctict;

	private String wkAddrMoo;

	private String wkAddrNo;

	private BigDecimal wkAddrPostcode;

	private String wkAddrProvince;

	private String wkAddrRoad;

	private String wkAddrSoi;

	private String wkAddrSubdisct;

	private String wkCompName;

	private String wkPosition;

	public final AoBulkFile getAoBulkFile() {
		return aoBulkFile;
	}

	public final void setAoBulkFile(AoBulkFile aoBulkFile) {
		this.aoBulkFile = aoBulkFile;
	}

	private static final long serialVersionUID = 1L;

	public Long getId_detail() {
		return id_detail;
	}

	public void setId_detail(Long id_detail) {
		this.id_detail = id_detail;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public final Long getId_file() {
		return id_file;
	}

	public final void setId_file(Long id_file) {
		this.id_file = id_file;
	}

	public final BigDecimal getCitizenID() {
		return citizenID;
	}

	public final void setCitizenID(BigDecimal citizenID) {
		this.citizenID = citizenID;
	}

	public AoBulkDetail() {
	}


	public String getAcBranch() {
		return this.acBranch;
	}

	public void setAcBranch(String acBranch) {
		this.acBranch = acBranch;
	}

	public BigDecimal getAcNo() {
		return this.acNo;
	}

	public void setAcNo(BigDecimal acNo) {
		this.acNo = acNo;
	}

	public String getAcOpenType() {
		return this.acOpenType;
	}

	public void setAcOpenType(String acOpenType) {
		this.acOpenType = acOpenType;
	}

	public Date getAcOpendate() {
		return this.acOpendate;
	}

	public void setAcOpendate(Date acOpendate) {
		this.acOpendate = acOpendate;
	}

	public String getAcProductType() {
		return this.acProductType;
	}

	public void setAcProductType(String acProductType) {
		this.acProductType = acProductType;
	}

	public String getAcStatus() {
		return this.acStatus;
	}

	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}

	public BigDecimal getAmountIncome() {
		return this.amountIncome;
	}

	public void setAmountIncome(BigDecimal amountIncome) {
		this.amountIncome = amountIncome;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getCifNo() {
		return this.cifNo;
	}

	public void setCifNo(BigDecimal cifNo) {
		this.cifNo = cifNo;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getFirstNameEn() {
		return this.firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}

	public String getFirstNameTh() {
		return this.firstNameTh;
	}

	public void setFirstNameTh(String firstNameTh) {
		this.firstNameTh = firstNameTh;
	}

	public String getHomeExt() {
		return this.homeExt;
	}

	public void setHomeExt(String homeExt) {
		this.homeExt = homeExt;
	}

	public String getHomeNumber() {
		return this.homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getInvValField() {
		return this.invValField;
	}

	public void setInvValField(String invValField) {
		this.invValField = invValField;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getLastNameEn() {
		return this.lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}

	public String getLastNameTh() {
		return this.lastNameTh;
	}

	public void setLastNameTh(String lastNameTh) {
		this.lastNameTh = lastNameTh;
	}

	public String getMidleNameEn() {
		return this.midleNameEn;
	}

	public void setMidleNameEn(String midleNameEn) {
		this.midleNameEn = midleNameEn;
	}

	public String getMidleNameTh() {
		return this.midleNameTh;
	}

	public void setMidleNameTh(String midleNameTh) {
		this.midleNameTh = midleNameTh;
	}

	public String getMissingField() {
		return this.missingField;
	}

	public void setMissingField(String missingField) {
		this.missingField = missingField;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOffExt() {
		return this.offExt;
	}

	public void setOffExt(String offExt) {
		this.offExt = offExt;
	}

	public String getOffNumber() {
		return this.offNumber;
	}

	public void setOffNumber(String offNumber) {
		this.offNumber = offNumber;
	}

	public String getPrefixEn() {
		return this.prefixEn;
	}

	public void setPrefixEn(String prefixEn) {
		this.prefixEn = prefixEn;
	}

	public String getPrefixTh() {
		return this.prefixTh;
	}

	public void setPrefixTh(String prefixTh) {
		this.prefixTh = prefixTh;
	}

	public String getReqFieldPassed() {
		return this.reqFieldPassed;
	}

	public void setReqFieldPassed(String reqFieldPassed) {
		this.reqFieldPassed = reqFieldPassed;
	}

	public String getSourceIncome() {
		return this.sourceIncome;
	}

	public void setSourceIncome(String sourceIncome) {
		this.sourceIncome = sourceIncome;
	}

	public String getValFieldPassed() {
		return this.valFieldPassed;
	}

	public void setValFieldPassed(String valFieldPassed) {
		this.valFieldPassed = valFieldPassed;
	}

	public String getWkAddrCountry() {
		return this.wkAddrCountry;
	}

	public void setWkAddrCountry(String wkAddrCountry) {
		this.wkAddrCountry = wkAddrCountry;
	}

	public String getWkAddrDisctict() {
		return this.wkAddrDisctict;
	}

	public void setWkAddrDisctict(String wkAddrDisctict) {
		this.wkAddrDisctict = wkAddrDisctict;
	}

	public String getWkAddrMoo() {
		return this.wkAddrMoo;
	}

	public void setWkAddrMoo(String wkAddrMoo) {
		this.wkAddrMoo = wkAddrMoo;
	}

	public String getWkAddrNo() {
		return this.wkAddrNo;
	}

	public void setWkAddrNo(String wkAddrNo) {
		this.wkAddrNo = wkAddrNo;
	}

	public BigDecimal getWkAddrPostcode() {
		return this.wkAddrPostcode;
	}

	public void setWkAddrPostcode(BigDecimal wkAddrPostcode) {
		this.wkAddrPostcode = wkAddrPostcode;
	}

	public String getWkAddrProvince() {
		return this.wkAddrProvince;
	}

	public void setWkAddrProvince(String wkAddrProvince) {
		this.wkAddrProvince = wkAddrProvince;
	}

	public String getWkAddrRoad() {
		return this.wkAddrRoad;
	}

	public void setWkAddrRoad(String wkAddrRoad) {
		this.wkAddrRoad = wkAddrRoad;
	}

	public String getWkAddrSoi() {
		return this.wkAddrSoi;
	}

	public void setWkAddrSoi(String wkAddrSoi) {
		this.wkAddrSoi = wkAddrSoi;
	}

	public String getWkAddrSubdisct() {
		return this.wkAddrSubdisct;
	}

	public void setWkAddrSubdisct(String wkAddrSubdisct) {
		this.wkAddrSubdisct = wkAddrSubdisct;
	}

	public String getWkCompName() {
		return this.wkCompName;
	}

	public void setWkCompName(String wkCompName) {
		this.wkCompName = wkCompName;
	}

	public String getWkPosition() {
		return this.wkPosition;
	}

	public void setWkPosition(String wkPosition) {
		this.wkPosition = wkPosition;
	}

}