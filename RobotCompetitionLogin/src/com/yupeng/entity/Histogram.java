package com.yupeng.entity;

public class Histogram {

	private String name;
	private int per;
	public Histogram() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the per
	 */
	public int getPer() {
		return per;
	}
	/**
	 * @param per the per to set
	 */
	public void setPer(int per) {
		this.per = per;
	}
	public Histogram(String name, int per) {
		super();
		this.name = name;
		this.per = per;
	}
}
