package com.uhutu.dcom.answer.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问题信息
 * 
 * @author 逄小帅
 *
 */
//@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwQuestionInfo extends BaseEntity {

	@ZooData(name = "问题编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "问题内容")
	@Column(length = 255)
	private String content;

	@ZooData(name = "提问人", element = DefineWebElement.Model, inc = { DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length = 50)
	private String questionUserCode;

	@ZooData(name = "回答人", element = DefineWebElement.Model, inc = { DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length = 50)
	private String answerUserCode;

	@ZooData(name = "提问金额(RMB)", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal money;

	@ZooData(name = "偷听金额(RMB)", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal sellMoney;

	@ZooData(name = "状态", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define
			+ "=dzsd488810011001" }, demo = "dzsd4888100110010001:待回答,dzsd4888100110010002:已回答,dzsd4888100110010003:已拒绝回答,dzsd4888100110010004:到期未答,dzsd4888100110010005:已撤回")
	@Column(length = 50)
	private String status;

	@ZooData(name = "分享范围", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define
			+ "=dzsd488810011002" }, demo = "dzsd4888100110020001:私密,dzsd4888100110020002:公开")
	@Column(length = 50)
	private String scope;

	@ZooData(name = "语音路径", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 500)
	private String url;

	@ZooData(name = "语音长度(秒)", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private int lengh;

	@ZooData(name = "提问时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 50)
	private String questionTime;

	@ZooData(name = "回答时间", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 50)
	private String answerTime;

	@ZooData(name = "已收听数", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private long listen;

	@ZooData(name = "已赞数量", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private long love;

	@ZooData(name = "提问者分层金额(RMB)", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal askAmount;

	@ZooData(name = "回答者分层金额(RMB)", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal answerAmount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQuestionUserCode() {
		return questionUserCode;
	}

	public void setQuestionUserCode(String questionUserCode) {
		this.questionUserCode = questionUserCode;
	}

	public String getAnswerUserCode() {
		return answerUserCode;
	}

	public void setAnswerUserCode(String answerUserCode) {
		this.answerUserCode = answerUserCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getSellMoney() {
		return sellMoney;
	}

	public void setSellMoney(BigDecimal sellMoney) {
		this.sellMoney = sellMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuestionTime() {
		return questionTime;
	}

	public void setQuestionTime(String questionTime) {
		this.questionTime = questionTime;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public long getListen() {
		return listen;
	}

	public void setListen(long listen) {
		this.listen = listen;
	}

	public long getLove() {
		return love;
	}

	public void setLove(long love) {
		this.love = love;
	}

	public int getLengh() {
		return lengh;
	}

	public void setLengh(int lengh) {
		this.lengh = lengh;
	}

	public BigDecimal getAskAmount() {
		
		if(askAmount == null){
			
			askAmount = BigDecimal.ZERO;
			
		}
		
		return askAmount;
	}

	public void setAskAmount(BigDecimal askAmount) {
		this.askAmount = askAmount;
	}

	public BigDecimal getAnswerAmount() {
		
		if(answerAmount == null){
			
			answerAmount = BigDecimal.ZERO;
			
		}
		
		return answerAmount;
	}

	public void setAnswerAmount(BigDecimal answerAmount) {
		this.answerAmount = answerAmount;
	}

}
