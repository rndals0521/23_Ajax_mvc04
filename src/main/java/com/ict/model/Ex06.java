package com.ict.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource; //사스 방식.

public class Ex06 {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document =null;
		
		try {
			URL url = new URL("https://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String msg = null;
			StringBuffer sb = new StringBuffer();
			while((msg= br.readLine()) != null) {
				sb.append(msg + "\n");
				
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
		}finally {
			try {
					br.close();
					
					
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
