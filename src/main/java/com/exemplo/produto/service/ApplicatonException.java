package com.exemplo.produto.service;

public class ApplicatonException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplicatonException() {
	}
	
	public ApplicatonException(String message) {
		super(message);
	}

	public ApplicatonException(Throwable cause) {
		super(cause);
	}

}
