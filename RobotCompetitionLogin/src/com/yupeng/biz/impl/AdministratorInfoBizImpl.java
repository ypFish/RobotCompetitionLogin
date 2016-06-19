package com.yupeng.biz.impl;

import com.yupeng.biz.AdministratorInfoBiz;
import com.yupeng.dao.AdministratorInfoDao;
import com.yupeng.dao.impl.AdministratorInfoDaoImpl;

public class AdministratorInfoBizImpl implements AdministratorInfoBiz {

	AdministratorInfoDao aid=new AdministratorInfoDaoImpl();
	public String getByAdministratorName(String administratorName) {
		// TODO Auto-generated method stub
		
		return aid.getByAdministratorName(administratorName);
	}

}
