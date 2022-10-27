package com.rwm.api.dbresult;

import java.util.Date;

public class RGetExInvLicenseDetailByInvLicenseId extends DBResult{

	public RGetExInvLicenseDetailByInvLicenseId() {
		addField("Serial", DataType.INTEGER, 0);
		addField("ItemSupId", DataType.STRING, "");
		addField("ItemName", DataType.STRING, "");
		addField("SupplierName", DataType.STRING, "");
		addField("ExpDate", DataType.DATE, "");
		addField("Quantity", DataType.FLOAT, 0);
		addField("QuantityUnitName", DataType.STRING, "");
	}
	public Integer getSerial() {
		return (Integer) this.getValue("Serial");
	}
	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
	}
	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public Date getExpDate() {
		return (Date) this.getValue("ExpDate");
	}
	public Float getQuantity() {
		return (Float) this.getValue("Quantity");
	}
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}


}
