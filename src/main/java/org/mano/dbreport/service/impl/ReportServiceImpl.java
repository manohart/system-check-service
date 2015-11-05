package org.mano.dbreport.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mano.dbreport.config.entity.DbCheck;
import org.mano.dbreport.config.service.ReportConfigService;
import org.mano.dbreport.dao.SectionDao;
import org.mano.dbreport.service.ReportService;
import org.mano.dbreport.service.entity.Report;
import org.mano.dbreport.service.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private SectionDao sectionDao;

	@Autowired
	private ReportConfigService reportConfigService;

	public Report get(int reportId) {

		Report report = new Report();
		
		org.mano.dbreport.config.entity.Report config = reportConfigService.get(reportId);

		List<Section> sections = new ArrayList<>();
		
		List<Map<String, Object>> sectionData = null;
		for (DbCheck sectionConfig : config.getSections()) {

			try {
				sectionData = sectionDao.select(sectionConfig.getQuerySchema(), sectionConfig.getQueryName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Section section = new Section();
			
			section.setColumns(sectionData.get(0).keySet());
			section.setData(sectionData);
			section.setDescription(sectionConfig.getHeader());
			section.setHeader(sectionConfig.getHeader());
			section.setSectionId(sectionConfig.getSectionId());
			
			sections.add(section);
		}
		
		report.setDescription(config.getDescription());
		report.setId(config.getId());
		report.setName(config.getName());
		report.setSections(sections);

		return report;
	}

	public Report getReport(String reportCd) {
		return getReport(getReportId(reportCd));
	}

	private String getReportId(String reportCd) {
		// TODO Auto-generated method stub
		return null;
	}

}
