package org.mano.dbreport.config.entity;

import java.io.Serializable;

public class ReportDistribution implements Serializable {

	private static final long serialVersionUID = 1L;

	private int reportId;

	private int emailConfigId;

	private Character isActive;

	private Character skipEmpty;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getEmailConfigId() {
		return emailConfigId;
	}

	public void setEmailConfigId(int emailConfigId) {
		this.emailConfigId = emailConfigId;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Character getSkipEmpty() {
		return skipEmpty;
	}

	public void setSkipEmpty(Character skipEmpty) {
		this.skipEmpty = skipEmpty;
	}

}
