package com.acc.open.model;

import java.io.Serializable;


/**
 * The persistent class for the AO_STATUS_FILE database table.
 * 
 */

public class AoStatusFile implements Serializable {
	private static final long serialVersionUID = 1L;


	private String code;


	private String statusDesc;

	public AoStatusFile() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public AoBulkFile addAoBulkFile(AoBulkFile aoBulkFile) {

		aoBulkFile.setAoStatusFile(this);

		return aoBulkFile;
	}

	public AoBulkFile removeAoBulkFile(AoBulkFile aoBulkFile) {
		aoBulkFile.setAoStatusFile(null);

		return aoBulkFile;
	}

}