package com.blubig.weixin1.util;

/**
 * 用于转换QQ表情
 * @author Wangwh
 * @date 2015年5月11日
 * @version v0.1
 */
public class EmojiUtil {

	/** 
	 * emoji表情转换(hex -> utf-16) 
	 *  
	 * @param hexEmoji 
	 * @return 
	 */  
	public static String emoji(int hexEmoji) {  
	    return String.valueOf(Character.toChars(hexEmoji));  
	}  
}
