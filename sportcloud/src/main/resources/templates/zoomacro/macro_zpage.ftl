

<#macro m_zoo_zpage_html_js p_list>
	<#list p_list?split(",") as e>
	<script type="text/javascript" src="${zoo_config["webjarsUrl"]}${e}"></script>
	</#list>

</#macro>


<#macro m_zoo_zpage_html_babel p_list>
	<#list p_list?split(",") as e>
	<script type="text/babel" src="${zoo_config["webjarsUrl"]}${e}"></script>
	</#list>

</#macro>


<#macro m_zoo_zpage_html_css p_list >
<#list p_list?split(",") as e>
	<link type="text/css" href="${zoo_config["webjarsUrl"]}${e}" rel="stylesheet">
</#list>
</#macro>


<#macro m_zoo_zpage_html_script  p_info >
<script type="text/javascript">
	${p_info}
</script>
</#macro>

<#macro m_zoo_zpage_html_initjs  p_js >
	<@m_zoo_zpage_html_script "$(function(){"+p_js+"}); " />
</#macro>

<#macro m_zoo_zpage_layout_head  p_title="" p_css="" p_js="" >
<!doctype html>
<html  class="zs_page_h100p"><head>
    <meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <title>${p_title}</title>
	<@m_zoo_zpage_html_css zoo_config["webResourcesCss"] />
	<@m_zoo_zpage_html_js zoo_config["webResourcesJs"] />
	<#if p_css!=""><@m_zoo_zpage_html_css    p_css /></#if>
	<#if p_js!="" ><@m_zoo_zpage_html_js    p_js /></#if>
</#macro>



<#macro m_zoo_zpage_layout_body>
</head><body ontouchstart  class="zs_page_h100p">
</#macro>

<#macro m_zoo_zpage_layout_foot p_js="" p_init="">
	<#if p_init!="" >
		<@m_zoo_zpage_html_js    p_js />
	</#if>
	<#if p_init!="" >
		<@m_zoo_zpage_html_initjs p_init/>
	</#if>
</body></html>
</#macro>
