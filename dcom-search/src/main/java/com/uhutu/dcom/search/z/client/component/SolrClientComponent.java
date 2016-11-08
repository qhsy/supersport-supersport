package com.uhutu.dcom.search.z.client.component;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.uhutu.dcom.search.z.client.config.SolrConfig;


/**
 * solr客户端 共用组件
 * @author 逄小帅
 *
 */

public class SolrClientComponent {
	
	/**
	 * 获取solr client
	 * @param coreName
	 * 		solr 核心
	 * @return HttpSolrClient
	 */
	public static HttpSolrClient getSolrHttpClient(){
		
		String baseSolrUrl = SolrConfig.SOLR_URL;
		
		HttpSolrClient solrClient =new HttpSolrClient.Builder(baseSolrUrl).build();
		
		solrClient.setAllowCompression(true);
		
		solrClient.setFollowRedirects(false);
		
		solrClient.setConnectionTimeout(3000);
		
		return solrClient;
		
	}
	
	public static void solrQuery(){
		
		SolrQuery solrQuery = new SolrQuery();
		
		solrQuery.setQuery("nickName:逄");
		
		solrQuery.setRows(10);
		
		try {
			
			SolrDocumentList docs = getSolrHttpClient().query(solrQuery).getResults();
			
			for (SolrDocument solrDocument : docs) {
				
				System.out.println(solrDocument.getFieldValue("nickName"));
				
			}
			
		} catch (SolrServerException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
    public static void main(String[] args) {
		
    	SolrClientComponent.solrQuery();
    	
	}
	
	
}
