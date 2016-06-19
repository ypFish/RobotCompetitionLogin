package com.yupeng.entity;

public class SubjectInfo {

	
	private int subjectId;
	private String subjectName;
	private int peopleNumber;
	private String subjectInformation;
	private String remark;
	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}
	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * @return the peopleNumber
	 */
	public int getPeopleNumber() {
		return peopleNumber;
	}
	/**
	 * @param peopleNumber the peopleNumber to set
	 */
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	/**
	 * @return the subjectInformation
	 */
	public String getSubjectInformation() {
		return subjectInformation;
	}
	/**
	 * @param subjectInformation the subjectInformation to set
	 */
	public void setSubjectInformation(String subjectInformation) {
		this.subjectInformation = subjectInformation;
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
	public SubjectInfo(int subjectId, String subjectName, int peopleNumber,
			String subjectInformation, String remark) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.peopleNumber = peopleNumber;
		this.subjectInformation = subjectInformation;
		this.remark = remark;
	}
	public SubjectInfo(String subjectName, int peopleNumber,
			String subjectInformation, String remark) {
		super();
		this.subjectName = subjectName;
		this.peopleNumber = peopleNumber;
		this.subjectInformation = subjectInformation;
		this.remark = remark;
	}
	public SubjectInfo() {
		super();
	}
	
	
}
