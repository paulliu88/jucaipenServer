package com.accumulate.video;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.ChatRoom;
import com.accumulate.entity.Video;
import com.accumulate.service.LiveRoomServer;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ֱ�����㲥
 *         ��ȡ��Ƶ��ϸ��Ϣ
 *             ------type     ----0 ֱ��    ----------1 �㲥
 */
@SuppressWarnings("serial")
public class VideoResource extends HttpServlet {
	private ChatRoom room;
	private String result;
	private Video video;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String videoId = request.getParameter("id");
		String typeId=request.getParameter("typeId");
		if(StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			if (StringUtil.isInteger(videoId)) {
				int id = Integer.parseInt(videoId);
				if(type==0){
					//ֱ��
					initVideoInfo(id);
					result = JsonUtil.getRoomDetaile(room);
				}else if(type==1){
					initNonVideoResource(id);
					if(video!=null){
						result = JsonUtil.getVideoResourceData(video);
					}else {
						result=JsonUtil.getRetMsg(2,"��Ƶ��Դ������");
					}
				}
			} else {
				result = JsonUtil.getRetMsg(1, "��Ƶid�������ָ�ʽ���쳣");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}
	
	/**
	 * @param videoType
	 *            ��ȡ�㲥��Ƶ��Դ
	 */
	private void initNonVideoResource(int videoId) {
		video = VideoServer.findVideoResourceById(videoId);

	}

	/**
	 * @param id
	 *     ��ȡֱ����Ƶ��Դ
	 */
	private void initVideoInfo(int id) {
		room =LiveRoomServer.getRoomLiveUrl(id);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
