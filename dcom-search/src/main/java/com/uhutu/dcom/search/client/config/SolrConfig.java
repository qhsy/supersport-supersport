package com.uhutu.dcom.search.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * solr配置信息
 * @author 逄小帅
 *
 */
@Component
public class SolrConfig {
	
	/*solr访问url*/
	@Value("${dcom.search.solr.url}")
	private String solrUrl;

	public String getSolrUrl() {
		return solrUrl;
	}

	public void setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
	}
	
	

}
