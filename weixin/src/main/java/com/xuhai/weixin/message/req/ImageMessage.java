package com.xuhai.weixin.message.req;

import com.xuhai.weixin.message.req.BaseMessage;

/**
 * ClassName: ImageMessage
 * 
 * @Description: 图片消息
 * @author 徐海
 * @date 2017-11-14
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
