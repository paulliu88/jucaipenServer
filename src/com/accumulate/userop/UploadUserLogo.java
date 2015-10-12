package com.accumulate.userop;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;
import com.accumulate.utils.UpLoadFileUtils;

/**
 * @author ylf
 * 
 *         文件上传(用户头像)
 * 
 */
@SuppressWarnings("serial")
public class UploadUserLogo extends HttpServlet {
	private Map<String, String> map;
	private String fileName;
	private String userId;
	private String resultMsg;
	private String savePath;
	private String loadPath;
	private int isSuccess;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		savePath="D:/apkInfo/userLogo";
		loadPath="http://121.40.227.121:8080/AccumulateWealth/jucaipen/downUserLogo?filename=";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		// 上传时生成的临时文件保存目录
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		map = new UpLoadFileUtils().upLoad(request, tmpFile, savePath,loadPath);
		for (String key : map.keySet()) {
			if (key.equals("-1") || key.equals("-2")) {
             resultMsg=JsonUtil.getRetMsg(3,"上传文件太大，请重新上传");
             out.print(resultMsg);
             System.out.println(resultMsg);
			} else {
				userId = key;
				fileName = map.get(key);
				System.out.println(" key="+key+" values="+fileName);
			}

		}
		if (map.size() > 0) {
			System.out.println("  " + userId);
			if ((!StringUtil.isInteger(userId)
					||Integer.parseInt(userId) < 0)) {
				resultMsg = JsonUtil.getRetMsg(1, "当前用户id异常");
				out.print(resultMsg);
				System.out.println(resultMsg);
			} else {
				int uId=Integer.parseInt(userId);
				String faceImage=loadPath+fileName;
				isSuccess= UserServer.updateUserLogo(uId, faceImage);
				if (isSuccess == 1) {
					resultMsg = JsonUtil.getRetMsg(0, "用户头像保存成功");
					out.print(resultMsg);
					System.out.println(resultMsg);
				} else {
					resultMsg = JsonUtil.getRetMsg(2, "用户头像保存失败");
					out.print(resultMsg);
					System.out.println(resultMsg);
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}