package org.mano.dbreport.config.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.mano.dbreport.config.service.ReportConfigService;
import org.mano.dbreport.dao.SectionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportConfigController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportConfigController.class);
	
	@Autowired
	private ReportConfigService reportService;
	
	@Autowired
	private SectionDao sectionDao;
	
	@RequestMapping(value = "report-config", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() throws IOException, SQLException {
		//return ResponseEntity.ok(reportService.getAll());
		return ResponseEntity.ok(sectionDao.select("org.mano.dbreport.client.dao.SELCMapper", "getAll"));
	}
	
}
