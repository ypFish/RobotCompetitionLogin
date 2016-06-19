package com.yupeng.dao;

import java.util.List;

import com.yupeng.entity.MaterialInfo;

public interface MaterialInfoDao extends BaseDao{

		public int addAll(MaterialInfo mi);
		
		public int deleteByID(int materialId);
		
		public List<MaterialInfo> getList();
		
		public List<MaterialInfo> teamGetList();
		
		public List<MaterialInfo> publicGetList();
}
