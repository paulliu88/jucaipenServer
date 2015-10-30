package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.AskClass;
import com.accumulate.service.AskClassSer;
import com.accumulate.utils.JsonUtil;

/**
 * @author Administrator
 * 
 *   ��ȡ��ѯ�����б�
 *
 */
@SuppressWarnings("serial")
public class QuerryAskClass extends HttpServlet {

	
	private List<AskClass> askClasses;
	private String reault;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initAskClassData();
		reault=JsonUtil.getAskClassList(askClasses);
		out.print(reault);
		out.flush();
		out.close();
	}

	
	private void initAskClassData() {
		// ��ʼ����ѯ��������
		askClasses=AskClassSer.findAllClass();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
		
	}

}
