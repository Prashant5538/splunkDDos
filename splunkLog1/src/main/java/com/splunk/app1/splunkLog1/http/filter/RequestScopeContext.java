/**
 *
 */
package com.splunk.app1.splunkLog1.http.filter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author ansharpasha
 *
 */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RequestScopeContext {

	private String ipAddress;
	private Integer loggedInUserId;
	private String requestId;

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the loggedInUserId
	 */
	public Integer getLoggedInUserId() {
		return loggedInUserId;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @param loggedInUserId the loggedInUserId to set
	 */
	public void setLoggedInUserId(final Integer loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(final String requestId) {
		this.requestId = requestId;
	}

}
