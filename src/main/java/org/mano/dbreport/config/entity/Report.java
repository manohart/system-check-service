package org.mano.dbreport.config.entity;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String code;
	private String type;
	private String name;
	private String description;
	private String category;
	private String subCategory;
	private Character isActive;

	private List<DbCheck> sections;

	private ReportTemplate template;

	private List<ReportDistribution> distributions;

	private ReportFolder folder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public List<DbCheck> getSections() {
		return sections;
	}

	public void setSections(List<DbCheck> sections) {
		this.sections = sections;
	}

	public ReportTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ReportTemplate template) {
		this.template = template;
	}

	public List<ReportDistribution> getDistributions() {
		return distributions;
	}

	public void setDistributions(List<ReportDistribution> distributions) {
		this.distributions = distributions;
	}

	public ReportFolder getFolder() {
		return folder;
	}

	public void setFolder(ReportFolder folder) {
		this.folder = folder;
	}

}
