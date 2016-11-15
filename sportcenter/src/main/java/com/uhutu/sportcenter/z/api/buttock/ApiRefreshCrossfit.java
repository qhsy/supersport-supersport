package com.uhutu.sportcenter.z.api.buttock;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.hole.ImageCfUtil;
import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.sportcenter.z.input.ApiRefreshCrossfitInput;
import com.uhutu.sportcenter.z.result.ApiRefreshCrossfitResult;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 
 * @author 逄小帅
 *
 */
@Component
public class ApiRefreshCrossfit extends RootApiBase<ApiRefreshCrossfitInput, ApiRefreshCrossfitResult> {

	@Override
	protected ApiRefreshCrossfitResult process(ApiRefreshCrossfitInput input) {
		
		MDataMap mDataMap = new MDataMap();
		
		mDataMap.put("status", "dzsd4112100110030002");
		
		List<UcSignInfo> signInfos = JdbcHelper.queryForList(UcSignInfo.class, "", "", "", mDataMap);
		
		for (UcSignInfo ucSignInfo : signInfos) {
			
			if(ucSignInfo != null){
				
				if(StringUtils.equals(ucSignInfo.getType(), "dzsd4107100510020004")){
					
					FileUploadResult ft = ImageCfUtil.makeImageWatch(ucSignInfo.getCode());
					
					ucSignInfo.setPicUrl(ft.getFileUrl());
				}
				
				if(StringUtils.equals(ucSignInfo.getType(), "dzsd4107100510020003")){
					
					FileUploadResult ft = ImageCfUtil.makeImageGroup(ucSignInfo.getGroupName(), ucSignInfo.getBoxName(), "团队标准组",ucSignInfo.getGroupCode());
					
					ucSignInfo.setPicUrl(ft.getFileUrl());
				}
				
				if(StringUtils.equals(ucSignInfo.getType(), "dzsd4107100510020002")){
					
					FileUploadResult ft = ImageCfUtil.makeImagePerson(ucSignInfo.getName(), ucSignInfo.getBoxName(),"个人业余组", ucSignInfo.getCode(),ucSignInfo.getPhoto());
					
					ucSignInfo.setPicUrl(ft.getFileUrl());
				}
				
				if(StringUtils.equals(ucSignInfo.getType(), "dzsd4107100510020001")){
					
					FileUploadResult ft = ImageCfUtil.makeImagePerson(ucSignInfo.getName(), ucSignInfo.getBoxName(),"个人标准组", ucSignInfo.getCode(),ucSignInfo.getPhoto());
					
					ucSignInfo.setPicUrl(ft.getFileUrl());
				}
				
			}
			
			JdbcHelper.update(ucSignInfo, "pic_url", "za");
			
		}
		
		return new ApiRefreshCrossfitResult();
	}
	
	
	

}
