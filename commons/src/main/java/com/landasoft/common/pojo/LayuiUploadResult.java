package com.landasoft.common.pojo;

import java.util.Map;

/**
 * layui上传文件返回结果
 * @author zhaoyuan
 * @date 2020,Feb 13 8:10 pm
 */
public class LayuiUploadResult {

	//code=0代表上传成功
	private int code;
	
	private String msg;
	
	private Map<Object, Object> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<Object, Object> getData() {
		return data;
	}

	public void setData(Map<Object, Object> data) {
		this.data = data;
	}
	
}
