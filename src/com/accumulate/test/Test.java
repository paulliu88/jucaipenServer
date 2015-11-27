package com.accumulate.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {


	public static void main(String[] args) {
		String str="<iframe width='780' height='520' frameborder='0' src='http://cloud.quklive.com/cloud/a/embed/9445486731118962?autoPlay=true'></iframe>";
		Document document=Jsoup.parse(str);
		Element ec=document.select("iframe").first();
		String src=ec.attr("src");
		System.out.println("src:"+src);
		
	}

}
