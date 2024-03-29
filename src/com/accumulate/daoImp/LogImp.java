package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.accumulate.dao.LogDao;
import com.accumulate.entity.LoginLog;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

/**
 * @author YLF
 * 
 *         登录日志实现类
 * 
 */
public class LogImp implements LogDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<LoginLog> logs;
	private int isSuccess;

	/**
	 * @return 查询登录日志总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPUserLoginLog "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 添加登录日志
	 */
	public int insertLog(LoginLog log) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into JCPUserLoginLog("
					+ SqlUtil.LOGINLOG_UID + "," + SqlUtil.LOGINLOG_UNAME + ","
					+ SqlUtil.LOGINLOG_PWD + "," + SqlUtil.LOGINLOG_LOGINDATE
					+ "," + SqlUtil.LOGINLOG_IP + ","
					+ SqlUtil.LOGINLOG_LOGINRES + "," + SqlUtil.LOGINLOG_REMARK
					+ ") values (" + log.getUserId() + ",'" + log.getUserName()
					+ "','" + log.getPassword() + "','" + log.getLoginDate()
					+ "','" + log.getLoginIp() + "'," + log.getLoginResult()
					+ ",'" + log.getRemark() + "')");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 删除登录日志
	 */
	public int deleteLog(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("delete from JCPUserLoginLog where Id="
					+ id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 根据id查询登录日志
	 */
	public LoginLog findLog(int id) {
		LoginLog log = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUserLoginLog where Id="
					+ id);
			logs = getLogs(res, -1, -1);
			if (logs != null && logs.size() > 0) {
				log = logs.get(0);
			}
			return log;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * 根据用户id，查询登录日志
	 */
	public List<LoginLog> findLogByUser(int userId, int pager) {
		int totlePager = findTotlePager("where UserId=" + userId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUserLoginLog"
							+ " where UserId=" + userId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			logs = getLogs(res, pager, totlePager);
			return logs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return 获取登录日志信息
	 */
	public List<LoginLog> getLogs(ResultSet result, int pager, int totlePager) {
		logs = new ArrayList<LoginLog>();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				String userName = result.getString("UserName");
				String password = result.getString("PassWord");
				String loginDate = result.getString("LoginDate");
				int loginResult = result.getInt("LoginResult");
				String loginIp = result.getString("LoginIp");
				String remark = result.getString("Remark");
				LoginLog log = new LoginLog();
				log.setId(id);
				log.setUserId(userId);
				log.setUserName(userName);
				log.setPassword(password);
				log.setLoginDate(loginDate);
				log.setLoginResult(loginResult);
				log.setLoginIp(loginIp);
				log.setRemark(remark);
				log.setTotlePager(totlePager);
				log.setPager(pager);
				logs.add(log);
			}
			return logs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
