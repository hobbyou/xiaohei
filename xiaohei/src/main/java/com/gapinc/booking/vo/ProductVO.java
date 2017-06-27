package com.gapinc.booking.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gapinc.booking.domain.XhProduct;

public class ProductVO {
	private String id;
	private String name;
	private String img;
	private String content;
	private Boolean isSend;
	private Integer sort;
	private Boolean isDelete;
	private Date createTime;

	public ProductVO(XhProduct product) {
		BeanUtils.copyProperties(product, this, "content");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
