package com.xuhai.weixin.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xuhai.weixin.dispatcher.EventDispatcher;
import com.xuhai.weixin.dispatcher.MsgDispatcher;
import com.xuhai.weixin.util.MessageUtil;
import com.xuhai.weixin.util.SignUtil;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
	private static Logger logger = Logger.getLogger(WechatSecurity.class);

	/**
	 * 
	 * @Description: 用于接收 get 参数，返回验证参数
	 * @param request
	 * @param response
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @author 徐海
	 * @date 2017-11-4
	 */
	@RequestMapping(value = "security", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {
		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				PrintWriter out = response.getWriter();
				out.print(echostr);
				out.close();
			} else {
				logger.info("这里存在非法请求！");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	@RequestMapping(value = "security", method = RequestMethod.POST)
	// post 方法用于接收微信服务端消息
	public void DoPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			String msgtype = map.get("MsgType");
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
				EventDispatcher.processEvent(map); // 进入事件处理
			} else {
				MsgDispatcher.processMessage(map); // 进入消息处理
				response.setCharacterEncoding("utf-8");
				String respXML = MsgDispatcher.processMessage(map); //
				PrintWriter out = response.getWriter();
				out.print(respXML);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			logger.error(e, e);
		}

	}
}
