package com.uhutu.sportcenter.z.api.extend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.sportcenter.z.input.ApiSignPhotoInput;
import com.uhutu.sportcenter.z.result.ApiSignPhotoResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 报名证件
 * 
 * @author xiegj
 */
@Service
public class ApiSignPhoto extends RootApiToken<ApiSignPhotoInput, ApiSignPhotoResult> {

	protected ApiSignPhotoResult process(ApiSignPhotoInput input) {
		ApiSignPhotoResult result = new ApiSignPhotoResult();
		
		List<UcSignInfo> signInfos = new ArrayList<UcSignInfo>();
		
		List<UcSignInfo> li = JdbcHelper.queryForList(UcSignInfo.class, "", "",
				" status=:status and userCode=:userCode and type in ('dzsd4107100510020001','dzsd4107100510020002')",
				MapHelper.initMap("userCode", upUserCode(), "status", "dzsd4112100110030002"));
		
		if (li != null && li.size() > 0) {
			for (int i = 0; i < li.size(); i++) {
				signInfos.add(li.get(i));// 已报名
			}
		}
		List<UcSignInfo> li2 = JdbcHelper.queryForList(UcSignInfo.class, "", "",
				" status=:status and userCode=:userCode and type ='dzsd4107100510020003'",
				MapHelper.initMap("userCode", upUserCode(), "status", "dzsd4112100110030002"));
		if (li2 != null && li2.size() > 0) {
			signInfos.add(li2.get(0));// 已报名
		}
		List<UcSignInfo> li3 = JdbcHelper.queryForList(UcSignInfo.class, "", "",
				"  userCode=:userCode and type ='dzsd4107100510020004'", MapHelper.initMap("userCode", upUserCode()));
		if (li3 != null && li3.size() > 0) {
			signInfos.add(li3.get(0));// 已报名
		}
		sort(signInfos);
		
		for (UcSignInfo ucSignInfo : signInfos) {
			
			if(ucSignInfo != null){
				
				result.getLi().add(ucSignInfo.getPicUrl());
				
			}
			
		}
		
		return result;
	}
	
	public void sort(List<UcSignInfo> infos){
		
		if(infos != null){
			
			Collections.sort(infos, new Comparator<UcSignInfo>() {

				@Override
				public int compare(UcSignInfo o1, UcSignInfo o2) {

					if (o1 != null && o2 != null) {

						int result = o1.getZc().compareTo(o2.getZc());

						return 0 - result;

					}

					return 0;
				}
			});
			
		}
		
	}

}
