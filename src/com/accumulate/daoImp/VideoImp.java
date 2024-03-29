package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.VideoDao;
import com.accumulate.entity.Video;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class VideoImp implements VideoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Video> videos = new ArrayList<Video>();

	public List<Video> findAll() {
		// 获取所有视频信息
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPVideo order by InsertDate desc");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String ImagesThumb = res.getString(SqlUtil.VIDEO_IMAGETHUMB);
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setImagesThumb(ImagesThumb);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}
		return null;
	}

	public List<Video> findVideoByClassId(int classId) {
		// 根据分类获取视频列表
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where ClassId="
					+ classId + " order by InsertDate desc");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String ImagesThumb = res.getString(SqlUtil.VIDEO_IMAGETHUMB);
				int isMySiteVideo = res.getInt("IsMySiteVideo");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setIsMySiteVideo(isMySiteVideo);
				video.setImagesThumb(ImagesThumb);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Video findVideoById(int id) {
		// 根据id 获取视频详细信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,Title,KeyWords,HitCount,InsertDate,Descriptions from JCPVideo where Id="
							+ id);
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String keyWord = res.getString(SqlUtil.VIDEO_KEYWORD);
				String insertDate = res.getString(SqlUtil.VIDEO_INSERTDATE);
				int hitCount = res.getInt(SqlUtil.VIDEO_HITCOUNT);
				String Descriptions = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(vId, title);
				video.setKeyWords(keyWord);
				video.setInsertDate(insertDate);
				video.setHitCount(hitCount);
				video.setDescript(Descriptions);
				return video;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Video findVideoRecouresById(int id) {
		// 根据id 获取视频资源信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,Title,VideoUrl from JCPVideo where Id="
							+ id);
			res.next();
			int Vid = res.getInt(SqlUtil.NEWS_ID);
			String title = res.getString(SqlUtil.VIDEO_TITLE);
			String videoUrl = res.getString(SqlUtil.VIDEO_URL);
			Video video = new Video(Vid, title);
			video.setVideoUrl(videoUrl);
			return video;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsIndex(int isIndex) {
		// 获取首页视频
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsIndex="
					+ isIndex + " order by InsertDate desc");
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String images = res.getString(SqlUtil.VIDEO_IMAGES);
				String imageThumb = res.getString(SqlUtil.VIDEO_IMAGETHUMB);
				Video video = new Video(vId, title);
				video.setImages(images);
				video.setImagesThumb(imageThumb);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsReComm(int isRecomm) {
		videos.clear();
		// 获取推荐视频
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsTuijian="
					+ isRecomm);
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String images = res.getString(SqlUtil.VIDEO_IMAGES);
				String imageThumb = res.getString(SqlUtil.VIDEO_IMAGETHUMB);
				Video video = new Video(vId, title);
				video.setImages(images);
				video.setImagesThumb(imageThumb);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsTop(int isTop) {
		// 查询置顶新闻
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsTop="
					+ isTop);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsPublic(int isPublic) {
		// 查询公开课视频
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsPublic="
					+ isPublic);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsMySite(int isMySite) {
		// 查询本站视频
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPVideo where IsMySiteVideo="
							+ isMySite);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}

		return null;
	}

	public List<Video> findVideoByIndexId(int isIndex, int classId) {
		// 根据分类获取首页视频列表
		//-----classId   3
		String liveIndex=2+","+3+","+4+","+5+","+6+","+7+","+8;	
		//----classId 11
		String SchoolIndex=10+","+11+","+12+","+13+","+14+","+15+","+16;		
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			if(classId==3){
				res = sta
						.executeQuery("select Top 2 Id,Title,Images,ImagesThumb from JCPVideo where ClassId in ("
								+ liveIndex+") order by Id desc");
			}else {
				res = sta
						.executeQuery("select Top 2 Id,Title,Images,ImagesThumb from JCPVideo where ClassId in ("
								+ SchoolIndex+") order by Id desc");
			}
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String ImagesThumb = res.getString(SqlUtil.VIDEO_IMAGETHUMB);
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setImagesThumb(ImagesThumb);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Video> findVideoByIsRecommId(int isRecomm, int classId) {
		// 查询推荐下的分类信息
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsTuijian="
					+ isRecomm + " ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}
		return null;
	}

	public List<Video> findVideoByIsTopId(int isTop, int classId) {
		// 查询置顶的分类信息
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from IsTop=" + isTop + " ClassId="
					+ classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}
		return null;
	}

	public List<Video> findVideoByIsPublicId(int isPublic, int classId) {
		// 查询分类下的公开课
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideo where IsPublic="
					+ isPublic + " ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DATE);
				Video video = new Video(id, title);
				video.setDescript(descript);
			}
			return videos;
		} catch (Exception e) {
		}

		return null;
	}

	public List<Video> findVideoByMySitId(int isMySit, int classId) {
		// 查询分类下的本站视频
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPVideo where IsMySiteVideo="
							+ isMySit + " ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}
		return null;
	}

}
