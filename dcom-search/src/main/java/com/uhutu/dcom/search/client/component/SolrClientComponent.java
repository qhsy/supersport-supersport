package com.uhutu.dcom.search.client.component;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.search.client.config.SolrConfig;

/**
 * solr客户端 共用组件
 * @author 逄小帅
 *
 */
@Component
public class SolrClientComponent {
	
	@Autowired
	private SolrConfig solrConfig;
	
	
	public void getSolrHttpClient(String coreName){
		
		
		
		
	}
	

}
