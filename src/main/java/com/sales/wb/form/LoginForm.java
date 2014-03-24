package com.sales.wb.form;

/**
 * @author kbjani
 *
 */
public class LoginForm {
	private String empCode;
	private String password;
	/**
	 * @param empCode
	 * @param password
	 */
	public LoginForm(String empCode, String password) {
		this.empCode = empCode;
		this.password = password;
	}
	
	public LoginForm() {
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
