package com.blubig.weixin1.event;

/**
 * 自定义菜单事件
 * @author Wangwh
 * @date 2015年4月29日
 * @version v0.1
 */
public class MenuEvent extends BaseEvent {
	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
