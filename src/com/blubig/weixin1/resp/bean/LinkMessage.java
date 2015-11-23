package com.blubig.weixin1.resp.bean;
/**
 * 链接消息实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class LinkMessage extends BaseMessage{
	//链接消息名称
	private String Title;
	//链接消息描述
	private String Description;
	//消息链接
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return null == Description ? "" : Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return null == Url ? "" : Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
