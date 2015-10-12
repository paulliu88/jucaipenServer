package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.PrivatePlace;
import com.accumulate.service.PrivatePlaceSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ����˽ļ ��˽ļ��̬��------ ���� ���ŷ���id��bigId==3�� ------�б�ҳ
 */
@SuppressWarnings("serial")
public class SunShineFind extends HttpServlet {
	private List<PrivatePlace> places;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(pager)) {
			int page = Integer.parseInt(pager);
			initPrivateData(page);
			if (places != null && places.size() > 0) {
				result = JsonUtil.getObject(places);
			} else {
				result = JsonUtil.getRetMsg(1, "��������˽ļ��Ϣ");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "ҳ��������ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initPrivateData(int page) {
		// ��ʼ��˽ļ��Ϣ
		places = PrivatePlaceSer.findAll(page);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
