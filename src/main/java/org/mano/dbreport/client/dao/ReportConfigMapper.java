package org.mano.dbreport.client.dao;

import java.sql.SQLException;
import java.util.List;

import org.mano.dbreport.config.entity.Report;

public interface ReportConfigMapper {
	List<Report> getAll() throws SQLException;
}
