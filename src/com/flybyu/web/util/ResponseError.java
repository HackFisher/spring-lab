package com.flybyu.web.util;

public class ResponseError {
	public static int ERROR_FAILURE = 1;
	public static int ERROR_EXCEPTION = 2;
	
	private int errorCode;
	private String errorMessage;
	
	public ResponseError (int code, String message) {
		this.setErrorCode(code);
		this.setErrorMessage(message);
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
