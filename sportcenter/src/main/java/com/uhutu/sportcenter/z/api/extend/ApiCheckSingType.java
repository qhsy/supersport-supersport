package com.uhutu.sportcenter.z.api.extend;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.order.support.CrossFitSupport;
import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.sportcenter.z.entity.UcSignPriceForApi;
import com.uhutu.sportcenter.z.input.ApiCheckSingTypeInput;
import com.uhutu.sportcenter.z.result.ApiCheckSingTypeResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 校验报名类型
 * 
 * @author xiegj
 */
@Service
public class ApiCheckSingType extends RootApiToken<ApiCheckSingTypeInput, ApiCheckSingTypeResult> {

	protected ApiCheckSingTypeResult process(ApiCheckSingTypeInput input) {
		ApiCheckSingTypeResult result = new ApiCheckSingTypeResult();
		List<UcSignPrice> alPrices = JdbcHelper.queryForList(UcSignPrice.class, "", "",
				" type in (select type from uc_sign_info where status=:status and userCode=:userCode ) ",
				MapHelper.initMap("userCode", upUserCode(), "status", "dzsd4112100110030002"));
		Map<String, BigDecimal> map = getPrices();
		if (alPrices != null && alPrices.size() > 0) {
			for (int i = 0; i < alPrices.size(); i++) {
				result.getNoList().add(alPrices.get(i));// 已报名
				if ("dzsd4107100510020003".equals(alPrices.get(i).getType())) {
					map.remove(alPrices.get(i).getType());
				} else {
					map.remove("dzsd4107100510020001");
					map.remove("dzsd4107100510020002");
				}
			}
		}
		List<String> list = new CrossFitSupport().getAlSignType();
		for (int i = 0; i < list.size(); i++) {
			if ("single".equals(list.get(i))) {
				if (map.containsKey("dzsd4107100510020001")) {
					UcSignPrice pp = new UcSignPrice();
					pp.setType("dzsd4107100510020001");
					pp.setPrice(map.get(pp.getType()));
					result.getAlList().add(pp);// 已报满
					map.remove(pp.getType());
				}
				if (map.containsKey("dzsd4107100510020002")) {
					UcSignPrice pp = new UcSignPrice();
					pp.setType("dzsd4107100510020002");
					pp.setPrice(map.get(pp.getType()));
					result.getAlList().add(pp);// 已报满
					map.remove(pp.getType());
				}
			} else if ("group".equals(list.get(i)) && map.containsKey("dzsd4107100510020003")) {
				UcSignPrice pp = new UcSignPrice();
				pp.setType("dzsd4107100510020003");
				pp.setPrice(map.get(pp.getType()));
				result.getAlList().add(pp);// 已报满
				map.remove(pp.getType());
			}
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String type = iterator.next();
			UcSignPrice pp = new UcSignPrice();
			pp.setType(type);
			pp.setPrice(map.get(type));
			result.getYesList().add(pp);
		}
		result.setXhList(h5List(result));
		return result;
	}

	private List<UcSignPriceForApi> h5List(ApiCheckSingTypeResult result) {
		List<UcSignPriceForApi> re = new ArrayList<UcSignPriceForApi>();
		if (result.getAlList() != null && result.getAlList().size() > 0) {
			for (int i = 0; i < result.getAlList().size(); i++) {
				UcSignPriceForApi api = new UcSignPriceForApi();
				api.setTy("al");
				api.setPrice(result.getAlList().get(i).getPrice());
				api.setType(result.getAlList().get(i).getType());
				re.add(api);
			}
		}
		if (result.getNoList() != null && result.getNoList().size() > 0) {
			for (int i = 0; i < result.getNoList().size(); i++) {
				UcSignPriceForApi api = new UcSignPriceForApi();
				api.setTy("no");
				api.setPrice(result.getNoList().get(i).getPrice());
				api.setType(result.getNoList().get(i).getType());
				re.add(api);
			}
		}
		if (result.getYesList() != null && result.getYesList().size() > 0) {
			for (int i = 0; i < result.getYesList().size(); i++) {
				UcSignPriceForApi api = new UcSignPriceForApi();
				api.setTy("yes");
				api.setPrice(result.getYesList().get(i).getPrice());
				api.setType(result.getYesList().get(i).getType());
				re.add(api);
			}
		}
		return re;
	}

	private Map<String, BigDecimal> getPrices() {
		Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
		List<UcSignPrice> prices = JdbcHelper.queryForList(UcSignPrice.class, "", "", "", null);
		for (int i = 0; i < prices.size(); i++) {
			map.put(prices.get(i).getType(), prices.get(i).getPrice());
		}
		return map;
	}

}
