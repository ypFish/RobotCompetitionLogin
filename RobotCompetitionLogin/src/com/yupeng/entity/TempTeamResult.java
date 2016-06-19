package com.yupeng.entity;

import java.util.List;

public class TempTeamResult {

	private int ttSubjectId;
	/**
	 * @return the ttSubjectId
	 */
	public int getTtSubjectId() {
		return ttSubjectId;
	}
	/**
	 * @param ttSubjectId the ttSubjectId to set
	 */
	public void setTtSubjectId(int ttSubjectId) {
		this.ttSubjectId = ttSubjectId;
	}
	private String ttSubjectName;
	private int ttTeamId;
	private String ttTeamName;
	private List<StudentInfo> ttListStudentInfo ;
	private String rewardName;
	/**
	 * @return the ttSubjectName
	 */
	public TempTeamResult(int ttSubjectId) {
		super();
		this.ttSubjectId = ttSubjectId;
	}
	public String getTtSubjectName() {
		return ttSubjectName;
	}
	/**
	 * @param ttSubjectName the ttSubjectName to set
	 */
	public void setTtSubjectName(String ttSubjectName) {
		this.ttSubjectName = ttSubjectName;
	}
	/**
	 * @return the ttTeamId
	 */
	public int getTtTeamId() {
		return ttTeamId;
	}
	/**
	 * @param ttTeamId the ttTeamId to set
	 */
	public void setTtTeamId(int ttTeamId) {
		this.ttTeamId = ttTeamId;
	}
	/**
	 * @return the ttTeamName
	 */
	public String getTtTeamName() {
		return ttTeamName;
	}
	/**
	 * @param ttTeamName the ttTeamName to set
	 */
	public void setTtTeamName(String ttTeamName) {
		this.ttTeamName = ttTeamName;
	}
	/**
	 * @return the ttListStudentInfo
	 */
	public List<StudentInfo> getTtListStudentInfo() {
		return ttListStudentInfo;
	}
	/**
	 * @param ttListStudentInfo the ttListStudentInfo to set
	 */
	public void setTtListStudentInfo(List<StudentInfo> ttListStudentInfo) {
		this.ttListStudentInfo = ttListStudentInfo;
	}
	/**
	 * @return the rewardName
	 */
	public String getRewardName() {
		return rewardName;
	}
	/**
	 * @param rewardName the rewardName to set
	 */
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public TempTeamResult(String ttSubjectName, int ttTeamId,
			String ttTeamName, List<StudentInfo> ttListStudentInfo,
			String rewardName) {
		super();
		this.ttSubjectName = ttSubjectName;
		this.ttTeamId = ttTeamId;
		this.ttTeamName = ttTeamName;
		this.ttListStudentInfo = ttListStudentInfo;
		this.rewardName = rewardName;
	}
	public TempTeamResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TempTeamResult(int ttSubjectId, String ttSubjectName, int ttTeamId,
			String ttTeamName, List<StudentInfo> ttListStudentInfo,
			String rewardName) {
		super();
		this.ttSubjectId = ttSubjectId;
		this.ttSubjectName = ttSubjectName;
		this.ttTeamId = ttTeamId;
		this.ttTeamName = ttTeamName;
		this.ttListStudentInfo = ttListStudentInfo;
		this.rewardName = rewardName;
	}
	
	
}
