package com.rwm.api.validation.jwt;

import com.google.gson.JsonObject;
import com.rwm.api.resources.MRes;
import com.rwm.api.utils.IOUtils;
import com.rwm.api.utils.JsonUtil;
import com.rwm.api.utils.OBJ;

import java.io.InputStream;

public class JWTConfig {

	private static JWTConfig ins = null;
	public final String key;

	public JWTConfig() throws Exception {
		try (InputStream in = MRes.getResourceStream("conf/jwtConfig.conf")) {
			System.out.println(in);
			JsonObject json = JsonUtil.gson.fromJson((String) OBJ.unZip(IOUtils.toString(in, "UTF-8")),
					JsonObject.class);
			key = json.get("key").getAsString();
			System.out.println(key);
		}
	}

	public static JWTConfig ins() throws Exception {
		if (ins == null) {
			ins = new JWTConfig();
		}
		return ins;
	}

}
