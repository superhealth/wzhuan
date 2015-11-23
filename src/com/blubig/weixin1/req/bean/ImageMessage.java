package com.blubig.weixin1.req.bean;
/**
 * 图片消息实体类
 * @author Wangwh
 * @date 2015年4月27日
 * @version v0.1
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
