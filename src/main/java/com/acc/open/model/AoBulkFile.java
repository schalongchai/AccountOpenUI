package com.acc.open.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AO_BULK_FILES database table.
 * 
 */

public class AoBulkFile implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;

	

	private String fileName;
	

	private String approvedBy;
	
	
	public final String getFileName() {
		return fileName;
	}

	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}


	private Date processDate;

	private BigDecimal totalCompleted;


	private BigDecimal totalFailed;


	private BigDecimal totalPassed;


	private BigDecimal totalRec;


	private BigDecimal totalRejected;


	private String uploadBy;


	private AoStatusFile aoStatusFile;
	

	private AoBulkDetail aoBulkDetail;
	  
	public final AoBulkDetail getAoBulkDetail() {
		return aoBulkDetail;
	}

	public final void setAoBulkDetail(AoBulkDetail aoBulkDetail) {
		this.aoBulkDetail = aoBulkDetail;
	}
	 

	public AoBulkFile() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public BigDecimal getTotalCompleted() {
		return this.totalCompleted;
	}

	public void setTotalCompleted(BigDecimal totalCompleted) {
		this.totalCompleted = totalCompleted;
	}

	public BigDecimal getTotalFailed() {
		return this.totalFailed;
	}

	public void setTotalFailed(BigDecimal totalFailed) {
		this.totalFailed = totalFailed;
	}

	public BigDecimal getTotalPassed() {
		return this.totalPassed;
	}

	public void setTotalPassed(BigDecimal totalPassed) {
		this.totalPassed = totalPassed;
	}

	public BigDecimal getTotalRec() {
		return this.totalRec;
	}

	public void setTotalRec(BigDecimal totalRec) {
		this.totalRec = totalRec;
	}

	public BigDecimal getTotalRejected() {
		return this.totalRejected;
	}

	public void setTotalRejected(BigDecimal totalRejected) {
		this.totalRejected = totalRejected;
	}

	public String getUploadBy() {
		return this.uploadBy;
	}

	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}

	public AoStatusFile getAoStatusFile() {
		return this.aoStatusFile;
	}

	public void setAoStatusFile(AoStatusFile aoStatusFile) {
		this.aoStatusFile = aoStatusFile;
	}

}