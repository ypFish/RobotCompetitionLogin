package com.yupeng.biz.impl;

import com.yupeng.biz.ResultInfoBiz;
import com.yupeng.dao.ResultInfoDao;
import com.yupeng.dao.impl.ResultInfoDaoImpl;
import com.yupeng.entity.ResultInfo;

public class ResultInfoBizImpl implements ResultInfoBiz {

	ResultInfoDao rid=new ResultInfoDaoImpl();
	
	public int add(ResultInfo ri) {
		// TODO Auto-generated method stub
		return rid.add(ri);
	}

	public String getResultName(int teamId) {
		// TODO Auto-generated method stub
		return rid.getResultName(teamId);
	}

	public int update(ResultInfo ri) {
		// TODO Auto-generated method stub
		return rid.update(ri);
	}

}
