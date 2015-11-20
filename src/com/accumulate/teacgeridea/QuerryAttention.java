package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TeacherAttention;
import com.accumulate.service.TeacherAttentionSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *   ��ѯ�Ƿ��ע
 *   
 */
@SuppressWarnings("serial")
public class QuerryAttention extends HttpServlet {
	private String result;
	private TeacherAttention attention;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId=request.getParameter("teacherId");
		String userId=request.getParameter("userId");
		if(StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(StringUtil.isInteger(teacherId)){
				int tId=Integer.parseInt(teacherId);
				querryIsAttention(uId,tId);
				if(attention==null){
					result=JsonUtil.getRetMsg(3,"����û��ע");
				}else {
					result=JsonUtil.getRetMsg(0, "�Ѿ���ע");
				}
			}else {
				result=JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
			}
		}else {
			result=JsonUtil.getRetMsg(2,"����û��½");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void querryIsAttention(int uId, int tId) {
		attention = TeacherAttentionSer.findAttentionByUidAndTid(uId, tId);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}
