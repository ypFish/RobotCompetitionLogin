package com.yupeng.entity;

public class StudentInfo {

	private String studentId;
	private String studentName;
	private String studentInstitute;
	private String studentPhone;
	private String studentEmail;
	private String remark;
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentInstitute
	 */
	public String getStudentInstitute() {
		return studentInstitute;
	}
	/**
	 * @param studentInstitute the studentInstitute to set
	 */
	public void setStudentInstitute(String studentInstitute) {
		this.studentInstitute = studentInstitute;
	}
	/**
	 * @return the studentPhone
	 */
	public String getStudentPhone() {
		return studentPhone;
	}
	/**
	 * @param studentPhone the studentPhone to set
	 */
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	/**
	 * @return the studentEmail
	 */
	public String getStudentEmail() {
		return studentEmail;
	}
	/**
	 * @param studentEmail the studentEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
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
	public StudentInfo(String studentId, String studentName,
			String studentInstitute, String studentPhone, String studentEmail,
			String remark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentInstitute = studentInstitute;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.remark = remark;
	}
	public StudentInfo() {
		super();
	}
	
	
}
