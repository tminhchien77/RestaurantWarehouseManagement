package com.rwm.api.dbresult;

public class RGetAllItem extends DBResult{

	public RGetAllItem() {
		addField("ItemId", DataType.INTEGER, 0);
		addField("ItemName", DataType.STRING, "");
	}

	public Integer getItemId() {
		return (Integer) this.getValue("ItemId");
	}
	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
}
