package com.rwm.api.dbresult;

public class RGetSupplier extends DBResult{

	public RGetSupplier() {
		addField("SupplierId", DataType.INTEGER, 0);
		addField("SupplierName", DataType.STRING, "");
	}

	public Integer getSupplierId() {
		return (Integer) this.getValue("SupplierId");
	}

	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
}
