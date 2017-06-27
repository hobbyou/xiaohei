package com.gapinc.booking.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gapinc.booking.type.FeedBack;
import com.gapinc.booking.util.DateUtil;
import com.gapinc.booking.util.StringUtil;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
	protected static Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Autowired
	public Environment env;

	/**
	 * 图片文件上传
	 */
	@ResponseBody
	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public FeedBack Image(@RequestParam("files") MultipartFile[] files, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
		FeedBack feedBack = new FeedBack();
		try {
			List<String> paths = new ArrayList<String>();
			feedBack.setData(paths);
			// 判断用户是否登录
			for (MultipartFile file : files) {
				if (file == null) {// 判断上传的文件是否为空
					continue;
				}
				String fileName = file.getOriginalFilename();// 文件原名称
				// 文件类型
				String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
				if (type == null) // 判断文件类型是否为空
					continue;
				// 自定义的文件名称
				String trueFileName = StringUtil.uuid() + "." + type;
				// 设置存放图片文件的路径
				String path = "image/"+DateUtil.format(new Date(), "yyyy/MM/dd") + "/";
				String dirPath = env.getProperty("web.upload-path") + path;
				File dir = new File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				logger.info("存放图片文件的路径:" + dirPath + trueFileName);
				// 转存文件到指定的路径
				file.transferTo(new File(dirPath + trueFileName));
				paths.add("/"+path + trueFileName);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			feedBack.error("系统异常：" + e.getMessage());
		}
		return feedBack;
	}

}