package com.hdv.api.dbresult;

public class RGetRole extends DBResult{

	public RGetRole() {
		addField("id", DataType.INTEGER, 0);
		addField("roleName", DataType.STRING, "");
	}

	public Integer getId() {
		return (Integer) this.getValue("id");
	}

	public String getRoleName() {
		return (String) this.getValue("roleName");
	}
}
