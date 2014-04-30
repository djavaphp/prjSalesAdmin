package com.sales.wb.form;

/**
 * @author kbjani
 *
 */
public class RoleForm {
	private String roleId;
	private String roleDesc;
	/**
	 * @param roleId
	 * @param roleDesc
	 */
	public RoleForm(String roleId, String roleDesc) {
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}
	
	public RoleForm() {
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
