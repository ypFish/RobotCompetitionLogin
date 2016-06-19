package com.yupeng.dao;

import java.util.List;

import com.yupeng.entity.NewsInfo;
import com.yupeng.entity.SubjectInfo;

public interface NewsInfoDao extends BaseDao {

	public int addAll(NewsInfo newsInfo);
	
	public List<NewsInfo> getAll();
	
	public int deleteById(int NewsId);
	
	public int updateById(NewsInfo ni);
	
	public List<NewsInfo> getAllNews();
	
	public NewsInfo getNewsById(int newsId);
}
