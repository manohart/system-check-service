package org.mano.dbreport.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mano.dbreport.dao.SectionDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SectionDaoImpl extends SqlSessionDaoSupport implements SectionDao {

	@Override
	public List<Map<String, Object>> select(String mapperName, String statementId) throws SQLException {
		return getSqlSession().selectList(mapperName + "." + statementId);
	}

}
