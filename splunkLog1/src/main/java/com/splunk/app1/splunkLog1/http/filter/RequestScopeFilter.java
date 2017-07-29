/**
 *
 */
package com.splunk.app1.splunkLog1.http.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ansharpasha
 *
 */
@Component
public class RequestScopeFilter implements Filter {

	@Autowired(required = true)
	private RequestScopeContext requestScopeContext;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		requestScopeContext.setRequestId(UUID.randomUUID().toString());
		requestScopeContext.setIpAddress(request.getRemoteAddr());
		requestScopeContext.setLoggedInUserId(httpServletRequest.getHeader("loggedInUserId") == null
				? Integer.parseInt(httpServletRequest.getHeader("brandUserId"))
				: Integer.parseInt(httpServletRequest.getHeader("loggedInUserId")));

		chain.doFilter(request, response);
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {

	}

}