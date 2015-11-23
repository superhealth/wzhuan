package com.blubig.weixin1.util;

/**
 * 菜单导航工具
 * @author Wangwh
 * @date 2015年5月11日
 * @version v0.1
 */
public class NavUtil {

	/** 
	 * 主菜单 
	 * @return 
	 */  
	public static String getMainMenu() {  
	    StringBuffer buffer = new StringBuffer();  
	    buffer.append("您好！"+EmojiUtil.emoji(0x1F48F)+"我是BigBlue，请回复数字选择服务：").append("\n\n");  
	    buffer.append("1:单图文消息").append("\n");  
	    buffer.append("2:只有文字").append("\n");  
	    buffer.append("3:多图文消息").append("\n");  
	    buffer.append("4:多图文首条不含图片").append("\n");  
	    buffer.append("5:多图文末条不含图片").append("\n\n");  
	    buffer.append(""+EmojiUtil.emoji(0x1F618)+"回复“?”显示此帮助菜单");  
	    return buffer.toString();  
	}  
}
