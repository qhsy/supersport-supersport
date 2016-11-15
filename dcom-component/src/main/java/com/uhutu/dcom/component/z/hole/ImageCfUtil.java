package com.uhutu.dcom.component.z.hole;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.component.z.util.ImageUtil;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zooweb.io.ImageThumb;
import com.uhutu.zooweb.support.WebUploadSupport;

/**
 * crossfit个人证书生成
 * @author 逄小帅
 *
 */
public class ImageCfUtil {

	/**
	 * 合成个人图片
	 * @param name
	 * 		用户名称
	 * @param box
	 * 		所属box
	 * @param typeName
	 * 		参赛类型名称
	 * @param code
	 * 		参赛码
	 * @return 文件上传结果
	 */
	public static FileUploadResult makeImagePerson(String name,String box,String typeName,String code,String headUrl) {	
		
		FileUploadResult webUploadResult = new FileUploadResult();
		
		try {
			
			URL url = ImageCfUtil.class.getResource("/hole/crossfit/person/bg.png");
			
			/*背景图*/
			Image srcImg = ImageIO.read(url);
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
					0, null);
			/*设置旋转*/
			g.rotate(0);
			
			float alpha = 1.0f;
			
			/*活动icon*/
			ImageUtil.drawImageCf("/person/corplogo.png", g, alpha, 202, 12, 102, 100);
			
			/*果冻体育icon*/
			ImageUtil.drawImageCf("/person/gdlogo.png", g, alpha, 320, 40, 204, 48);
			
			if(StringUtils.isNotEmpty(headUrl)){
				
				ImageThumb imageThumb = ImageUtil.upThumbWithHeight(headUrl, 364);
				
				int x = ImageUtil.calx(imageThumb.getThumbWidth());
				
				/*头像icon*/
				ImageUtil.drawImageHead(headUrl, g, alpha, x, 150, imageThumb.getThumbWidth(), 364);
				
			}else{
				
				/*头像icon*/
				ImageUtil.drawImageHead(headUrl, g, alpha, 196, 150, 364, 364);
				
			}			
			
			/*throwdown 水印*/
			ImageUtil.drawImageCf("/person/throwdown.png", g, alpha, 52, 120, 308, 264);			
	        
			int namex = ImageUtil.fontWidth(name, Font.BOLD, 48);
			
			if(namex == 0){
				
				namex = 316;
				
			}else{
				
				namex = ImageUtil.calx(namex);
				
			}
			
			/*姓名*/
	        ImageUtil.drawStrCf(name, g, Font.BOLD, 48, namex, 576);
	        
	        int boxx = 286;
	        
	        if(StringUtils.isNotEmpty(box)){
	        	
	        	boxx = ImageUtil.fontWidth(box, Font.BOLD, 32);
	        	
	        	 boxx = ImageUtil.calx(boxx);
	        	
	        }	       
	        
	        /*所属box*/
	        ImageUtil.drawStrCf(box, g, Font.BOLD, 32, boxx, 638);
	        /*参赛码*/
	        ImageUtil.drawStrCf(typeName+"  参赛码："+code, g, Font.BOLD, 36, 162, 690);
	        /*宣传语*/
	        ImageUtil.drawImageCf("/person/kill.png", g, alpha, 70, 758, 594, 66);
	        /*group icon*/
	        ImageUtil.drawImageCf("/person/group.png", g, alpha, 50, 838, 424, 250);
	        
	        /*二维码 icon*/
	        ImageUtil.drawImageCf("/person/qrcode.png", g, alpha, 536, 892, 160, 160);
	        
	        /*扫码标注*/
	        ImageUtil.drawStrCf("扫描二维码参与报名", g, Font.BOLD, 24, 510, 1094);
	        
	        /*buttom 底部*/
	        ImageUtil.drawStrCf("注：本活动报名最终解释权归果冻体育官方所有。", g, Font.BOLD, 18, 160, 1126);
			
			g.dispose();
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 生成图片
			ImageIO.write(buffImg, "JPG", bos);
			
			webUploadResult = new WebUploadSupport().remoteUpload("crossfit", "person.jpg", bos.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return webUploadResult;
		
	}   
	
	/**
	 * 合成团队图片
	 * @param name
	 * 		用户名称
	 * @param box
	 * 		所属box
	 * @param typeName
	 * 		参赛类型名称
	 * @param code
	 * 		参赛码
	 * @return 文件上传结果
	 */
	public static FileUploadResult makeImageGroup(String name,String box,String typeName,String code) {	
		
		FileUploadResult webUploadResult = new FileUploadResult();
		
		try {
			
			URL url = ImageCfUtil.class.getResource("/hole/crossfit/group/bg.png");
			
			/*背景图*/
			Image srcImg = ImageIO.read(url);
			
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
					0, null);
			/*设置旋转*/
			g.rotate(0);
			
			float alpha = 1.0f;
			
			/*活动icon*/
			ImageUtil.drawImageCf("/group/corplogo.png", g, alpha, 202, 18, 102, 100);
			
			/*果冻体育icon*/
			ImageUtil.drawImageCf("/group/gdlogo.png", g, alpha, 320, 46, 204, 48);
			
			/*group icon*/
			ImageUtil.drawImageCf("/group/grouplogo.png", g, alpha, 100, 210, 552, 328);		
			
			int namex = ImageUtil.fontWidth(name, Font.BOLD, 48);
			
			if(namex == 0){
				
				namex = 260;
				
			}else{
				
				namex = ImageUtil.calx(namex);
				
			}
			
			/*姓名*/
	        ImageUtil.drawStrCf(name, g, Font.BOLD, 48, namex, 606);
	        
	        int boxx = 286;
	        
	        if(StringUtils.isNotEmpty(box)){
	        	
	        	boxx = ImageUtil.fontWidth(box, Font.BOLD, 32);
	        	
	        	 boxx = ImageUtil.calx(boxx);
	        	
	        }	
	        /*所属box*/
	        ImageUtil.drawStrCf(box, g, Font.BOLD, 32, boxx, 668);
	        /*参赛码*/
	        ImageUtil.drawStrCf(typeName+"  参赛码："+code, g, Font.BOLD, 36, 162, 740);
	        
	        /*宣传语*/
	        ImageUtil.drawImageCf("/group/kill.png", g, alpha, 86, 812, 594, 66);
	        
	        /*二维码 icon*/
	        ImageUtil.drawImageCf("/group/qrcode.png", g, alpha, 294, 908, 160, 160);
	        
	        /*扫码标注*/
	        ImageUtil.drawStrCf("扫描二维码参与报名", g, Font.BOLD, 24, 272, 1106);
	        
	        /*buttom 底部*/
	        ImageUtil.drawStrCf("注：本活动报名最终解释权归果冻体育官方所有。", g, Font.BOLD, 18, 160, 1160);
			
			g.dispose();
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 生成图片
			ImageIO.write(buffImg, "JPG", bos);
			
			webUploadResult = new WebUploadSupport().remoteUpload("crossfit", "group.jpg", bos.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return webUploadResult;
		
	}   
	
	/**
	 * 合成观赛图片
	 * @param code
	 * 		观赛码
	 * @return 文件上传结果
	 */
	public static FileUploadResult makeImageWatch(String code) {	
		
		FileUploadResult webUploadResult = new FileUploadResult();
		
		try {
			
			URL url = ImageCfUtil.class.getResource("/hole/crossfit/watch/bg.jpg");
			
			/*背景图*/
			Image srcImg = ImageIO.read(url);
			
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
					0, null);
			/*设置旋转*/
			g.rotate(0);
			
			float alpha = 1.0f;
			
			String box = "观赛码："+code;
			
			int boxx = ImageUtil.fontWidth(box, Font.BOLD, 56);
			
			if(boxx == 0){
				
				boxx = 166;
				
			}else{
				
				boxx = ImageUtil.calx(boxx);
				
			}
			
			 /*所属box*/
	        ImageUtil.drawColorStr(box, g, Font.BOLD, 56,new Color(255, 0, 31), boxx, 592);
			
			/*活动icon*/
			ImageUtil.drawImageCf("/watch/qrcode.png", g, alpha, 294, 902,160, 160);
			
			g.dispose();
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 生成图片
			ImageIO.write(buffImg, "JPG", bos);
			
			webUploadResult = new WebUploadSupport().remoteUpload("crossfit", "watch.jpg", bos.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return webUploadResult;
		
	}

}
