package com.example.demo.stock;

public class FileUploadException extends Exception {

	private static final long serialVersionUID = -5119078875349679782L;

	private String message;

	public FileUploadException(String msg) {
		this.message = msg;
	}

	public String getMsg() {
		return this.message;
	}

}
