package com.xuhai.weixin.message.resp;

/**
 * ClassName: Video
 * 
 * @Description: 视频消息体
 * @author 徐海
 * @date 2017-11-14
 */
public class Video {

	private String MediaId;
	private String Title;
	private String Description;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
