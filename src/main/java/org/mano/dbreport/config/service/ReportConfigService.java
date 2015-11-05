package org.mano.dbreport.config.service;

import java.sql.SQLException;
import java.util.List;

import org.mano.dbreport.config.entity.Report;

public interface ReportConfigService {

	List<Report> getAll() throws SQLException;
	
	Report get(int id);
	
}
