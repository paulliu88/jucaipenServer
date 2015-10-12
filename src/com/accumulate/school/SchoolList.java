package com.accumulate.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Video;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ����ѧ�÷���id ��ȡ��Ӧ��ѧ����Ϣ
 * 
 */
@SuppressWarnings("serial")
public class SchoolList extends HttpServlet {
	private List<Video> tvs;

	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("typeId");
		if (StringUtil.isInteger(typeId)) {
			int id = Integer.parseInt(typeId);
			initData(id);
			result = JsonUtil.getVideoList(tvs);
		} else {
			result = JsonUtil.getRetMsg(1, "���������ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int id) {
		tvs = VideoServer.findVideoByClassId(id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
