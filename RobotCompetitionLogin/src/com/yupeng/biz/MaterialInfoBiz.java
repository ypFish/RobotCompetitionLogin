package com.yupeng.biz;

import java.util.List;

import com.yupeng.entity.MaterialInfo;

public interface MaterialInfoBiz {
	
	public int addAll(MaterialInfo mi);
	
	public List<MaterialInfo> getList();
	
	public int deleteByID(int materialId);

	public List<MaterialInfo> teamGetList();
	
	public List<MaterialInfo> publicGetList();
}
