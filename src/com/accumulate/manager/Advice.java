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
 * @author YLF
 * 
 *         �������
 * 
 */
@SuppressWarnings("serial")
public class Advice extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String adviceInfo = request.getParameter("advice");
		if(StringUtil.isInteger(userId)){
			if (StringUtil.isNotNull(adviceInfo)) {
				result = JsonUtil.getRetMsg(0, "��������ɹ�");
			} else {
				result = JsonUtil.getRetMsg(1, "�������ݲ���Ϊ��");
			}
		}else {
			result=JsonUtil.getRetMsg(2,"�û�id������ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

}
