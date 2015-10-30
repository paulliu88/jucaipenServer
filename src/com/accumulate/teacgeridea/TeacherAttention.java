package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.service.TeacherAttentionSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ע��ʦ
 * 
 */
@SuppressWarnings("serial")
public class TeacherAttention extends HttpServlet {
	private String result;
	private int isSuccess;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isInteger(userId)) {
			// �û�id���ָ�ʽ������
			int uId = Integer.parseInt(userId);
			if (StringUtil.isInteger(teacherId)) {
				int tId = Integer.parseInt(teacherId);
				insertAttention(uId, tId);
				if (isSuccess == 1) {
					result = JsonUtil.getRetMsg(0, "��ע��ʦ�ɹ�");
				} else {
					result = JsonUtil.getRetMsg(3, "��ע��ʦʧ��");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void insertAttention(int uId, int tId) {
		com.accumulate.entity.TeacherAttention attention = new com.accumulate.entity.TeacherAttention(
				0, uId, tId);
		isSuccess = TeacherAttentionSer.insertAttention(attention);

	}

}
