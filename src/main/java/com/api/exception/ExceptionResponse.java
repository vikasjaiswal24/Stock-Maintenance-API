package com.api.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date errorOccurredTimestamp;
	private String errorMessage;
	private String details;

	public ExceptionResponse(Date errorOccurredTimestamp, String errorMessage, String details) {
		super();
		this.errorOccurredTimestamp = errorOccurredTimestamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public Date getErrorOccurredTimestamp() {
		return errorOccurredTimestamp;
	}

	public void setErrorOccurredTimestamp(Date errorOccurredTimestamp) {
		this.errorOccurredTimestamp = errorOccurredTimestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}