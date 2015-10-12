package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.PrivatePlace;
import com.accumulate.service.PrivatePlaceSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *   ����˽ļ��ϸ��Ϣ
 *
 */
@SuppressWarnings("serial")
public class PrivatePlaetDetail extends HttpServlet {
	private PrivatePlace place;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		if(StringUtil.isInteger(id)){
			int privateId=Integer.parseInt(id);
			initPrivateData(privateId);
			result=JsonUtil.getObject(place);
		}else {
			result=JsonUtil.getRetMsg(1,"˽ļid�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initPrivateData(int id) {
		//��ȡ˽ļ��ϸ��Ϣ
		place=PrivatePlaceSer.findPrivatePlaceById(id);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}
