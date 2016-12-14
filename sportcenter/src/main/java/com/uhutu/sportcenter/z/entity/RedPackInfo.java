package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 红包信息
 * 
 * @author 逄小帅
 *
 */

public class RedPackInfo{

	@ApiModelProperty(value = "红包编号")
	private String code;

	@ApiModelProperty(value = "红包icon")
	private String pic;

	@ApiModelProperty(value = "红包金额")
	private BigDecimal money;

	@ApiModelProperty(value = "排序")
	private int sort;

	@ApiModelProperty(value = "红包状态")
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
