package com.uhutu.sportcenter.z.api.donate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcDonateInfo;
import com.uhutu.dcom.user.z.entity.UcUserAlbum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserAlbum;
import com.uhutu.sportcenter.z.entity.UserDonateInfo;
import com.uhutu.sportcenter.z.entity.UserInfoExpertDetail;
import com.uhutu.sportcenter.z.input.ApiUserExpertDetailInput;
import com.uhutu.sportcenter.z.result.ApiUserExpertDetailResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.io.ImageThumb;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 达人用户详情信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUserExpertDetail extends RootApiBase<ApiUserExpertDetailInput, ApiUserExpertDetailResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Override
	protected ApiUserExpertDetailResult process(ApiUserExpertDetailInput input) {
		
		ApiUserExpertDetailResult result = new ApiUserExpertDetailResult();
		
		UcUserinfoExpert ucUxpert = userServiceFactory.getUserInfoExpertService().queryByCode(input.getUserCode());
		
		if(ucUxpert != null){
			
			UserInfoExpertDetail expertInfo = new UserInfoExpertDetail();
			
			BeanUtils.copyProperties(ucUxpert, expertInfo);
			
			expertInfo.setPowerStr(String.format("%,d", expertInfo.getPower()));
			
			result.setUserInfoExpert(expertInfo);
			
			result.setUserAlbum(initUserAlbum(input.getUserCode()));
			
			result.setUserDonateInfos(initUserDonateInfos(input.getUserCode(), input.getPagination()));
			
			if(StringUtils.isNotBlank(input.getZoo().getToken())){
				
				String supportUserCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
				
				result.setSupportPower(supportPower(supportUserCode, input.getUserCode()));
				
			}
			
		}else{
			
			result.inError(81100003);
			
		}		
		
		return result;
	}
	
	/**
	 * 初始用户相册
	 * @param userCode
	 * 		用户编号
	 * @return 用户相册集合
	 */
	public List<UserAlbum> initUserAlbum(String userCode){
		
		List<UserAlbum> userAlbums = new ArrayList<UserAlbum>();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("status", SystemEnum.YES.getCode());
		
		conditions.setConditionEqual("userCode", userCode);
		
		Page<UcUserAlbum> userAlbumPage = userServiceFactory.getUserAlbumService().queryPageByCondition(1, 10, conditions);
		
		userAlbumPage.getContent().forEach(album -> {
			
			UserAlbum userAlbum = new UserAlbum();
			
			BeanUtils.copyProperties(album, userAlbum);
			
			ImageThumb imageThumb = ImageHelper.upThumbWithHeight(userAlbum.getPicture(), 0);
			
			userAlbum.setWidth(imageThumb.getSourceWidth());
			
			userAlbum.setHeight(imageThumb.getSourceHeight());
			
			userAlbum.setIconUrl(ImageHelper.upImageThumbnail(userAlbum.getPicture(), 50));
			
			userAlbums.add(userAlbum);
			
		});
		
		return userAlbums;
		
	}
	
	/**
	 * 初始用户捐赠信息排行
	 * @param userCode
	 * 		用户编号
	 * @param pageNum
	 * 		当前页码
	 * @return 用户捐赠信息
	 */
	public List<UserDonateInfo> initUserDonateInfos(String userCode, int pageNum) {

		List<UserDonateInfo> userDonateInfos = new ArrayList<UserDonateInfo>();

		QueryConditions conditions = new QueryConditions();

		conditions.setConditionEqual("beSupportCode", userCode);

		Page<UcDonateInfo> donatePage = userServiceFactory.getUserDonateInfoService().queryPageByCondtions(pageNum, 5,
				conditions);
		
		donatePage.getContent().forEach(donateInfo -> {			
			
			UcUserinfoExt userinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(donateInfo.getSupportCode());
			
			UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(donateInfo.getSupportCode());
			
			if(userinfoExt != null && ucUserinfo != null){
				
				UserDonateInfo userDonateInfo = new UserDonateInfo();
				
				userDonateInfo.setTotalPower(donateInfo.getTotalPower());
				
				userDonateInfo.setAboutHead(userinfoExt.getAboutHead());
				
				userDonateInfo.setNickName(userinfoExt.getNickName());
				
				userDonateInfo.setType(ucUserinfo.getType());
				
				userDonateInfo.setUserCode(ucUserinfo.getCode());
				
				userDonateInfo.setTotalPowerStr(String.format("%,d", userDonateInfo.getTotalPower()));
				
				userDonateInfos.add(userDonateInfo);
				
			}
			
		});
		
		return userDonateInfos;

	}
	
	/**
	 * 获取当前用户已支持的能量值
	 * @param supportCode
	 * 		支持者
	 * @param beSupportCode
	 * 		被支持者
	 * @return 累计能量值
	 */
	public long supportPower(String supportCode,String beSupportCode){
		
		long power = 0;
		
		UcDonateInfo donateInfo = userServiceFactory.getUserDonateInfoService().queryByCode(supportCode, beSupportCode);
		
		if(donateInfo != null){
			
			power = donateInfo.getTotalPower();
			
		}
		
		return power;
		
	}

}
