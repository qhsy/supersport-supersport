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
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetailForApi;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForTypeApi;
import com.uhutu.sportcenter.z.input.ApiContentWorthInput;
import com.uhutu.sportcenter.z.result.ApiContentWorthResult;
import com.uhutu.zoocom.helper.MapHelper;
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
public class ApiContentWorth extends RootApiBase<ApiContentWorthInput, ApiContentWorthResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentRemarkServiceFactory remarkServiceFactory;

	@Override
	protected ApiContentWorthResult process(ApiContentWorthInput input) {

		ApiContentWorthResult result = new ApiContentWorthResult();
		result.setMoments(getInfos(input.getWidth(), input.getNum(), input.getCode()));
		CnContentType ct = JdbcHelper.queryOne(CnContentType.class, "code", input.getCode());
		if (ct != null) {
			result.setName(ct.getName());
			List<CnContentWorth> ws = JdbcHelper.queryForList(CnContentWorth.class, "", "sort desc",
					" type like '%" + input.getCode() + "%' ", null, input.getNum() * 10, 10);
			if (ws != null && ws.size() > 0) {
				result.setNextFlag(true);
			}
		}
		return result;

	}

	private List<ContentBasicinfoForTypeApi> getInfos(int width, int num, String code) {
		List<ContentBasicinfoForTypeApi> result = new ArrayList<ContentBasicinfoForTypeApi>();
		StringBuffer str = new StringBuffer();
		List<CnContentWorth> ws = JdbcHelper.queryForList(CnContentWorth.class, "", "sort desc",
				" type like '%" + code + "%' ", null, (num - 1) * 10, 10);
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
						if ("dzsd4107100110030007".equals(sportingMoment.getContentType())) {
							CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", " zc desc ",
									" user_code=:user_code",
									MapHelper.initMap("user_code", sportingMoment.getAuthor()));
							if (detail != null) {
								CnLiveVideoDetailForApi videoDetailForApi = new CnLiveVideoDetailForApi();
								BeanUtils.copyProperties(detail, videoDetailForApi);
								videoDetailForApi.setNickName(sportingMoment.getUserBasicInfo().getNickName());
								videoDetailForApi.setAboutHead(sportingMoment.getUserBasicInfo().getAboutHead());
								sportingMoment.setLiveVideoDetailForApi(videoDetailForApi);
							}
						}
						result.add(sportingMoment);
					}
				}
			}
		}
		return result;
	}
}
