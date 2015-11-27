package com.accumulate.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author YLF
 * 
 *         创建网页标签，解析网页标签
 * 
 */
public class HtmlUtils {


	/**
	 * @return 解析直播视频URL
	 */
	public static String parseWeb(String videoUrl) {/*
		String array[] = videoUrl.split(" src=");
		if (array.length > 1) {
			String path = videoUrl.split("src=")[1].replace("></iframe>", "").replace("\"", "");
			return path;
		} else {
			return null;
		}
	*/  if(videoUrl.contains("src")){
		Document document=Jsoup.parse(videoUrl);
		Element ec=document.select("iframe").first();
		return ec.attr("src");
	}
	return null;
	
	}

	/**
	 * @return 创建网页src标签图片
	 */
	public static String createImageWeb(String imagePath) {
		String webImage = "<img src='" + imagePath + "'>";
		return webImage;
	}

	/**
	 * @return 解析网页src 标签
	 */
	public static String parseWebImage(String imagePath) {
		String image = imagePath.replace("<img src=", "").replace(">", "");
		return image;
	}
}
