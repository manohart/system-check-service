package org.mano.scs.dao;

import java.sql.SQLException;
import java.util.List;

public interface SectionDao<E> {

	List<E> select(String mapperName, String statementId) throws SQLException;
	List<E> select(String mapperName, String statementId, Object inputParam) throws SQLException;
	
}
