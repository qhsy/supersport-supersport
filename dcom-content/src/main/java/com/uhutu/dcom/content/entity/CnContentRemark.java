package com.uhutu.dcom.content.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 分类数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentRemark extends BaseEntity {

	@ZooData(name = "评价编号")
	private String code;
	
	@ZooData(name = "评论的内容编号")
	private String contentCode;
	
	@ZooData(name = "评价信息")
	private String remark;
	
	@ZooData(name = "评价人编号")
	private Date author;
	
	@ZooData(name = "回复的评论编号")
	private String parentCode;
	
	@ZooData(name = "内容状态")
	private String status;
	

}
