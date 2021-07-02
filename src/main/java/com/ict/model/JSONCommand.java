package com.ict.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JSONCommand {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BufferedReader br = null;
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTime/1/5/");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String msg = null;
			StringBuffer sb = new StringBuffer();
			while((msg= br.readLine()) != null) {
				sb.append(msg + "\n");
			}
			
			int a = sb.indexOf("row");
			
			String s = sb.substring(a+5, sb.length()-3);
			
			
			return s;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}
}
