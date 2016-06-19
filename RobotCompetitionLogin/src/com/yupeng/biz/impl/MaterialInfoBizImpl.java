package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.MaterialInfoBiz;
import com.yupeng.dao.MaterialInfoDao;
import com.yupeng.dao.impl.MaterialInfoDaoImpl;
import com.yupeng.entity.MaterialInfo;

public class MaterialInfoBizImpl implements MaterialInfoBiz {

	MaterialInfoDao mid=new MaterialInfoDaoImpl();
	
	public int addAll(MaterialInfo mi) {
		// TODO Auto-generated method stub
		return mid.addAll(mi);
	}
	
	public List<MaterialInfo> getList(){
		return mid.getList();
	}
	
	public int deleteByID(int materialId){
		
		return mid.deleteByID(materialId);
	}
	
	public List<MaterialInfo> teamGetList(){
		
		return mid.teamGetList();
	}

	public List<MaterialInfo> publicGetList() {
		// TODO Auto-generated method stub
		return mid.publicGetList();
	}

}
