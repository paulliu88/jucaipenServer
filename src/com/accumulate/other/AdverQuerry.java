package com.accumulate.other;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Advertive;
import com.accumulate.service.AdverSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

public class AdverQuerry extends HttpServlet {
	private List<Advertive> advertives;
	private String result;

	/**
	 * ��ȡ���ҳ��
	 * 
	 * type ---1 ��ҳ��� ----3 ��ƱƵ����ҳ --- 5������õ�Ƭ
	 */
	private static final long serialVersionUID = 3422921301006771892L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("type");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (type == 1) {
				// ��ҳ���õ�Ƭ
				initIndexPageData();
				result = JsonUtil.getObject(advertives);
			}else if(type==3){
				//��ƱƵ����ҳ�õ�Ƭ
				
			}else if(type==5){
				//�����ɻõ�Ƭ
				
			}
		}else {
			result=JsonUtil.getRetMsg(1,"������Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexPageData() {
		// ������ҳ���
		advertives = AdverSer.findAdverByPid(1);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
