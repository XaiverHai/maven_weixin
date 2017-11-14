package com.xuhai.weixin.message.resp;

/**
 * ClassName: MusicMessage
 * 
 * @Description: 音乐消息
 * @author 徐海
 * @date 2017-11-14
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

}
