package com.gapinc.booking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gapinc.booking.domain.XhProduct;
import com.gapinc.booking.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductCtroller extends BaseController {
	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	ProductService productService;

	@RequestMapping("productForm")
	public String productForm() {
		return "product/product_form";
	}

	@ResponseBody
	@RequestMapping("save")
	public void save(HttpServletRequest request, XhProduct proecut) {
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			System.out.println(key + "--->" + map.get(key)[0]);
		}
		// product.setId(StringUtil.uuid());
		// product.setCreateTime(new Date());
		// product.setIsDelete(false);
		// productService.save(product);
	}

	public static void main(String[] args) {

	}

}
