package com.blubig.weixin1.resp.bean;
/**
 * 视频实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class Video {
	// 媒体文件id
	private String MediaId;
	// 缩略图的媒体id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
