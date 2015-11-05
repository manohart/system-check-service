package org.mano.dbreport.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SectionDao {

	List<Map<String, Object>> select(String mapperName, String statementId) throws SQLException;
	
}
