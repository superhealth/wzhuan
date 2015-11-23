package com.blubig.weixin1.resp.bean;
/**
 * 图片消息实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class ImageMessage extends BaseMessage {
	// 图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
