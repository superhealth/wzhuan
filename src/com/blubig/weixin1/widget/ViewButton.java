package com.blubig.weixin1.widget;
/**
 * view类型的按钮
 * @author Wangwh
 * @date 2015年4月29日
 * @version v0.1
 */
public class ViewButton extends Button {
	private String type;
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
