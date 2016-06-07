package com.uhutu.dcom.user.z.enums;

/**
 * 排名图片枚举
 * @author 逄小帅
 *
 */
public enum SortEnum {
	
	ZERO(0,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-27-44/da15b559f5154706826de98825251925.png_g_t2606_w100_h9999.png"),
	
	FIRST(1,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-14-42/dbcf97df6aaa4c80b4bb8984bd0cd29f.png_g_t2606_w100_h9999.png"),
	
	TWO(2,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-25-43/53616ccf32b146099a27f5e4bdaed7fc.png_g_t2606_w100_h9999.png"),
	
	THIRD(3,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-25-44/d41b63e5576a428aa31b63446b40ddf3.png_g_t2606_w100_h9999.png"),
	
	FOUR(4,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-27-42/b5d8659ae17944508b81f10bc7a79793.png_g_t2606_w100_h9999.png"),
	
	FIVE(5,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-25-43/91c33ddbbb764794a513e02d7969d5af.png_g_t2606_w100_h9999.png"),
	
	SIX(6,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-26-43/6041ae17cf6748928aea443b30bf5951.png_g_t2606_w100_h9999.png"),
	
	SEVEN(7,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-25-42/008c619a098544e39a4060f42e452c33.png_g_t2606_w100_h9999.png"),
	
	EIGHT(8,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-27-44/b104f2c972c6498fba34783ae0bb0c32.png_g_t2606_w100_h9999.png"),
	
	NINE(9,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-26-43/a1b597e0772d40feb4df66823ef0293a.png_g_t2606_w100_h9999.png"),
	
	TEN(10,"http://img-cdn.bigtiyu.com/gm/wsc/sport/2735f/s-50-44/165c3ba1d4444e5aa0d6a9b13fa25b70.png_g_t2606_w100_h9999.png");
	
	private int rank;
	
	private String picUrl;
	
	SortEnum(int rank,String picUrl){
		
		this.rank = rank;
		
		this.picUrl = picUrl;
		
	}

	public int getRank() {
		return rank;
	}

	public String getPicUrl() {
		return picUrl;
	}
	
	/**
	 * 根据名次获取对应信息
	 * @param rank
	 * 		名次
	 * @return 名次枚举
	 */
	public static SortEnum getByRank(int rank){
		
		SortEnum[] array = SortEnum.values();
		
		for(SortEnum sortEnum : array){
			
			if(sortEnum.getRank() == rank){
				
				return sortEnum;
				
			}
			
		}
		
		return null;
		
	}

}
