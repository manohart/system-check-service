package org.mano.scs.config.entity;

import java.io.Serializable;

public class DbCheck implements Serializable {

	private static final long serialVersionUID = 1L;
	private int reportId;
	private int sectionId;
	private int sequence;
	private String header;
	private String querySchema;
	private String queryName;
	private String queryInputType;
	private String queryInputValue;
	private String dataExpectation;
	private String processorName;
	private String processorInputType;
	private String processorInputValue;
	private Character exceptionsOnly;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getQuerySchema() {
		return querySchema;
	}

	public void setQuerySchema(String querySchema) {
		this.querySchema = querySchema;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryInputType() {
		return queryInputType;
	}

	public void setQueryInputType(String queryInputType) {
		this.queryInputType = queryInputType;
	}

	public String getQueryInputValue() {
		return queryInputValue;
	}

	public void setQueryInputValue(String queryInputValue) {
		this.queryInputValue = queryInputValue;
	}

	public String getDataExpectation() {
		return dataExpectation;
	}

	public void setDataExpectation(String dataExpectation) {
		this.dataExpectation = dataExpectation;
	}

	public String getProcessorName() {
		return processorName;
	}

	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	public String getProcessorInputType() {
		return processorInputType;
	}

	public void setProcessorInputType(String processorInputType) {
		this.processorInputType = processorInputType;
	}

	public String getProcessorInputValue() {
		return processorInputValue;
	}

	public void setProcessorInputValue(String processorInputValue) {
		this.processorInputValue = processorInputValue;
	}

	public Character getExceptionsOnly() {
		return exceptionsOnly;
	}

	public void setExceptionsOnly(Character exceptionsOnly) {
		this.exceptionsOnly = exceptionsOnly;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reportId;
		result = prime * result + sectionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DbCheck other = (DbCheck) obj;
		if (reportId != other.reportId)
			return false;
		if (sectionId != other.sectionId)
			return false;
		return true;
	}

}
