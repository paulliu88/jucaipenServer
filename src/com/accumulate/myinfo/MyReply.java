package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.NewsCommRes;
import com.accumulate.service.NewsCommResSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         �ҵĻظ�
 * 
 */
@SuppressWarnings("serial")
public class MyReply extends HttpServlet {
	private String result;
	private List<NewsCommRes> newsCommRes=new ArrayList<NewsCommRes>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String pager=request.getParameter("pager");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if(StringUtil.isInteger(pager)){
					int page=Integer.parseInt(pager);
					inityReplyInfo(uId,page);
	                result=JsonUtil.getNewsCommResList(newsCommRes);
				}else {
					result=JsonUtil.getRetMsg(2,"ҳ���������ָ�ʽ���쳣");
				}
			}else {
				result=JsonUtil.getRetMsg(5,"��ǰ�û���û��¼");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"�û�id�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void inityReplyInfo(int uId, int page) {
		//��ȡ�ҵĻظ���Ϣ
		newsCommRes.clear();
		newsCommRes=NewsCommResSer.findCommResByUser(uId, page);
		
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
