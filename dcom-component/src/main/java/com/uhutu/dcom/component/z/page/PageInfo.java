package com.uhutu.dcom.component.z.page;

import java.math.BigDecimal;

/**
 * 分页信息
 * @author 逄小帅
 *
 */
public class PageInfo {
	
	/*总的记录数*/
	private int total;
	
	/*当前页码*/
	private int pagination;
	
	/*总的页数*/
	private int pageSize;
	
	/*每页展示的数量*/
	private int pageNum;
	
	/**
	 * 分页信息
	 * @param total
	 * 		总数
	 * @param pagination
	 * 		页码
	 * @param pageNum
	 * 		每页展示数量
	 */
	public PageInfo(int total, int pagination, int pageNum) {
		
		setPageNum(pageNum);
		
		setPagination(pagination);
		
		setTotal(total);
		
	}
	
	/**
	 * 判断是否存在下一页
	 * @return
	 */
	public boolean hasNext(){
		
		boolean nextFlag = true;
		
		if(getPagination() >= getPageSize()){
			
			nextFlag = false;
			
		}
		
		return nextFlag;
		
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getPageSize() {
		
		if(getPageNum() > 0){
			
			BigDecimal totalDecimal = new BigDecimal(getTotal());
			
			BigDecimal pageDecimal = new BigDecimal(getPageNum());
			
			pageSize = totalDecimal.divide(pageDecimal, BigDecimal.ROUND_CEILING).intValue();
			
		}
		
		return pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
