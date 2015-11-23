package com.blubig.weixin1.widget;
/**
 * 复合类型的按钮
 * @author Wangwh
 * @date 2015年4月29日
 * @version v0.1s
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
