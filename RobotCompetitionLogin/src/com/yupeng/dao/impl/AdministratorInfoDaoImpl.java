package com.yupeng.dao.impl;

import java.sql.SQLException;

import com.yupeng.dao.AdministratorInfoDao;

public class AdministratorInfoDaoImpl extends BaseDaoImpl implements AdministratorInfoDao {

	public String getByAdministratorName(String administratorName) {
		// TODO Auto-generated method stub
		this.openCon();
		String adminPassword="";
		String sql="select administratorPassword from administratorInfo where administratorName=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,administratorName);
			rs=ps.executeQuery();
			while(rs.next()){
				adminPassword=rs.getString("administratorPassword");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return adminPassword;
	}

}
