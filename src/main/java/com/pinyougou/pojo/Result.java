package com.pinyougou.pojo;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442358910401140692L;
	private boolean success;
	private String message;

	public Result() {
		super();
	}
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + (success ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (success != other.success)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + "]";
	}
	
	
}
