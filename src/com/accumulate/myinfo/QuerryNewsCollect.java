package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsFavorites;
import com.accumulate.service.NewsFavoritesSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ��ѯָ�������Ƿ��ղ�
 */
@SuppressWarnings("serial")
public class QuerryNewsCollect extends HttpServlet {
	private String result;
	private NewsFavorites newsFavorites;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String newsId = request.getParameter("newsId");
		if(StringUtil.isInteger(userId)){
			int uId=Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isInteger(newsId)) {
					int nId = Integer.parseInt(newsId);
					querryCollectNews(uId,nId);
					if(newsFavorites!=null){
						result=JsonUtil.getRetMsg(0, "�����ѱ��ղ�");
					}else {
						result=JsonUtil.getRetMsg(1,"����δ�ղ�");
					}
				} else {
					result=JsonUtil.getRetMsg(3, "����id�������ָ�ʽ���쳣");
				}	
			}else {
				result=JsonUtil.getRetMsg(6,"��ǰ�û���û��¼");
			}
		}else {
			result=JsonUtil.getRetMsg(4,"�û�id�������ָ�ʽ���쳣");
		}
		
		out.print(result);
		out.flush();
		out.close();
	}

	private void querryCollectNews(int uId, int nId) {
		// ��ѯָ��id�������Ƿ��ղ�
		newsFavorites=NewsFavoritesSer.findNewsIsCollect(uId, nId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
