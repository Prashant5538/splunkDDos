package com.splunk.ddos.splunkDDos.dto;

public class EmailDTO {

	private String body;
	private String fromAdd;
	private String subject;
	private String toAdd;
	private String toName;

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @return the fromAdd
	 */
	public String getFromAdd() {
		return fromAdd;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the toAdd
	 */
	public String getToAdd() {
		return toAdd;
	}

	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(final String body) {
		this.body = body;
	}

	/**
	 * @param fromAdd the fromAdd to set
	 */
	public void setFromAdd(final String fromAdd) {
		this.fromAdd = fromAdd;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	/**
	 * @param toAdd the toAdd to set
	 */
	public void setToAdd(final String toAdd) {
		this.toAdd = toAdd;
	}

	/**
	 * @param toName the toName to set
	 */
	public void setToName(final String toName) {
		this.toName = toName;
	}

}
