package com.uhutu.dcom.order.enumer;

/**
 * 订单枚举
 * @author 逄小帅
 *
 */
public enum OrderEnum {
	
	/**已支付*/
	STATUS_PAYED("dzsd4112100110030002","已支付"),
	
	/**未付款*/
	STATUS_UNPAYED("dzsd4112100110030001","未付款");
	
	
	OrderEnum(String code, String text) {
		
		this.code = code;
		
		this.text = text;
		
	}
	
	/*订单状态*/
	private String code;
	
	/*展示文本*/
	private String text;

	public String getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

}
