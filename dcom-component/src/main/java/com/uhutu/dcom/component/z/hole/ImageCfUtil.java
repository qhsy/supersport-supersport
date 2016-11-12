package com.uhutu.dcom.component.z.hole;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import com.uhutu.dcom.component.z.util.ImageUtil;
import com.uhutu.zoocom.file.FileUploadResult;
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
	public static FileUploadResult makeImagePerson(String name,String box,String typeName,String code) {	
		
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
			
			/*头像icon*/
			ImageUtil.drawImageCf("/person/head.jpeg", g, alpha, 196, 150, 364, 364);
			
			/*throwdown 水印*/
			ImageUtil.drawImageCf("/person/throwdown.png", g, alpha, 52, 120, 308, 264);			
	        
			/*姓名*/
	        ImageUtil.drawStrCf(name, g, 0, 48, 306, 576);
	        /*所属box*/
	        ImageUtil.drawStrCf(box, g, 0, 32, 286, 638);
	        /*参赛码*/
	        ImageUtil.drawStrCf(typeName+"  参赛码："+code, g, 0, 36, 162, 690);
	        /*宣传语*/
	        ImageUtil.drawImageCf("/person/kill.png", g, alpha, 70, 758, 594, 66);
	        /*group icon*/
	        ImageUtil.drawImageCf("/person/group.png", g, alpha, 50, 838, 424, 250);
			
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
			ImageUtil.drawImageCf("/group/corplogo.png", g, alpha, 101, 9, 51, 50);
			
			/*果冻体育icon*/
			ImageUtil.drawImageCf("/group/gdlogo.png", g, alpha, 160, 23, 102, 24);
			
			/*group icon*/
			ImageUtil.drawImageCf("/group/grouplogo.png", g, alpha, 50, 105, 276, 164);		
	        
			/*姓名*/
	        ImageUtil.drawStrCf(name, g, 0, 24, 130, 303);
	        /*所属box*/
	        ImageUtil.drawStrCf(box, g, 0, 16, 143, 334);
	        /*参赛码*/
	        ImageUtil.drawStrCf(typeName+"  参赛码："+code, g, 0, 18, 81, 370);
	        
	        /*宣传语*/
	        ImageUtil.drawImageCf("/group/kill.png", g, alpha, 43, 406, 297, 33);
			
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

}
