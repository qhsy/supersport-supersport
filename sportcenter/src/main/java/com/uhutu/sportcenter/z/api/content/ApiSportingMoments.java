package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.z.result.ApiSportingMomentsResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiForMember;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMoments extends RootApiForMember<ApiSportingMomentsInput, ApiSportingMomentsResult> {

	@Autowired
	private ContentBasicinfoServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {		

		ApiSportingMomentsResult sportingMomentsResult = new ApiSportingMomentsResult();
		
		List<CnContentBasicinfo> contentBasicInfos = new ArrayList<CnContentBasicinfo>();
		
		if ("2".equals(input.getType()) && StringUtils.isNotBlank(upUserCode())) {// 我关注的人
			
			if(StringUtils.isNotEmpty(input.getZoo().getToken())){
				
				String userCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
				
				if(StringUtils.isNotEmpty(userCode)){
					
					MDataMap dataMap = MapHelper.initMap("busiType",ContentEnum.sportmoment.getCode(),"status","dzsd4699100110010001","shareScope","dzsd4699100110010001");
					
					String sqlWhere = initSql(dataMap);
					
					sqlWhere = sqlWhere + "EXISTS (select 1 from uc_attention_info where attention = '"+userCode+"' and be_attention = author and status='1')";
								
					int istart = (input.getPagination()-1)*10;
					
					contentBasicInfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "", sqlWhere, new MDataMap(), istart, 10);
					
					int count = JdbcHelper.count(CnContentBasicinfo.class, sqlWhere, new MDataMap());
					
					PageInfo pageInfo = new PageInfo(count, input.getPagination(), 10);
					
					sportingMomentsResult.setNextPageFlag(pageInfo.hasNext());
					
				}
				
			}
			
			
			
			
		} else if ("3".equals(input.getType())) {// 达人
			
			
			MDataMap dataMap = MapHelper.initMap("busiType",ContentEnum.sportmoment.getCode(),"status","dzsd4699100110010001","shareScope","dzsd4699100110010001");
			
			String sqlWhere = initSql(dataMap);
			
			sqlWhere = sqlWhere + " EXISTS (select 1 from uc_userinfo ui where code = author and type='dzsd4107100310010002')";
						
			int istart = (input.getPagination()-1)*10;
			
			contentBasicInfos = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "", sqlWhere, new MDataMap(), istart, 10);
			
			int count = JdbcHelper.count(CnContentBasicinfo.class, sqlWhere, new MDataMap());
			
			PageInfo pageInfo = new PageInfo(count, input.getPagination(), 10);
			
			sportingMomentsResult.setNextPageFlag(pageInfo.hasNext());
			
			
			
		}else{
			
			QueryConditions queryConditions = new QueryConditions();
			
			queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
			queryConditions.setConditionEqual("status", "dzsd4699100110010001");
			queryConditions.setConditionEqual("shareScope", "dzsd4699100110010001");
			
			Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10,
					queryConditions);

			contentBasicInfos = page.getContent();
			
			if (page.hasNext()) {

				sportingMomentsResult.setNextPageFlag(true);

			} else {

				sportingMomentsResult.setNextPageFlag(false);

			}
			
		}
		

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

			if (contentBasicInfo != null) {

				ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

				BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

				UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicInfo.getAuthor());

				UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(contentBasicInfo.getAuthor());

				if (ucUserinfoExt != null) {

					sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());

					sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

				}

				if (ucUserinfo != null) {

					sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());

					sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());

				}

				sportingMoment.setTagName(
						labelServiceFactory.getContentLabelService().initTagName(sportingMoment.getTagCode()));

				sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), input.getWidth()));

				sportingMoment.setPublishTimeStr("MM-dd HH:mm");

				sports.add(sportingMoment);

			}

		}

		sportingMomentsResult.setMoments(sports);

		return sportingMomentsResult;
	}
	
	public String initSql(MDataMap mDataMap){
		
		StringBuffer buffer = new StringBuffer();
		
		mDataMap.keySet().forEach( key -> {
			
			buffer.append(key).append("='").append(mDataMap.get(key)).append("' and ");
			
		});
		
		return buffer.toString();
		
	}

}
