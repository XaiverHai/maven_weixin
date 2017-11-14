package com.xuhai.weixin.message.resp;

/**
 * ClassName: TextMessage
 * 
 * @Description: 文本消息消息体
 * @author 徐海
 * @date 2017-11-14
 */
public class TextMessage extends BaseMessage {

	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
