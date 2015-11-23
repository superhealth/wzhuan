package com.blubig.weixin1.req.bean;
/**
 * 语音消息实体类
 * @author Wangwh
 * @date 2015年4月27日
 * @version v0.1
 */
public class VoiceMessage extends BaseMessage {
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;
	// 语音识别结果，UTF8编码
	private String Recognition;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
