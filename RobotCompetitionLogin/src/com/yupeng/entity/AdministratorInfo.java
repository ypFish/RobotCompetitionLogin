package com.yupeng.entity;

public class AdministratorInfo {

	private String administratorName;
	private String administratorPassword;
	private String remark;
	/**
	 * @return the administratorName
	 */
	public String getAdministratorName() {
		return administratorName;
	}
	/**
	 * @param administratorName the administratorName to set
	 */
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	/**
	 * @return the administratorPassword
	 */
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	/**
	 * @param administratorPassword the administratorPassword to set
	 */
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public AdministratorInfo(String administratorName,
			String administratorPassword, String remark) {
		super();
		this.administratorName = administratorName;
		this.administratorPassword = administratorPassword;
		this.remark = remark;
	}
	public AdministratorInfo() {
		super();
	}
	
}
