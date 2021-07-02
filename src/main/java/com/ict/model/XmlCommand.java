package com.ict.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class XmlCommand {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
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
			
			return sb.toString();
		} catch (Exception e) {
		}finally {
			try {
					br.close();
					
					
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
}