package com.hdv.api.validation.jwt;

import com.hdv.api.entities.APIResponse;
import com.hdv.api.entities.ResponseCode;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Objects;

public class JWTHelper{

	private boolean verify(String token) {
		boolean isVerify = false;
		try {
			if(token == null)
				return isVerify;

			if (Objects.equals(Jwts.parser().setSigningKey(JWTConfig.key).parseClaimsJws(token).getHeader().getAlgorithm(),
					String.valueOf(SignatureAlgorithm.HS256))) {
				return true;
			}
			
		} catch (Exception e) {
			isVerify = false;
		}
		return isVerify;
	}
	
	public APIResponse doJWT(String ver, String func, String token) throws Exception {
		APIResponse response = null;
		final long startTime = System.currentTimeMillis();
		if(!verify(token)) {
			response = new APIResponse(new ResponseCode(401, "AUTHENTICATION_ERROR", "Unauthorized.Please add a valid Token"));
			response.getResponseCode().setExeInMills(System.currentTimeMillis() - startTime).setUsername("username").setVersion(ver).setFunction(func);
		}
		return response;
	}
}