package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.APiVideoListInput;
import com.uhutu.sportcenter.z.result.APiVideoListResult;
import com.uhutu.zoocom.root.RootApiForMember;

/**
 * 视频列表
 * 
 * @author xiegj
 * 
 */
@Service
public class APiVideoList extends RootApiForMember<APiVideoListInput, APiVideoListResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	protected APiVideoListResult process(APiVideoListInput input) {

		APiVideoListResult sportingMomentsResult = new APiVideoListResult();

		List<CnContentBasicinfo> contentBasicInfos = new ArrayList<CnContentBasicinfo>();
		QueryConditions queryConditions = new QueryConditions();
		queryConditions.setConditionEqual("contentType", "dzsd4107100110030001");
		queryConditions.setConditionEqual("status", "dzsd4699100110010001");
		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10,
				queryConditions);
		contentBasicInfos = page.getContent();
		if (page.hasNext()) {
			sportingMomentsResult.setNextPageFlag(true);
		} else {
			sportingMomentsResult.setNextPageFlag(false);
		}
		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();
		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {
			if (contentBasicInfo != null) {
				ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();
				BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
				sportingMoment
						.setFavorFlag(ContentComponent.lightFavor(sportingMoment.getCode(), input.getZoo().getToken()));
				if (StringUtils.isNotBlank(sportingMoment.getCover()) && input.getWidth() > 0) {
					if (input.getWidth() >= 750) {
						sportingMoment.setCover(sportingMoment.getCover() + "-w1242.jpg");
					} else {
						sportingMoment.setCover(sportingMoment.getCover() + "-w750.jpg");
					}
				}
				sportingMoment.setPublishTimeStr("MM-dd HH:mm");
				int remarkNum = remarkServiceFactory.getContentRemarkService().queryCount(sportingMoment.getCode(),
						RemarkEnum.FLAG_ENABLE.getCode());
				sportingMoment
						.setMakeFlag(ContentComponent.makeFlag(sportingMoment.getCode(), input.getZoo().getToken()));
				sportingMoment.setRemarkNum(remarkNum);
				String title = sportingMoment.getTitle();
				title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
				sportingMoment.setTitle(title);
				sports.add(sportingMoment);
			}
		}
		sportingMomentsResult.setMoments(sports);
		return sportingMomentsResult;
	}

}
