package com.xxx.frame.Entity.Model;


import java.io.Serializable;

public class ResultModel implements Serializable {

	private static final long serialVersionUID = -1057167799757991912L;
	private int errcode;// 返回码
	private String errmsg;// 返回消息
	private Object data;

	public ResultModel(int errcode, String errmsg, Object data) {
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.data = data;
	}

	public ResultModel(int errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public ResultModel() {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}


}
