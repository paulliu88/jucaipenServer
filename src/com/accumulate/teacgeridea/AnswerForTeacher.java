package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Answer;
import com.accumulate.entity.Ask;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.User;
import com.accumulate.service.AnswerSer;
import com.accumulate.service.AskSer;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���ݽ�ʦid��ȡ��ʦ�ش��б���Ϣ  --���»ش�
 * 
 */
@SuppressWarnings("serial")
public class AnswerForTeacher extends HttpServlet {

	private List<Answer> answerList;
	private FamousTeacher teacher;
	private List<Ask> asks=new ArrayList<Ask>();
	private List<User> users=new ArrayList<User>();
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isInteger(teacherId)) {
			int tId = Integer.parseInt(teacherId);
			initTeacherAnswerList(tId);
			result=JsonUtil.getQuestionForTeacher(teacher,asks,answerList,users);
		} else {
            result=JsonUtil.getRetMsg(1,"��ʦid�������ָ�ʽ���쳣");
		}
        out.print(result);
		out.flush();
		out.close();
	}

	private void initTeacherAnswerList(int tId) {
		//��ʼ����ʦ�ش��б���Ϣ
		answerList=AnswerSer.findAnswerByTeacherId(tId);
		teacher=FamousTeacherSer.findFamousTeacherById(tId);
        if(answerList.size()>0){
        	for(Answer answer :answerList){
        		int askId=answer.getAskId();
        		Ask ask=AskSer.findAskById(askId);
        		asks.add(ask);
        		int uId=ask.getUserId();
        		User user=UserServer.findUserNikNameById(uId);
        		users.add(user);
        	}
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
