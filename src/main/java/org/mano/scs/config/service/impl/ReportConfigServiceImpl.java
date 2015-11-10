package org.mano.scs.config.service.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.mano.scs.client.dao.ReportConfigMapper;
import org.mano.scs.config.entity.DbCheck;
import org.mano.scs.config.entity.ReportFolder;
import org.mano.scs.config.entity.Report;
import org.mano.scs.config.entity.ReportDistribution;
import org.mano.scs.config.entity.ReportTemplate;
import org.mano.scs.config.service.ReportConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportConfigServiceImpl implements ReportConfigService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportConfigServiceImpl.class);

	@Autowired
	private ReportConfigMapper reportConfigMapper;

	public List<Report> getAll() throws SQLException {
		return reportConfigMapper.getAll();
	}

	public Report get(int id) {

		Report config = new Report();

		config.setCategory("SELC");

		config.setCode("SOB_SELC_DATA_CHECKS");

		config.setDescription("SOB SELC Data Checks");

		config.setFolder(new ReportFolder());

		config.setId(1);

		config.setName("SOB_SELC_DATA_CHECKS");

		config.setSubCategory("SOB");

		config.setTemplate(new ReportTemplate());

		config.setType("HTML");

		DbCheck section = new DbCheck();

		section.setQuerySchema("org.mano.scs.client.dao.TestMapper");

		section.setQueryName("get");

		config.setSections(Arrays.asList(new DbCheck[] { section }));

		config.setDistributions(Arrays.asList(new ReportDistribution[] {}));

		return config;
	}

}
