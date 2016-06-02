package com.uhutu.dcom.component.z.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.uhutu.zoocom.root.RootClass;

/**
 * xml解析工具类
 * 
 * @author pang_jhui
 *
 */
public class XmlUtil extends RootClass {

	/**
	 * 移除指定标签的参数
	 * @param xmlStr
	 * 		xml 字符串
	 * @param tagName
	 * 		标签名称
	 * @param attr
	 * 		参数值
	 * @return 处理后的xml
	 * 
	 * @throws Exception
	 */
	public static String removeAttr(String xmlStr,String tagName ,String attr) throws Exception {
		
	    String[] xmlArray = {"<html>",xmlStr,"</html>"};
		
		xmlStr = StringUtils.join(xmlArray);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		StringWriter strWtr = new StringWriter();

		StreamResult strResult = new StreamResult(strWtr);

		InputStream stream = new ByteArrayInputStream(xmlStr.getBytes());

		Document document = db.parse(stream);

		NodeList nodeList = document.getElementsByTagName(tagName);

		for (int i = 0; i < nodeList.getLength(); i++) {

			Element element = (Element) nodeList.item(i);

			if (element.hasAttribute(attr)) {

				element.removeAttribute(attr);

			}
		}

		TransformerFactory tfac = TransformerFactory.newInstance();

		Transformer transformer = tfac.newTransformer();

		transformer.transform(new DOMSource(document.getDocumentElement()), strResult);

		String str = strResult.getWriter().toString();

		str = StringUtils.substringBetween(str, "<html>", "</html>");

		return str;

	}

}
