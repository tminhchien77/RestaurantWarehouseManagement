package com.rwm.api.dbresult;

public class RGetQuantityUnit extends DBResult{

	public RGetQuantityUnit() {
		addField("QuantityUnitId", DataType.INTEGER, 0);
		addField("QuantityUnitName", DataType.STRING, "");
		addField("QuantityUnitNote", DataType.STRING, "");
	}

	public Integer getQuantityUnitId() {
		return (Integer) this.getValue("QuantityUnitId");
	}

	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}
	public String getQuantityUnitNote() {
		return (String) this.getValue("QuantityUnitNote");
	}
}
