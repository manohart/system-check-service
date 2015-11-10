package org.mano.scs.config.entity;

import java.io.Serializable;

public class DbQuery implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String schema;
	private String descrption;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

}
