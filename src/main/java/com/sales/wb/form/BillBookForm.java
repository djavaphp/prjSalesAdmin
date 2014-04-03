package com.sales.wb.form;

/**
 * @author kbjani
 *
 */
public class BillBookForm {
	private String billbookId;
	private String billbooknum;
	private String startrange;
	private String endrange;
	/**
	 * @param billbookId
	 * @param billbooknum
	 * @param startrange
	 * @param endrange
	 */
	public BillBookForm(String billbookId, String billbooknum,
			String startrange, String endrange) {
		this.billbookId = billbookId;
		this.billbooknum = billbooknum;
		this.startrange = startrange;
		this.endrange = endrange;
	}
	
	public BillBookForm() {
	}
	public String getBillbookId() {
		return billbookId;
	}
	public void setBillbookId(String billbookId) {
		this.billbookId = billbookId;
	}
	public String getBillbooknum() {
		return billbooknum;
	}
	public void setBillbooknum(String billbooknum) {
		this.billbooknum = billbooknum;
	}
	public String getStartrange() {
		return startrange;
	}
	public void setStartrange(String startrange) {
		this.startrange = startrange;
	}
	public String getEndrange() {
		return endrange;
	}
	public void setEndrange(String endrange) {
		this.endrange = endrange;
	}
	

}
