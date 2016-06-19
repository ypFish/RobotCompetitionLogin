package com.yupeng.entity;

public class MaterialInfo {

	private int materialId;
	public MaterialInfo() {
		super();
	}
	public MaterialInfo(String materialName, int materialLimit,
			String materialURL) {
		super();
		this.materialName = materialName;
		this.materialLimit = materialLimit;
		this.materialURL = materialURL;
	}
	public MaterialInfo(int materialId, String materialName, int materialLimit,
			String materialURL, String remark) {
		super();
		this.materialId = materialId;
		this.materialName = materialName;
		this.materialLimit = materialLimit;
		this.materialURL = materialURL;
		this.remark = remark;
	}
	/**
	 * @return the materialId
	 */
	public int getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * @return the materialLimit
	 */
	public int getMaterialLimit() {
		return materialLimit;
	}
	/**
	 * @param materialLimit the materialLimit to set
	 */
	public void setMaterialLimit(int materialLimit) {
		this.materialLimit = materialLimit;
	}
	/**
	 * @return the materialURL
	 */
	public String getMaterialURL() {
		return materialURL;
	}
	/**
	 * @param materialURL the materialURL to set
	 */
	public void setMaterialURL(String materialURL) {
		this.materialURL = materialURL;
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
	private String materialName;
	private int materialLimit;
	private String materialURL;
	private String remark;
	
	
}
