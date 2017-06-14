package com.uhutu.sportcenter.z.api.live;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.dcom.content.z.entity.CnLiveMatchInfo;
import com.uhutu.dcom.content.z.entity.CnLiveMatchRel;
import com.uhutu.dcom.content.z.support.SpecialEffectSupport;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiLiveInfoInput;
import com.uhutu.sportcenter.z.result.ApiLiveInfoResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.user.UserCallFactory;

import io.swagger.annotations.ApiModel;

/**
 * 直播信息
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveInfo extends RootApiToken<ApiLiveInfoInput, ApiLiveInfoResult> {

	@Override
	protected ApiLiveInfoResult process(ApiLiveInfoInput input) {

		ApiLiveInfoResult result = new ApiLiveInfoResult();
		if (StringUtils.isNotBlank(input.getCode())) {

			CnLiveInfo liveInfo = JdbcHelper.queryOne(CnLiveInfo.class, "code", input.getCode());

			if (liveInfo != null && StringUtils.isNotEmpty(liveInfo.getUserCode())) {

				UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", liveInfo.getUserCode());
				UcUserinfo info = JdbcHelper.queryOne(UcUserinfo.class, "code", liveInfo.getUserCode());
				if (ext != null && info != null) {
					result.getUserBasicInfo().setAboutHead(ext.getAboutHead());
					result.getUserBasicInfo().setNickName(ext.getNickName());
					result.getUserBasicInfo().setTitle(ext.getTitle());
					result.getUserBasicInfo().setType(info.getType());
					result.getUserBasicInfo().setUserCode(ext.getUserCode());
				}
				result.setLiveInfo(liveInfo);
				List<CnLiveMatchRel> rels = JdbcHelper.queryForList(CnLiveMatchRel.class, "", "sort desc ", "",
						MapHelper.initMap("code", liveInfo.getCode()));
				StringBuffer str = new StringBuffer();
				if (rels != null && !rels.isEmpty() && rels.size() > 0) {
					for (int i = 0; i < rels.size(); i++) {
						if (i == rels.size() - 1) {
							str.append("'" + rels.get(i).getGameCode() + "'");
						} else {
							str.append("'" + rels.get(i).getGameCode() + "',");
						}
					}
				}
				if (StringUtils.isNotBlank(str)) {
					List<CnLiveMatchInfo> matchs = JdbcHelper.queryForList(CnLiveMatchInfo.class, "",
							" field(code," + str.toString() + ")", " code in(" + str.toString() + ")", new MDataMap());
					if (matchs != null && matchs.size() > 0) {
						result.setMatchs(matchs);
					}
				}
				ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
				cachedThreadPool.execute(new Runnable() {
					public void run() {
						SpecialEffectSupport.Instance().saveSpecialEffect(null, input.getCode(), new UserCallFactory()
								.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default));
					}
				});
				cachedThreadPool.shutdown();
			}

		}
		return result;
	}

}
