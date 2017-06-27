package com.gapinc.booking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gapinc.booking.domain.Booking;
import com.gapinc.booking.service.BookingService;
import com.gapinc.booking.util.JsonParam;

@Controller
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	protected static Logger logger = LoggerFactory.getLogger(BookingController.class);

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

	@RequestMapping("/")
	public String home() {
		logger.info("访问holl word");
		return "hello word";
	}

	@RequestMapping("/getBookingList")
	public List<Booking> getBookingList(HttpServletRequest request, @RequestBody JsonParam param) {
		List<Booking> bookings = bookingService.findBooking(param);
		return bookings;
	}

}