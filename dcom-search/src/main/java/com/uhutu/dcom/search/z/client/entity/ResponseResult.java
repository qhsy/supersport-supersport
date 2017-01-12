package com.uhutu.dcom.search.z.client.entity;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.zoocom.model.MDataMap;

/**
 * 响应结果
 * @author 逄小帅
 *
 */
public class ResponseResult {
	
	/*查询耗时*/
	private String searchtime;
	
	/*引擎总结果数*/
	private int total;
	
	/*本次请求返回结果数*/
	private int num;
	
	/*本次请求返回最大结果数*/
	private int viewtotal;
	
	/*查询结果*/
	private List<MDataMap> items = new ArrayList<MDataMap>();

	public String getSearchtime() {
		return searchtime;
	}

	public void setSearchtime(String searchtime) {
		this.searchtime = searchtime;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getViewtotal() {
		return viewtotal;
	}

	public void setViewtotal(int viewtotal) {
		this.viewtotal = viewtotal;
	}


	public List<MDataMap> getItems() {
		return items;
	}

	public void setItems(List<MDataMap> items) {
		this.items = items;
	}

}
