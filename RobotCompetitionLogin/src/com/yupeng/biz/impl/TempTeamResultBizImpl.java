package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.TempTeamResultDaoBiz;
import com.yupeng.dao.TempTeamResultDao;
import com.yupeng.dao.impl.TempTeamResultDaoImpl;
import com.yupeng.entity.TempTeamResult;

public class TempTeamResultBizImpl implements TempTeamResultDaoBiz {

	TempTeamResultDao ttd=new TempTeamResultDaoImpl();
	
	public List<TempTeamResult> getAllTempTeamResult() {
		// TODO Auto-generated method stub
		return ttd.getAllTempTeamResult();
	}

}
