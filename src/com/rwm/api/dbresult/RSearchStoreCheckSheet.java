package com.rwm.api.dbresult;

import java.sql.Timestamp;

public class RSearchStoreCheckSheet extends DBResult{

	public RSearchStoreCheckSheet() {
		addField("CheckSheetId", DataType.INTEGER, 0);
		addField("CreatedUser", DataType.INTEGER, "");
		addField("FullName", DataType.STRING, "");
		addField("CreatedDate", DataType.TIMESTAMP, 0);
		addField("Note", DataType.STRING, "");
	}

	public Integer getCheckSheetId() {
		return (Integer) this.getValue("CheckSheetId");
	}
	public Integer getCreatedUser() {
		return (Integer) this.getValue("CreatedUser");
	}
	public String getFullName() {
		return (String) this.getValue("FullName");
	}
	public Timestamp getCreatedDate() {
		return (Timestamp) this.getValue("CreatedDate");
	}
	public String getNote() {
		return (String) this.getValue("Note");
	}

}
