package com.rwm.api.dbresult;

public class RGetUserByUsernamePwd extends DBResult{

	public RGetUserByUsernamePwd() {
		addField("UserId", DataType.INTEGER, 0);
		addField("FullName", DataType.STRING, "");
		addField("RoleId", DataType.INTEGER, "");
		addField("RoleName", DataType.STRING, "");
	}

	public Integer geUserId() {
		return (Integer) this.getValue("UserId");
	}

	public String getFullName() {
		return (String) this.getValue("FullName");
	}
	public Integer getRoleId() {
		return (Integer) this.getValue("RoleId");
	}
	public String getRoleName() {
		return (String) this.getValue("RoleName");
	}

}
