package com.gapinc.booking.controller;

import java.util.Date;
import java.util.List;
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
import com.gapinc.booking.type.FeedBack;
import com.gapinc.booking.util.StringUtil;

@Controller
@RequestMapping("/product")
public class ProductCtroller extends BaseController {
	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	ProductService productService;

	@RequestMapping("productForm")
	public String productForm() {
		return "product/product_form";
	}

	@RequestMapping("productList")
	public String productList() {
		return "product/product_list";
	}

	@ResponseBody
	@RequestMapping("save")
	public void save(HttpServletRequest request, XhProduct product) {

		product.setId(StringUtil.uuid());
		product.setCreateTime(new Date());
		product.setIsDelete(false);
		product.setIsSend(false);
		// product.setSort(0);
		productService.save(product);
	}

	@ResponseBody
	@RequestMapping("search")
	public FeedBack search(HttpServletRequest request, XhProduct product) {
		List<XhProduct> list=productService.findProductList();
		FeedBack fb=new FeedBack();
		fb.setData(list);
		return fb;
	}

}
