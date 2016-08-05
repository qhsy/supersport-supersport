package com.uhutu.dcom.component.z.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类
 * @author 逄小帅
 *
 */
public class CalendarUtil {
	
	/*五分钟*/
	public static long FIVE_MINUTES = 5*60;
	
	/*1小时*/
	public static long ONE_HOUR = 60*60;
	
	/*24小时*/
	public static long HOUR_24 = 24*60*60;	
	
	/**
	 * 格式化日期展示
	 * @param date
	 * 		日期
	 * @return 格式化后的日期
	 */
	public static String formateTip(Date date){
		
		String formateStr = "";
		
		Date currDate = new Date();
		
		long diff = (currDate.getTime() - date.getTime())/1000;
		
		if(diff < FIVE_MINUTES){
			
			formateStr = "刚刚";
			
		}else if(diff >= FIVE_MINUTES && diff <ONE_HOUR){
			
			long diffMinute = Math.round(diff/60);
			
			formateStr = diffMinute + "分钟前";
			
			
		}else if( diff >= ONE_HOUR && diff < HOUR_24){
			
			long diffHour = Math.round(diff/ONE_HOUR);
			
			formateStr = diffHour + "小时前";
			
		}else{
			
			Calendar currCalendar = Calendar.getInstance();
			
			currCalendar.setTime(currDate);
			
			int days = currCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			if(diff >= HOUR_24 && diff < days * HOUR_24){
				
				long diffDay = Math.round(diff/HOUR_24);
				
				formateStr = diffDay + "天前";
				
			}else{
				
				Calendar compareCalendar = Calendar.getInstance();
				
				compareCalendar.setTime(date);
				
				compareCalendar.add(Calendar.YEAR, 1);
				
				if(compareCalendar.compareTo(currCalendar) >= 0){
					
					formateStr = DateFormatUtils.format(date, "yyyy-MM-dd");
					
				}else{
					
					long diffMonth = Math.round(diff/28);
					
					formateStr = diffMonth + "月前";
					
				}
				
			}
			
			
			
		}
		
		return formateStr;
		
	}

}
