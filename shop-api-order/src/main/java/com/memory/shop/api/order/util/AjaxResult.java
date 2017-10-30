package com.memory.shop.api.order.util;

import java.io.Serializable;

public class AjaxResult implements Serializable{
	private boolean success = true;
	private String msg;
	
	private Object date;

	public void setMsg(String msg) {
		this.success = false;
		this.msg = msg;
	}

	public AjaxResult() {
	}

	public AjaxResult(boolean success, String msg, Object date) {
		this.success = success;
		this.msg = msg;
		this.date = date;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}
}
