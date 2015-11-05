package org.mano.dbreport.config.entity;

import java.io.Serializable;

public class ReportFolder implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String category;
	private String subCategory;
	private String folter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getFolter() {
		return folter;
	}

	public void setFolter(String folter) {
		this.folter = folter;
	}

}
