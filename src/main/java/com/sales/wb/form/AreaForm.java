package com.sales.wb.form;

public class AreaForm {
	private String areaID;
	private String areaCode;
	private String areaName;
	/**
	 * @param areaID
	 * @param areaCode
	 * @param areaName
	 */
	public AreaForm(String areaID, String areaCode, String areaName) {
		this.areaID = areaID;
		this.areaCode = areaCode;
		this.areaName = areaName;
	}	
	public AreaForm() {
	}
	public String getAreaID() {
		return areaID;
	}
	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	
}
