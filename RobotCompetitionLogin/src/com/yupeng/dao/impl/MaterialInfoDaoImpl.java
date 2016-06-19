package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.MaterialInfoDao;
import com.yupeng.entity.MaterialInfo;

public class MaterialInfoDaoImpl extends BaseDaoImpl implements MaterialInfoDao {

	
	
	public int addAll(MaterialInfo mi){
		// TODO Auto-generated method stub
		this.openCon();
		String sql="insert into materialInfo(materialName,materialLimit,materialURL) values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,mi.getMaterialName());
			ps.setInt(2,mi.getMaterialLimit());
			ps.setString(3, mi.getMaterialURL());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num ;
	}
	
	public int deleteByID(int materialId){
		
		this.openCon();
		String sql="delete from materialInfo where materialId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, materialId);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			this.closeAll();
		}
		
		return num;
	}
	
	public List<MaterialInfo> getList(){
		
		this.openCon();
		List<MaterialInfo> list=new ArrayList<MaterialInfo>();
		String sql="select materialId,materialName,materialLimit,materialURL from materialInfo";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				MaterialInfo mi=new MaterialInfo();
				mi.setMaterialId(rs.getInt("materialId"));
				mi.setMaterialName(rs.getString("materialName"));
				mi.setMaterialLimit(rs.getInt("materialLimit"));
				mi.setMaterialURL(rs.getString("materialURL"));
				mi.setRemark("");
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			this.closeAll();
		}
		return list;
		
	}
	
	public List<MaterialInfo> teamGetList(){
		this.openCon();
		List<MaterialInfo> list=new ArrayList<MaterialInfo>();
		String sql="select top 15 materialId,materialName,materialLimit,materialURL from materialInfo where materialLimit>1 order by materialId desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				MaterialInfo mi=new MaterialInfo();
				mi.setMaterialId(rs.getInt("materialId"));
				mi.setMaterialName(rs.getString("materialName"));
				mi.setMaterialLimit(rs.getInt("materialLimit"));
				mi.setMaterialURL(rs.getString("materialURL"));
				mi.setRemark("");
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			this.closeAll();
		}
		return list;
		
		
	}

	public List<MaterialInfo> publicGetList() {
		// TODO Auto-generated method stub
		this.openCon();
		List<MaterialInfo> list=new ArrayList<MaterialInfo>();
		String sql="select top 15 materialId,materialName,materialLimit,materialURL from materialInfo where materialLimit>2 order by materialId desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				MaterialInfo mi=new MaterialInfo();
				mi.setMaterialId(rs.getInt("materialId"));
				mi.setMaterialName(rs.getString("materialName"));
				mi.setMaterialLimit(rs.getInt("materialLimit"));
				mi.setMaterialURL(rs.getString("materialURL"));
				mi.setRemark("");
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			this.closeAll();
		}
		return list;
	}

}
