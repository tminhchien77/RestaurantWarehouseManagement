package com.rwm.api.dbresult;

public class RSearchSupplier extends DBResult{

	public RSearchSupplier() {
		addField("SupplierId", DataType.INTEGER, 0);
		addField("SupplierName", DataType.STRING, "");
		addField("Address", DataType.STRING, "");
		addField("Phone", DataType.STRING, "");
		addField("Email", DataType.STRING, "");
		addField("Fax", DataType.STRING, "");
	}

	public Integer getSupplierId() {
		return (Integer) this.getValue("SupplierId");
	}

	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public String getAddress() {
		return (String) this.getValue("Address");
	}
	public String getPhone() {
		return (String) this.getValue("Phone");
	}
	public String getEmail() {
		return (String) this.getValue("Email");
	}
	public String getFax() {
		return (String) this.getValue("Fax");
	}
}
