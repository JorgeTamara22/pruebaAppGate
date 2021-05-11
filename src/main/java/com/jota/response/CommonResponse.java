package com.jota.response;

import java.io.Serializable;
import java.util.List;

public class CommonResponse<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private String token;
	private String status;
	private List<String> messages;
	private T value;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
