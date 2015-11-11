package com.andieguo.jersey.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667946458734463345L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	//1、ajax传递一个json数据给servlet；
	//2、servlet获取到json数据字符串，转换成JSON对象，并返回一个JSON对象；
	//3、ajax获取到JSON对象，并作相关处理。
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String userStr = readJSONString(req);// 得到requestContext
			System.out.println("userStr:"+userStr);
			JSONObject jsonObj = new JSONObject(userStr);
			System.out.println(jsonObj.getInt("userId"));// 得到JSONObject的userId值
			System.out.println(jsonObj.getString("name"));

			JSONObject resultJSON = new JSONObject();// 构建一个JSONObject
			resultJSON.accumulate("errNum", 1);
			resultJSON.accumulate("errInfo", "成功");

			response.setContentType("application/x-json");// 需要设置ContentType
															// 为"application/x-json"
			PrintWriter out = response.getWriter();
			out.println(resultJSON.toString());// 向客户端输出JSONObject字符串
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return json.toString();
	}

}
