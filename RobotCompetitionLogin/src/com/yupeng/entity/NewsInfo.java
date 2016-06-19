package com.yupeng.entity;

public class NewsInfo {

	private int newsId;
	private String newsName;
	private String newsContent;
	private String datetime;
	private String remark;
	/**
	 * @return the newsId
	 */
	public int getNewsId() {
		return newsId;
	}
	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	/**
	 * @return the newsName
	 */
	public String getNewsName() {
		return newsName;
	}
	/**
	 * @param newsName the newsName to set
	 */
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	/**
	 * @return the newsContent
	 */
	public String getNewsContent() {
		return newsContent;
	}
	/**
	 * @param newsContent the newsContent to set
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
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
	public NewsInfo(int newsId, String newsName, String newsContent,
			String datetime, String remark) {
		super();
		this.newsId = newsId;
		this.newsName = newsName;
		this.newsContent = newsContent;
		this.datetime = datetime;
		this.remark = remark;
	}
	public NewsInfo(String newsName, String newsContent, String remark) {
		super();
		this.newsName = newsName;
		this.newsContent = newsContent;
		this.remark = remark;
	}
	public NewsInfo() {
		super();
	}
	
	
}
