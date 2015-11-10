package org.mano.scs.service.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Section implements Serializable {

	private static final long serialVersionUID = 1L;

	private int sectionId;

	private String header;

	private String description;

	private Set<String> columns;

	private List<Map<String, Object>> data;

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getColumns() {
		return columns;
	}

	public void setColumns(Set<String> columns) {
		this.columns = columns;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
