package com.xuhai.web.util;

import java.util.Properties;

public class GlobalConstants {
	public static Properties interfaceUrlProperties;

	/**
	 * 
	 * @Description: TODO
	 * @param key
	 * @param @return   
	 * @author 徐海
	 * @date 2017-11-14 9.46
	 */
	    public static String getInterfaceUrl(String key) {
	        return (String) interfaceUrlProperties.get(key);
	    }
}
