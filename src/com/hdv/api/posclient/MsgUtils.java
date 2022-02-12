package com.hdv.api.posclient;

import com.hdv.api.posclient.webservice.ERPWsExp;
import com.hdv.api.resources.I18n;

import javax.swing.*;
import java.sql.Timestamp;

public class MsgUtils {

	private static String errorMsg = "";

	public static void showMsg(String msg) {
	}

	public static void showMsg(String msg, ImageIcon icon) {
	}

	public static void showWarnMsg(String msg) {
	}

	public static void showErrorMsg(String msg, Exception e) {
		if (e instanceof ERPWsExp) {
			errorMsg = ((ERPWsExp) e).getErrorMsg();
		} 
		else {
			errorMsg = e.toString();
		}
	}

	public static void showErrorMsg(Exception e) {
		MsgUtils.showErrorMsg(I18n.get("anErrorOccurred"), e);
	}

	public static void showErrorMsg(String msg) {
	}
	
	public static String getErrorMsg() {
		return errorMsg;
	}
	
	public static void logConsole(String msg) {
		System.out.println(msg + " " + new Timestamp(System.currentTimeMillis()));
	}
	
}
