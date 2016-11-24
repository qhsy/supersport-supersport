package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.dcom.content.z.entity.CnContentType;
import com.uhutu.dcom.content.z.entity.CnContentWorth;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForTypeApi;
import com.uhutu.sportcenter.z.input.ApiContentTypeInput;
import com.uhutu.sportcenter.z.result.ApiContentTypeResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 内容分类
 * 
 * @author xiegj
 *
 */
@Service
public class ApiContentType extends RootApiBase<ApiContentTypeInput, ApiContentTypeResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Override
	protected ApiContentTypeResult process(ApiContentTypeInput input) {

		ApiContentTypeResult result = new ApiContentTypeResult();
		if (input.getNum() == 1) {
			result.setTypes(getTypes(input.getWidth()));
		}
		result.setMoments(getInfos(input.getWidth() * 2, input.getNum()));
		List<CnContentWorth> ws = JdbcHelper.queryForList(CnContentWorth.class, "", "sort desc", "", null,
				input.getNum() * 10, 10);
		if (ws != null && ws.size() > 0) {
			result.setNextFlag(true);
		}
		return result;

	}

	private List<ContentBasicinfoForTypeApi> getInfos(int width, int num) {
		List<ContentBasicinfoForTypeApi> result = new ArrayList<ContentBasicinfoForTypeApi>();
		StringBuffer str = new StringBuffer();
		List<CnContentWorth> ws = JdbcHelper.queryForList(CnContentWorth.class, "", "sort desc", "", null,
				(num - 1) * 10, 10);
		Map<String, String> map = new HashMap<String, String>();
		if (ws != null && !ws.isEmpty() && ws.size() > 0) {
			for (int i = 0; i < ws.size(); i++) {
				if (i == ws.size() - 1) {
					str.append("'" + ws.get(i).getContentCode() + "'");
				} else {
					str.append("'" + ws.get(i).getContentCode() + "',");
				}
				map.put(ws.get(i).getContentCode(), ws.get(i).getMark());
			}

			if (StringUtils.isNotBlank(str)) {
				List<CnContentBasicinfo> basics = JdbcHelper.queryForList(CnContentBasicinfo.class, "", "",
						"status='dzsd4699100110010001' and shareScope='dzsd4699100110010001' and code in("
								+ str.toString() + ")",
						new MDataMap());
				for (CnContentBasicinfo contentBasicInfo : basics) {
					if (contentBasicInfo != null) {
						ContentBasicinfoForTypeApi sportingMoment = new ContentBasicinfoForTypeApi();
						BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
						UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(contentBasicInfo.getAuthor());
						UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(contentBasicInfo.getAuthor());
						if (ucUserinfoExt != null) {
							sportingMoment.getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
							sportingMoment.getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());
							sportingMoment.getUserBasicInfo().setTitle(ucUserinfoExt.getTitle());
						}
						if (ucUserinfo != null) {
							sportingMoment.getUserBasicInfo().setUserCode(ucUserinfo.getCode());
							sportingMoment.getUserBasicInfo().setType(ucUserinfo.getType());
						}
						sportingMoment.setCover(ImageHelper.upImageThumbnail(sportingMoment.getCover(), width));
						sportingMoment.setPublishTimeStr("MM-dd HH:mm");
						CnContentReadCount contentReadCount = JdbcHelper.queryOne(CnContentReadCount.class,
								"contentCode", sportingMoment.getCode());
						if (contentReadCount != null) {
							sportingMoment.setReadNum(contentReadCount.getCount());
						}
						if ("dzsd4107100110030004".equals(sportingMoment.getContentType())) {
							CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code",
									sportingMoment.getCode());
							if (detail != null && StringUtils.isNotBlank(detail.getContent())) {
								sportingMoment.setTitle(detail.getContent());
							}
						}
						int remarkNum = remarkServiceFactory.getContentRemarkService()
								.queryCount(sportingMoment.getCode(), RemarkEnum.FLAG_ENABLE.getCode());
						sportingMoment.setRemarkNum(remarkNum);
						int praiseNum = serviceFactory.getSupportPraiseService()
								.queryCountByCode(sportingMoment.getCode(), ContentEnum.FAVOR_STATUS_YES.getCode());
						sportingMoment.setPraiseNum(praiseNum);
						String title = sportingMoment.getTitle();
						title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiRecovery(title);
						sportingMoment.setTitle(title);
						sportingMoment.setMark(map.get(sportingMoment.getCode()));
						if (StringUtils.isNotBlank(sportingMoment.getCode())) {
							CnContentDetail detail = JdbcHelper.queryOne(CnContentDetail.class, "code",
									sportingMoment.getCode());
							if (detail != null) {
								sportingMoment.setDetail(detail);
							}
						}
						result.add(sportingMoment);
					}
				}
			}
		}
		return result;
	}

	private List<CnContentType> getTypes(int width) {
		List<CnContentType> types = JdbcHelper.queryForList(CnContentType.class, "", "sort desc", "status = '1'", null);
		if (types != null) {
			for (int i = 0; i < types.size(); i++) {
				types.get(i).setCover(ImageHelper.upImageThumbnail(types.get(i).getCover(), width));
			}
		}
		return types;
	}
}
