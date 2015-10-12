package com.accumulate.teach;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Teacher;
import com.accumulate.entity.Video;
import com.accumulate.service.TeacherServer;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author ylf
 * 
 *         ������Ƶ��ѯ��ʦ��ϸ��Ϣ
 *         
 *            --id   ��Ƶid
 * 
 */
@SuppressWarnings("serial")
public class TeacherInfo extends HttpServlet {
	private String result;
	private Teacher teacher;
	private Video video;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Id = request.getParameter("id");
		if (StringUtil.isInteger(Id)) {
			int id = Integer.parseInt(Id);
			intitVideoInfo(id);
			result = JsonUtil.getObject(teacher);
		} else {
			result =JsonUtil.getRetMsg(1,"��Ƶid�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void intitVideoInfo(int id) {
		// ��ʼ����Ƶ��Ϣ
		video=VideoServer.findVideoById(id);
		int teacherId=video.getTearcherId();
		initTeacher(teacherId);
		
	}

	private void initTeacher(int teacherId) {
		//��ʼ����ʦ��Ϣ
		teacher=TeacherServer.getTeacher(teacherId);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
