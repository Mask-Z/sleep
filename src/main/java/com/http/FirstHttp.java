package com.http;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 简单的get请求和post请求
 * @author 周云龙
 * @date 2018/5/30 21:14
 */
public class FirstHttp {

	/**
	 * get请求
	 *
	 * @param address url地址
	 */
	private static void sendGet(String address) {
		URL url;
		LineNumberReader lineNumberReader = null;
		StringBuilder result = new StringBuilder();
		try {
			url = new URL(address);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36");

			connection.connect();

			lineNumberReader = new LineNumberReader(new InputStreamReader(connection.getInputStream()));
			String temp;
			while ((temp = lineNumberReader.readLine()) != null) {
				result.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lineNumberReader != null) {
				try {
					lineNumberReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * post请求
	 *
	 * @param address url地址
	 * @param param   参数
	 */
	private static void sendPost(String address, Map<String, String> param) {
		URL url;
		LineNumberReader lineNumberReader = null;
		PrintWriter printWriter = null;
		StringBuilder result = new StringBuilder();
		try {
			url = new URL(address);

			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36");

			//post请求这两项必须设为true
			connection.setDoInput(true);
			connection.setDoOutput(true);

			//添加参数(该步骤在a步骤之前和之后都行)
			if (param != null) {
				Iterator<Entry<String, String>> iterator = param.entrySet().iterator();
				printWriter = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					printWriter.write(entry.getKey() + "=" + entry.getValue());
				}
				printWriter.flush();
			}

			//a.打开链接
			connection.connect();

			lineNumberReader = new LineNumberReader(new InputStreamReader(connection.getInputStream()));
			String temp;
			while ((temp = lineNumberReader.readLine()) != null) {
				result.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lineNumberReader != null) {
				try {
					lineNumberReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String getUrl = "https://www.baidu.com";
		String postUrl = "http://58.216.221.107:20033/eweb/jingJiaEndTime";
		Map<String, String> map = new HashMap<>(5);
		map.put("infoid", "FC2018052400179");

		sendGet(getUrl);
		sendPost(postUrl, map);
	}
}
