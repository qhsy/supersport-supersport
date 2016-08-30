package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.ContentPhotosDetail;
import com.uhutu.sportcenter.z.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.z.result.ApiContentPhotosResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.io.ImageThumb;

/**
 * 图集详情接口
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiContentPhotosDetailInfo extends RootApiBase<ApiContentPhotosInput, ApiContentPhotosResult> {

	@Autowired
	private ContentServiceFactory serviceFactory;

	@Autowired
	private UserInfoSupport userInfoSupport;

	@Autowired
	private ContentLabelServiceFactory labelServiceFacotry;

	@Override
	protected ApiContentPhotosResult process(ApiContentPhotosInput input) {

		ApiContentPhotosResult result = new ApiContentPhotosResult();

		CnContentBasicinfo cnContentBasicinfo = serviceFactory.getContentBasicinfoService()
				.queryByCode(input.getContent_code());

		if (cnContentBasicinfo != null) {

			BeanUtils.copyProperties(cnContentBasicinfo, result.getContentBasicInfo());

			UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(cnContentBasicinfo.getAuthor());

			UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(cnContentBasicinfo.getAuthor());

			if (ucUserinfoExt != null) {

				result.getContentBasicInfo().getUserBasicInfo().setNickName(ucUserinfoExt.getNickName());

				result.getContentBasicInfo().getUserBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());

			}

			if (ucUserinfo != null) {

				result.getContentBasicInfo().getUserBasicInfo().setType(ucUserinfo.getType());

				result.getContentBasicInfo().getUserBasicInfo().setUserCode(ucUserinfo.getCode());

			}

			List<CnContentPhotos> cnContentPhotos = serviceFactory.getContentPhotosService()
					.queryByContentCode(input.getContent_code());

			result.getContentBasicInfo()
					.setTags(labelServiceFacotry.getContentLabelService().getLabels(cnContentBasicinfo.getTagCode()));
			
			result.getContentBasicInfo().setFavorFlag(
					ContentComponent.lightFavor(result.getContentBasicInfo().getCode(), input.getZoo().getToken()));
			
			result.getContentBasicInfo().setPraiseNum(ContentComponent.praiseNum(cnContentBasicinfo.getCode()));

			List<ContentPhotosDetail> cnContentPhotosDetails = new ArrayList<ContentPhotosDetail>();

			if (cnContentPhotos != null) {

				result.setTotalCount(cnContentPhotos.size());

				cnContentPhotos.forEach(entity -> {

					ContentPhotosDetail contentPhotosDetail = new ContentPhotosDetail();

					BeanUtils.copyProperties(entity, contentPhotosDetail);

					if (StringUtils.isNotBlank(contentPhotosDetail.getPicture())) {

						ImageThumb thumb = ImageHelper.upThumbWithHeight(contentPhotosDetail.getPicture(), 0);

						contentPhotosDetail.setThumb(thumb);

					}

					cnContentPhotosDetails.add(contentPhotosDetail);

				});

				result.setContentPhotosDetails(cnContentPhotosDetails);

			}

		} else {

			result.setStatus(0);

			result.setError("此内容信息不存在");

		}

		return result;
	}

}
