package com.yupeng.biz;

import com.yupeng.entity.ResultInfo;

public interface ResultInfoBiz {

	public int add(ResultInfo ri);
	public String getResultName(int teamId);
	public int update(ResultInfo ri);
}
