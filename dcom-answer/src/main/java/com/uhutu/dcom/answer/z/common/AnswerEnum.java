package com.uhutu.dcom.answer.z.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 问答枚举
 * @author 逄小帅
 *
 */
public enum AnswerEnum {
	
	STATUS_UNANSWER("dzsd4888100110010001","未回答"),
	
	STATUS_ANSWERED("dzsd4888100110010002","已回答"),
	
	STATUS_REANSWER("dzsd4888100110010003","决绝回答");
	
	/*编号*/
	private String code;
	
	/*文本*/
	private String text;
	
	private AnswerEnum(String code,String text) {
		this.code = code;
		this.text = text;
	}
	
	/**
	 * 根据编号获取文本
	 * @param code
	 * 		编码
	 * @return 文本
	 */
	public static String praseText(String code){
		
		String temp = "";
		
		for (AnswerEnum answerEnum : AnswerEnum.values()) {
			
			if(StringUtils.equals(answerEnum.getCode(), code)){
				
				temp = answerEnum.getText();
				
				break;
				
			}
			
		}
		
		return temp;
		
	}

	public String getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

}
