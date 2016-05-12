package com.uhutu.sportcenter.z.api.remark;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiPublishRemarkInput;
import com.uhutu.sportcenter.z.result.ApiPublishRemarkResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 评论发布
 * @author 逄小帅
 *
 */
@Component
public class ApiPublishRemark extends RootApiBase<ApiPublishRemarkInput, ApiPublishRemarkResult> {
	
	@Autowired
	private ContentRemarkServiceFactory servieFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiPublishRemarkResult process(ApiPublishRemarkInput input) {
		
		ApiPublishRemarkResult remarkResult = new ApiPublishRemarkResult();
		
		CnContentRemark cnContentRemark = new CnContentRemark();
		
		BeanUtils.copyProperties(input, cnContentRemark);
		
		cnContentRemark.setAuthor(input.getZoo().getToken());
		
		initParentInfo(cnContentRemark);
		
		return remarkResult;
		
	}
	
	/**
	 * 初始化父级评论信息
	 * @param parentCode
	 */
	public void initParentInfo(CnContentRemark contentRemark){
		
		CnContentRemark parentContentRemark = null;
		
		String parentCode = contentRemark.getParentCode();
		
		if(StringUtils.isNotBlank(parentCode)){
			
			parentContentRemark = servieFactory.getContentRemarkService().queryByCode(parentCode);
			
			if(parentContentRemark != null){
				
				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(parentContentRemark.getAuthor());
				
				Optional<UcUserinfoExt> userOptional = Optional.ofNullable(ucUserinfoExt);
				
				if(userOptional.isPresent()){
					
					contentRemark.setReplyName(ucUserinfoExt.getNickName());
					
				}		
				
				
			}
			
		}
		
		
		
	}


}
