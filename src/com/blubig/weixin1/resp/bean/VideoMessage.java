package com.blubig.weixin1.resp.bean;
/**
 * 视频消息实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class VideoMessage extends BaseMessage {
	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}
