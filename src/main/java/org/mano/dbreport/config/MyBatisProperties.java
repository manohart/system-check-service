package org.mano.dbreport.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mybatis", ignoreUnknownFields = false)
public class MyBatisProperties {

	private String cacheEnabled;
	private String typeAlias;
	private String mapUnderscoreToCamelCase;
	private String defaultFetchSize;
	private String mapperLocations;

	public String getCacheEnabled() {
		return cacheEnabled;
	}

	public void setCacheEnabled(String cacheEnabled) {
		this.cacheEnabled = cacheEnabled;
	}

	public String getTypeAlias() {
		return typeAlias;
	}

	public void setTypeAlias(String typeAlias) {
		this.typeAlias = typeAlias;
	}

	public String getMapUnderscoreToCamelCase() {
		return mapUnderscoreToCamelCase;
	}

	public void setMapUnderscoreToCamelCase(String mapUnderscoreToCamelCase) {
		this.mapUnderscoreToCamelCase = mapUnderscoreToCamelCase;
	}

	public String getDefaultFetchSize() {
		return defaultFetchSize;
	}

	public void setDefaultFetchSize(String defaultFetchSize) {
		this.defaultFetchSize = defaultFetchSize;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}

}