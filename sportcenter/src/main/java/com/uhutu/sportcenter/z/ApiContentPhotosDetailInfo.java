package com.uhutu.sportcenter.z;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentPhotosDetail;
import com.uhutu.sportcenter.z.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.z.result.ApiContentPhotosResult;
import com.uhutu.zoocom.root.RootApiBase;

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
	private UserServiceFactory userServiceFactory;
	
	@Override
	protected ApiContentPhotosResult process(ApiContentPhotosInput input) {
		
		ApiContentPhotosResult result = new ApiContentPhotosResult();
		
		CnContentBasicinfo cnContentBasicinfo = serviceFactory.getContentBasicinfoService().queryByCode(input.getContent_code());
		
		if(cnContentBasicinfo != null){
			
			BeanUtils.copyProperties(cnContentBasicinfo, result.getContentBasicInfo());
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(cnContentBasicinfo.getAuthor());
			
			if(ucUserinfoExt != null){
				
				result.getContentBasicInfo().setNickName(ucUserinfoExt.getNickName());
				
				result.getContentBasicInfo().setAboutHead(ucUserinfoExt.getAboutHead());
				
			}
			
			List<CnContentPhotos> cnContentPhotos = serviceFactory.getContentPhotosService().queryByContentCode(input.getContent_code());
			
			List<ContentPhotosDetail> cnContentPhotosDetails = new ArrayList<ContentPhotosDetail>();
			
			if(cnContentPhotos != null){
				
				cnContentPhotos.forEach( entity -> {
					
					ContentPhotosDetail contentPhotosDetail = new ContentPhotosDetail();
					
					BeanUtils.copyProperties(entity, contentPhotosDetail);
					
					cnContentPhotosDetails.add(contentPhotosDetail);
					
				} );
				
				result.setContentPhotosDetails(cnContentPhotosDetails);
				
			}
			
			
			
		}else{
			
			result.setStatus(0);
			
			result.setError("此内容信息不存在");
			
		}
		

		return result;
	}

}
