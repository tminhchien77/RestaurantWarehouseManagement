package com.hdv.api.handlers;


import com.hdv.api.configs.PgDBConfig;
import com.hdv.api.entities.request.DemoPayload;
import com.hdv.api.entities.response.DemoResponseData;
//import com.hdv.api.validation.RequestValidationHelper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.TimeZone;

public class GetDemoHandler extends APIHandler<DemoPayload, DemoResponseData> {

	static {
		System.setProperty("file.encoding", "UTF-8");
		TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
	}

	public GetDemoHandler() {
		super(DemoPayload.class);
	}

	@SuppressWarnings("unused")
	@Override
	protected synchronized DemoResponseData handle(DemoPayload request) throws Exception {
		// Validate request
		//RequestValidationHelper.validateRequest(request);
		// ======================================================================
		DemoResponseData response = new DemoResponseData();

		return response;
	}
}