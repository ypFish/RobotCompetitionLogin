package com.yupeng.entity;

public class ResultInfo {

	private int resultId;
	private int teamId;
	private String resultName;
	private String remark;
	
	public ResultInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultInfo(int resultId, int teamId, String resultName, String remark) {
		super();
		this.resultId = resultId;
		this.teamId = teamId;
		this.resultName = resultName;
		this.remark = remark;
	}
	/**
	 * @return the resultId
	 */
	public int getResultId() {
		return resultId;
	}
	/**
	 * @param resultId the resultId to set
	 */
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the resultName
	 */
	public String getResultName() {
		return resultName;
	}
	/**
	 * @param resultName the resultName to set
	 */
	public void setResultName(String resultName) {
		this.resultName = resultName;
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
}
