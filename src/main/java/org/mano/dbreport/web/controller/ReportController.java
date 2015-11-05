package org.mano.dbreport.web.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mano.dbreport.service.ReportService;
import org.mano.dbreport.service.entity.Report;
import org.mano.dbreport.service.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@RequestMapping("/home")
	String home() {
		return "home";
	}

	@RequestMapping("/hello")
	String hello() {
		return "hello";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		Report report = new Report();

		report.setName("Test Name");

		report.setDescription("Test ");

		Section section = new Section();

		section.setHeader("Test Header");
		section.setDescription("Test description");

		Map<String, Object> data1 = new LinkedHashMap<>();
		data1.put("col_1", "val_1");
		data1.put("col_2", "val_2");
		data1.put("col_3", "val_3");
		data1.put("col_4", "val_4");
		data1.put("col_5", "val_5");
		data1.put("col_6", "val_6");

		section.setColumns(data1.keySet());

		section.setData(Arrays.asList(data1));

		report.setSections(Arrays.asList(section));

		model.addAttribute("report", report);

		return "greeting";
	}

	@RequestMapping("/get")
	public String get(@RequestParam(value = "reportId", required = false, defaultValue = "0") int reportId,
			Model model) {

		model.addAttribute("report", reportService.get(reportId));

		return "greeting";
	}
}
