package com.rwm.api.dbresult;

public class RGetItemSup extends DBResult{

	public RGetItemSup() {
		addField("ItemSupId", DataType.STRING, 0);
		addField("SupplierId", DataType.INTEGER, "");
		addField("SupplierName", DataType.STRING, "");
		addField("QuantityUnitId", DataType.INTEGER, "");
		addField("QuantityUnitName", DataType.STRING, "");
	}

	public Integer getItemSupId() {
		return (Integer) this.getValue("ItemSupId");
	}
	public Integer getSupplierId() {
		return (Integer) this.getValue("SupplierId");
	}
	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public Integer getQuantityUnitId() {
		return (Integer) this.getValue("QuantityUnitId");
	}
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}

}
