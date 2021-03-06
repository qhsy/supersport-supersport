package com.uhutu.dcom.content.z.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;

/**
 * 点赞评价业务数据操作接口
 * 
 * @author xiegj
 *
 */
public interface ISupportPraiseDao extends JpaRepository<CnSupportPraise, String>,JpaSpecificationExecutor<CnSupportPraise> {

	/**
	 * 个人点赞或其他类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @return 标签信息
	 */
	@Query("select cp from CnSupportPraise cp where cp.type=:type and cp.userCode=:userCode")
	public List<CnSupportPraise> querybyUserCodeAndType(@Param("type") String type, @Param("userCode") String userCode);

	/**
	 * 个人点赞类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	@Query("select cp from CnSupportPraise cp where cp.type=:type and cp.userCode=:userCode and cp.contentCode=:contentCode")
	public List<CnSupportPraise> querybyContentCodeAndUserCodeAndType(@Param("type") String type,
			@Param("userCode") String userCode, @Param("contentCode") String contentCode);
	
	/**
	 * 个人取消点赞类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	@Modifying
	@Query("delete CnSupportPraise cp where cp.type=:type and cp.userCode=:userCode and cp.contentCode=:contentCode")
	public void cancelbyCCAndUCAndType(@Param("type") String type,
			@Param("userCode") String userCode, @Param("contentCode") String contentCode);

	/**
	 * 个人点赞所有数据查询
	 * 
	 * @param userCode
	 *            用户编号
	 * @return 点击评价信息
	 */
	@Query("select cp from CnSupportPraise cp where cp.userCode=:userCode")
	public List<CnSupportPraise> querybyUserCode(@Param("userCode") String userCode);

	/**
	 * 内容全部点赞类型数据数据查询(不分类型)
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 点击评价信息
	 */
	@Query("select cp from CnSupportPraise cp where contentCode=:contentCode")
	public List<CnSupportPraise> querybyContentCode(@Param("contentCode") String contentCode);

	/**
	 * 内容获赞 或其他类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param contentCode
	 *            内容编号
	 * 
	 * @return 点击评价信息
	 */
	@Query("select cp from CnSupportPraise cp where cp.type=:type and cp.contentCode=:contentCode")
	public List<CnSupportPraise> querybyContentCodeAndType(@Param("type") String type,
			@Param("contentCode") String contentCode);
	
	/**
	 * 根据内容编号查询点赞数量
	 * @param contentCode
	 * 		内容编号
	 * @return 点赞数量
	 */
	@Query("select count(1) from CnSupportPraise cp where cp.contentCode=:contentCode and status=:status")
	public int queryCountByCode(@Param("contentCode") String contentCode,@Param("status") String status);
	
	@Query("select t from CnSupportPraise t where t.type=:type and t.contentCode=:contentCode and t.userCode=:userCode")
	public CnSupportPraise query(@Param("contentCode") String contentCode,@Param("userCode") String userCode,@Param("type") String type);
	
	/**
	 * 点赞过
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	
	@Query("select count(1) from CnSupportPraise cp where cp.type=:type and cp.userCode=:userCode and contentCode like 'CNBH%' and exists(select 1 from CnContentBasicinfo where code = content_code and status = 'dzsd4699100110010001'  ) and status=:status")
	public int favored(@Param("type") String type, @Param("userCode") String userCode,@Param("status") String status);
	
}
