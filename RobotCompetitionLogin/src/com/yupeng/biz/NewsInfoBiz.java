package com.yupeng.biz;

import java.util.List;

import com.yupeng.entity.NewsInfo;


public interface NewsInfoBiz {

	public int addAll(NewsInfo newsInfo);
	
	public List<NewsInfo> getAll();
	
	public int deleteById(int NewsId);
	
	public int updateById(NewsInfo ni);
	
	public List<NewsInfo> getAllNews();
	
	public NewsInfo getNewsById(int newsId);
	
}
