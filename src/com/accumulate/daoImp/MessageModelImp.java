package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.MessageModelDao;
import com.accumulate.entity.MessageModel;
import com.accumulate.utils.JdbcUtil;

public class MessageModelImp implements MessageModelDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<MessageModel> models=new ArrayList<MessageModel>();
	

	public List<MessageModel> querryAllModel() {
		//��ȡ����ģ����Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Mess_Template");
			models=getMessageModel(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public MessageModel findModelById(int id) {
		//����id��ȡģ����Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Mess_Template WHERE Id="+id);
			models=getMessageModel(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<MessageModel> getMessageModel(ResultSet result) {
		//��ȡģ����Ϣ
		models.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				int modelType=result.getInt("TemplateType");
				String title=result.getString("Title");
				String content=result.getString("TemplateContent");
				MessageModel model=new MessageModel();
				model.setId(id);
				model.setModelType(modelType);
				model.setTitle(title);
				model.setModelContent(content);
				models.add(model);
			}
			return models;
		} catch (Exception e) {
		}
		return null;
	}

}
