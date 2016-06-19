package com.yupeng.dao;

import com.yupeng.entity.ResultInfo;

public interface ResultInfoDao {

	public String getResultName(int teamId);
	
	public int add(ResultInfo ri);
	
	public int update(ResultInfo ri);
}
