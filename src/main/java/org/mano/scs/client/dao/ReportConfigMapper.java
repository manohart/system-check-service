package org.mano.scs.client.dao;

import java.sql.SQLException;
import java.util.List;

import org.mano.scs.config.entity.Report;

public interface ReportConfigMapper {
	List<Report> getAll() throws SQLException;
}
