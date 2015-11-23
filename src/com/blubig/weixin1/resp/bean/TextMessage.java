package com.blubig.weixin1.resp.bean;

/**
 * 文本消息实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class TextMessage extends BaseMessage {
	// 回复消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
