package com.rwm.api.dbresult;

import java.sql.Timestamp;

public class RSearchInvoiceLicense extends DBResult{

	public RSearchInvoiceLicense() {
		addField("InvoiceLicenseId", DataType.STRING, 0);
		addField("SupplierName", DataType.STRING, "");
		addField("TotalQuantity", DataType.FLOAT, "");
		addField("Payment", DataType.INTEGER, "");
		addField("CreatedDate", DataType.TIMESTAMP, 0);
		addField("CreatedUser", DataType.INTEGER, 0);
		addField("Note", DataType.STRING, "");
	}

	public String getInvoiceLicenseId() {
		return (String) this.getValue("InvoiceLicenseId");
	}

	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public Float getTotalQuantity() {
		return (Float) this.getValue("TotalQuantity");
	}
	public Integer getPayment() {
		return (Integer) this.getValue("Payment");
	}
	public Timestamp getCreatedDate() {
		return (Timestamp) this.getValue("CreatedDate");
	}
	public Integer getCreatedUser() {
		return (Integer) this.getValue("CreatedUser");
	}
	public String getNote() {
		return (String) this.getValue("Note");
	}

}
