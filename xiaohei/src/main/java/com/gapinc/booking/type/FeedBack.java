package com.gapinc.booking.type;

public class FeedBack {

	private boolean success = true;
	private Object data;
	private String msg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void error(String msg) {
		this.success = false;
		this.msg = msg;
	}

}
