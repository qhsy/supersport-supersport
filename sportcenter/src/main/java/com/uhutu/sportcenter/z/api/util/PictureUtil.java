package com.uhutu.sportcenter.z.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PictureUtil {
		
	public static List<String> getImgStr(String htmlStr) {
		String img="";
		Pattern p_image;   
		Matcher m_image;   
		List<String> pics = new ArrayList<String>();
		//图片链接地址
		String regEx_img = "<img.*src=(.*?)[^>]*?>";
		p_image = Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE);   
		m_image = p_image.matcher(htmlStr);
		while(m_image.find()){
			img = img + "," + m_image.group();  
			//匹配src
			Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				pics.add(m.group(1));
			}
		}
		return pics;
	}
		
	public static void  main(String[] strs){
		String htmlstr = "<p><span style='font-size:12px'><span style='font-family:georgia,serif'><img alt='' src='http://ali-cfile.ichsy.com/cfiles/staticfiles/zoofile/273c0/s-1024-768/2787379d90b043e49b7505a0df1bd0e7.jpg' style='height:768px; width:1024px' />而惹人<img alt='' src='http://ali-cfile.ichsy.com/cfiles/staticfiles/zoofile/273c0/s-1024-768/ec4e668052544b778ff32f9ee4b672d2.jpg' style='height:768px; width:1024px' />"
		+"<br /><br />"
		+"<img alt='' src='http://ali-cfile.ichsy.com/cfiles/staticfiles/zoofile/273c0/s-1024-768/9a570aaac0d54825b1979bed71d57f53.jpg' style='height:768px; width:1024px' /></span></span></p>";
		PictureUtil util = new PictureUtil();
		List imgList = util.getImgStr(htmlstr);
		System.out.print(imgList.get(0));
	}
}
