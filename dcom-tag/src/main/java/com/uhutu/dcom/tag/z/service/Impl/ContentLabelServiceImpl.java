package com.uhutu.dcom.tag.z.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.tag.z.dao.ContentLabelDaoFacotry;
import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.dcom.tag.z.service.IContentLabelService;

/**
 * 标签业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentLabelServiceImpl implements IContentLabelService {

	@Autowired
	private ContentLabelDaoFacotry contentLabelDaoFacotry;

	public CnContentLabel query(String za) {
		return contentLabelDaoFacotry.getContentLabelDao().findOne(za);
	}

	public List<CnContentLabel> queryAll() {
		List<CnContentLabel> list = new ArrayList<CnContentLabel>();
		list = contentLabelDaoFacotry.getContentLabelDao().queryAll();
		return list;
	}

	public List<CnContentLabel> querybyuserCode(String userCode) {
		return contentLabelDaoFacotry.getContentLabelDao().querybyuserCode(userCode);
	}

	@Override
	public List<String> queryListByCodeIn(List<String> codes) {
		
		return contentLabelDaoFacotry.getContentLabelDao().queryListByCodeIn(codes);
	}

	@Override
	public String initTagName(String tagCode) {
		
		tagCode = StringUtils.defaultString(tagCode);

		List<String> codes = Arrays.asList(StringUtils.split(tagCode, ","));
		
		String name = "";
		
		if(!codes.isEmpty()){
			
			List<String> tagNames = queryListByCodeIn(codes);
			
			name = StringUtils.join(tagNames, ",");
			
		}

		return name;

	}

	@Override
	public CnContentLabel queryByCode(String code) {
		
		return contentLabelDaoFacotry.getContentLabelDao().queryByCode(code);
		
	}

}
