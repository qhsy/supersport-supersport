package com.uhutu.sportcenter.z.api.live;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentWorth;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiStartLiveInput;
import com.uhutu.sportcenter.z.result.ApiStartLiveResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 开始直播
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiStartLive extends RootApiToken<ApiStartLiveInput, ApiStartLiveResult> {
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiStartLiveResult process(ApiStartLiveInput input) {
		
		ApiStartLiveResult startLiveResult = new ApiStartLiveResult();
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("code", input.getCode());
		
		mWhereMap.put("chatCode", input.getChatCode());
		
		mWhereMap.put("status", ContentEnum.LIVEING.getCode());
		
		int count = JdbcHelper.count(CnLiveVideoDetail.class, "", mWhereMap);
		
		if(count > 0){
			
			startLiveResult.setError("此房间正在直播中");
			
			startLiveResult.setStatus(-1);
			
		}else{
			
			CnLiveVideoDetail liveVideoDetail = new CnLiveVideoDetail();
			
			BeanUtils.copyProperties(input, liveVideoDetail);
			
			liveVideoDetail.setUserCode(upUserCode());
			
			liveVideoDetail.setStatus(ContentEnum.LIVEING.getCode());
			
			liveVideoDetail.setCreateTime(DateHelper.upDate(new Date()));
			
			/*根据产品需求添加*/
			String contentCode = updateContent(liveVideoDetail);
			
			liveVideoDetail.setContentCode(contentCode);
			
			JdbcHelper.insert(liveVideoDetail);			
			
			updateContentWorth(contentCode);
			
		}
		
		return startLiveResult;
	}
	
	/**
	 * 直播详情
	 * @param liveVideoDetail
	 */
	public String updateContent(CnLiveVideoDetail liveVideoDetail){
		
		CnContentBasicinfo basicinfo = new CnContentBasicinfo();
		
		basicinfo.setAuthor(upUserCode());
		
		basicinfo.setBusiType(ContentEnum.article.getCode());
		
		basicinfo.setContentType(ContentEnum.TYPE_LIVE.getCode());
		
		basicinfo.setCover(liveVideoDetail.getCover());
		
		if(StringUtils.isNotBlank(liveVideoDetail.getAddressName())){
			
			basicinfo.setLocaltionName(liveVideoDetail.getAddressName());
			
		}
		
		if(StringUtils.isNotBlank(liveVideoDetail.getLatitude()) && StringUtils.isNotBlank(liveVideoDetail.getLongitude())){
			
			String location = liveVideoDetail.getLatitude()+","+liveVideoDetail.getLongitude();
			
			basicinfo.setLocation(location);
			
		}
		
		basicinfo.setPublishTime(new Date());
		
		basicinfo.setStatus(ContentEnum.normal.getCode());
		
		basicinfo.setTagCode(liveVideoDetail.getTagCode());
		
		basicinfo.setTitle(liveVideoDetail.getTitle());
		
		CnContentDetail cnContentDetail = new CnContentDetail();
		
		cnContentDetail.setContent(liveVideoDetail.getCode());
		
		basicinfo.setShareScope("dzsd4699100110010001");
		
		contentServiceFactory.getContentBasicinfoService().save(basicinfo);
		
		cnContentDetail.setCode(basicinfo.getCode());
		
		contentServiceFactory.getContentDetailService().save(cnContentDetail);		
		
		return basicinfo.getCode();
		
	}
	
	public void updateContentWorth(String contentCode){
		
		CnContentWorth contentWorth = new CnContentWorth();
		
		contentWorth.setContentCode(contentCode);
		
		contentWorth.setMark("dzsd4107100110100001");
		
		contentWorth.setSort(0);
		
		contentWorth.setType("");
		
		contentWorth.setZc(new Date());
		
		JdbcHelper.insert(contentWorth);
		
		
	}

}
