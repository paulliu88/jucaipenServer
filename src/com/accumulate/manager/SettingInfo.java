package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���� ���� :type ���style
 * 
 */
@SuppressWarnings("serial")
public class SettingInfo extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String style = request.getParameter("style");
		if (StringUtil.isInteger(type)) {
			int index = Integer.parseInt(type);
			if (StringUtil.isInteger(style)) {
				int sle = Integer.parseInt(style);
				if (index == 1) {
					if (sle == 1) {
						result=JsonUtil.getRetMsg(0, "���1���óɹ�");
					} else if (sle == 2) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					} else if (sle == 3) {
						result=JsonUtil.getRetMsg(0, "���3���óɹ�");
					}
				} else if (index == 2) {
					if (sle == 1) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					} else if (sle == 2) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					} else if (sle == 3) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					}

				} else if (index == 3) {
					if (sle == 1) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					} else if (sle == 2) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					} else if (sle == 3) {
						result=JsonUtil.getRetMsg(0, "���2���óɹ�");
					}

				}

			} else {
            result=JsonUtil.getRetMsg(2, "����ʽ���쳣");
			}
		} else {
			result=JsonUtil.getRetMsg(1,"���͸�ʽ���쳣");

		}
		out.print(result);

		out.flush();
		out.close();
	}

}
