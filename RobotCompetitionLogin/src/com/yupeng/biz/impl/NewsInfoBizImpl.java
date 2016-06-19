package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.NewsInfoBiz;
import com.yupeng.dao.NewsInfoDao;
import com.yupeng.dao.impl.NewsInfoDaoImpl;
import com.yupeng.entity.NewsInfo;

public class NewsInfoBizImpl implements NewsInfoBiz {

	NewsInfoDao nd=new NewsInfoDaoImpl();
	public int addAll(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		return nd.addAll(newsInfo);
	}

	public List<NewsInfo> getAll(){
		
		return nd.getAll();
	}
	
	public int deleteById(int NewsId){
		
		return nd.deleteById(NewsId);
	}
	
	public int updateById(NewsInfo ni){
		
		return nd.updateById(ni);
	}
	
	public List<NewsInfo> getAllNews(){
		return nd.getAllNews();
	}
	
	public NewsInfo getNewsById(int newsId){
		
		return nd.getNewsById(newsId);
	}
}
