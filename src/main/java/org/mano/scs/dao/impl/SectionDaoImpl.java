package org.mano.scs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mano.scs.dao.SectionDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SectionDaoImpl extends SqlSessionDaoSupport implements SectionDao<Map<String, Object>> {

	@Override
	public List<Map<String, Object>> select(String mapperName, String statementId) throws SQLException {
		return getSqlSession().selectList(mapperName + "." + statementId);
	}

	@Override
	public List<Map<String, Object>> select(String mapperName, String statementId, Object inputParam)
			throws SQLException {
		return getSqlSession().selectList(mapperName + "." + statementId, inputParam);
	}

}
