package com.blubig.weixin1.resp.bean;
/**
 * 语音消息实体类
 * @author Wangwh
 * @date 2015年4月28日
 * @version v0.1
 */
public class VoiceMessage extends BaseMessage {
	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
