package com.qianfeng.util;

import com.qianfeng.vo.JsonBean;

public class JsonUtil {
	
	public static JsonBean getJsonBean(int code,Object msg) {
		JsonBean jsonBean = new JsonBean();
		jsonBean.setCode(code);
		jsonBean.setMsg(msg);
		return jsonBean;
	}

}
