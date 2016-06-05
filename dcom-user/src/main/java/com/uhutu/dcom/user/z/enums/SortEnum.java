package com.uhutu.dcom.user.z.enums;

/**
 * 排名图片枚举
 * @author 逄小帅
 *
 */
public enum SortEnum {
	
	FIRST(1,""),
	
	TWO(2,""),
	
	THIRD(3,""),
	
	FOUR(4,""),
	
	FIVE(5,""),
	
	SIX(6,""),
	
	SEVEN(7,""),
	
	EIGHT(8,""),
	
	NINE(9,""),
	
	TEN(10,"");
	
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
