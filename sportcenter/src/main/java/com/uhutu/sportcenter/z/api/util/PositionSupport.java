package com.uhutu.sportcenter.z.api.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.uhutu.dcom.content.z.entity.CnLivePositionInfo;
import com.uhutu.dcom.content.z.entity.CnLivePositionLog;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.sportcenter.z.entity.CnLiveMatchLogForApi;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 位置信息支撑类
 * 
 * @author Administrator
 *
 */

public class PositionSupport {

	public static final int Raidus = Integer.valueOf(ConfigDcomContent.upConfig().getNearbyDistance());
	public static final int TypeSame = 1;
	public static final int TypeOther = 2;

	/**
	 * 生成以中心点为中心的四方形经纬度
	 * 
	 * @param lat
	 *            纬度
	 * @param lon
	 *            精度
	 * @param raidus
	 *            半径（以米为单位）
	 * @return
	 */
	public static double[] getAround(double lat, double lon) {

		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = Raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

	/**
	 * 
	 * 附近的人
	 * 
	 * @param page
	 *            第几页
	 * @param code
	 *            直播编号
	 * @param userCode
	 *            用户编号
	 * @param lat
	 *            维度
	 * @param lon
	 *            精度
	 * @param raidus
	 *            半径（以米为单位）
	 * @return
	 */
	public static List<CnLiveMatchLogForApi> getNearBy(int page, String code, String userCode, double lat, double lon) {
		List<CnLiveMatchLogForApi> result = new ArrayList<CnLiveMatchLogForApi>();
		double[] around = getAround(lat, lon);
		double minLat = around[0];
		double minLng = around[1];
		double maxLat = around[2];
		double maxLng = around[3];
		MDataMap param = new MDataMap();
		param.put("lat", String.valueOf(lat));
		param.put("lon", String.valueOf(lon));
		param.put("minLng", String.valueOf(minLng));
		param.put("maxLng", String.valueOf(maxLng));
		param.put("minLat", String.valueOf(minLat));
		param.put("maxLat", String.valueOf(maxLat));
		param.put("userCode", userCode);
		param.put("code", code);
		List<CnLivePositionInfo> list = JdbcHelper.queryForList(CnLivePositionInfo.class, "",
				"ACOS(SIN((:lat * 3.1415) / 180 ) * SIN((latitude * 3.1415) / 180 )+COS((:lat * 3.1415) / 180 ) * COS((latitude * 3.1415) / 180 ) *COS((:lon * 3.1415) / 180 - (longitude * 3.1415) / 180 ) )* 6380 asc",
				"latitude <> 0 and longitude > :minLng and longitude < :maxLng and latitude > :minLat and latitude < :maxLat and user_code <> :userCode and code=:code",
				param, (page - 1) * 10, 10);
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				CnLiveMatchLogForApi logForApi = new CnLiveMatchLogForApi();
				BeanUtils.copyProperties(list.get(i), logForApi);
				logForApi.setSig(new TecentSigSupport().upSigCodeByUserCode(logForApi.getUserCode()));
				UcUserinfoExt userinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",
						logForApi.getUserCode());
				if (userinfoExt != null) {
					logForApi.setNickName(userinfoExt.getNickName());
					logForApi.setHeadUrl(userinfoExt.getAboutHead());
				}
				logForApi.setDistance(distance(lon, lat, logForApi.getLongitude(), logForApi.getLatitude()));
				result.add(logForApi);
			}
		}
		return result;
	}

	/**
	 * 
	 * 是否还有下页数据
	 * 
	 * @param page
	 *            第几页
	 * @param code
	 *            直播编号
	 * @param userCode
	 *            用户编号
	 * @param lat
	 *            维度
	 * @param lon
	 *            精度
	 * @param raidus
	 *            半径（以米为单位）
	 * @return
	 */
	public static boolean nextPage(int page, String code, String userCode, double lat, double lon) {
		boolean flag = false;
		double[] around = getAround(lat, lon);
		double minLat = around[0];
		double minLng = around[1];
		double maxLat = around[2];
		double maxLng = around[3];
		List<CnLivePositionInfo> list = JdbcHelper.queryForList(CnLivePositionInfo.class, "",
				"ACOS(SIN((" + lat + " * 3.1415) / 180 ) * SIN((latitude * 3.1415) / 180 )+COS((" + lat
						+ " * 3.1415) / 180 ) * COS((latitude * 3.1415) / 180 ) *COS((" + lon
						+ " * 3.1415) / 180 - (longitude * 3.1415) / 180 ) )* 6380 asc",
				"latitude <> 0 and longitude > '" + minLng + "' and longitude < '" + maxLng + "' and latitude > '"
						+ minLat + "' and latitude < '" + maxLat + "' and user_code <> '" + userCode + "' and code='"
						+ code + "'",
				null, page * 10, 10);
		if (list != null && !list.isEmpty()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 计算中心经纬度与目标经纬度的距离（米）
	 * 
	 * @param centerLon
	 *            中心精度
	 * @param centerLan
	 *            中心纬度
	 * @param targetLon
	 *            需要计算的精度
	 * @param targetLan
	 *            需要计算的纬度
	 * @return 米
	 */
	private static String distance(double centerLon, double centerLat, double targetLon, double targetLat) {

		String result = "";
		double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;
		double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;
		double b = Math.abs((centerLat - targetLat) * jl_jd);
		double a = Math.abs((centerLon - targetLon) * jl_wd);
		double distance = Math.sqrt((a * a + b * b));
		if (distance < 1000) {
			result = new Double(distance).intValue() + "m";
		} else {
			BigDecimal bg = new BigDecimal(distance / 1000);
			result = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() + "km";
		}
		return result;
	}

	/**
	 * 记录位置及日志信息
	 * 
	 * @param code
	 *            直播编号
	 * @param gameCode
	 *            球队编号
	 * @param token
	 * 
	 * @param lon
	 *            精度
	 * @param lat
	 *            维度
	 */
	public static void savePosition(String code, String gameCode, String token, double lon, double lat) {
		String userCode = new UserCallFactory().upUserCodeByAuthToken(token, DefineUser.Login_System_Default);
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(gameCode) && StringUtils.isNotBlank(token)
				&& lon != 0 && lat != 0) {
			CnLivePositionInfo info = JdbcHelper.queryOne(CnLivePositionInfo.class, "code", code, "gameCode", gameCode,
					"userCode", userCode);
			if (info != null) {
				info.setLatitude(lat);
				info.setLongitude(lon);
				JdbcHelper.update(info, "longitude,latitude", "za");
			} else {
				info = new CnLivePositionInfo();
				info.setCode(code);
				info.setGameCode(gameCode);
				info.setLatitude(lat);
				info.setLongitude(lon);
				info.setUserCode(userCode);
				JdbcHelper.insert(info);
			}

			CnLivePositionLog log = new CnLivePositionLog();
			log.setCode(code);
			log.setGameCode(gameCode);
			log.setUserCode(userCode);
			log.setLongitude(lon);
			log.setLatitude(lat);
			JdbcHelper.insert(log);
		}

	}

	/**
	 * 获取阵营人数
	 * 
	 * @param code
	 * @param gameCode
	 * @param type
	 * @return
	 */
	public static int campNum(String code, String gameCode, int type) {
		int num = 0;
		if (type == TypeSame) {
			num = JdbcHelper.count(CnLivePositionInfo.class, "code=:code and game_code=:gameCode",
					MapHelper.initMap("code", code, "gameCode", gameCode));
		}
		if (type == TypeSame) {
			num = JdbcHelper.count(CnLivePositionInfo.class, "code=:code and game_code!=:gameCode",
					MapHelper.initMap("code", code, "gameCode", gameCode));
		}
		return num;
	}

}
