package com.gapinc.booking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	protected static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("hello", "from TemplateController.helloHtml");
		model.addAttribute("name", "hobby");
		List<Date> dates = new ArrayList<Date>();
		dates.add(new Date());
		dates.add(new Date());
		model.addAttribute("dates", dates);
		model.addAttribute("date", new Date());
		return "index";
	}
	
	@RequestMapping
	public String starter(){
		return "starter";
	}

}