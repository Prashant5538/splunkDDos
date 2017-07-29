package com.splunk.app1.splunkLog1.utility;

/**
 *
 */

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

/**
 * @author prashantkumar
 *
 */
public class HttpClientService {
	// private static final Logger log = Logger.getLogger("HttpClientService");
	// private static Logger log = LogManager.getLogger("HttpClientService");

	public static Object executeDeleteRequest(final String url, final List<NameValuePair> urlParameters) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		final String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
		final HttpDelete delete = new HttpDelete(url + queryString);
		try {
			response = client.execute(delete);
		}
		catch (final IOException e) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		return response;
	}

	public static Object executeGetRequest(String url, final List<NameValuePair> urlParameters) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		if (urlParameters.size() != 0) {
			final String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
			url = url + "?" + queryString;
		}
		final HttpGet get = new HttpGet(url);
		try {
			response = client.execute(get);
		}
		catch (final IOException e) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		return response;
	}

	public static Object executeGetRequestWithHeaders(String url, final List<NameValuePair> urlParameters,
			final Map<String, String> headers) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		if (urlParameters.size() != 0) {
			final String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
			url = url + "?" + queryString;
		}
		final HttpGet get = new HttpGet(url);
		get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		for (final Entry<String, String> head : headers.entrySet()) {
			get.setHeader(head.getKey(), head.getValue());
		}
		try {
			response = client.execute(get);
		}
		catch (final IOException e) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		return response;
	}

	public static Object executePostRequest(final String url, final byte[] bs, final String jsonString,
			final Map<String, String> headers) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		final HttpPost post = new HttpPost(url);
		try {
			post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
			for (final Entry<String, String> head : headers.entrySet()) {
				post.setHeader(head.getKey(), head.getValue());
			}
			post.setEntity(new StringEntity(jsonString));
			// logger.info("Performing POST request for ur : " + url);
			response = client.execute(post);
		}
		catch (final IOException e) {
			// log.error("Http client call failed");
			// logger.error(StringUtility.getStackTraceInStringFmt(e));
		}
		catch (final Exception ex) {
			// log.error("Http client call failed");
			// logger.error(StringUtility.getStackTraceInStringFmt(ex));
		}
		return response;
	}

	public static Object executePostRequest(final String url, final List<NameValuePair> nameValuePairs,
			final byte[] bs) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		final HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// System.out.println("Performing POST request for ur : " + url);
			// System.out.println("RequestParam passed are :\t" +
			// nameValuePairs.toString());
			response = client.execute(post);
			// System.out.println("Received response for the Request" + url);
		}
		catch (final IOException e) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		return response;
	}

	public static Object executePutRequest(final String url, final List<NameValuePair> nameValuePairs) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		final HttpPut put = new HttpPut(url);
		try {
			put.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			response = client.execute(put);
		}
		catch (final IOException e) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// System.err.println("Http client call failed");
			// log.error("Http client call failed");
		}
		return response;
	}

	public static Object executePutRequest(final String url, final List<NameValuePair> nameValuePairs,
			final Map<String, String> headerMap) {
		HttpResponse response = null;
		final HttpClient client = HttpClients.createDefault();
		final HttpPut put = new HttpPut(url);
		try {
			put.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			for (final Entry<String, String> currentEntry : headerMap.entrySet()) {
				put.setHeader(currentEntry.getKey(), currentEntry.getValue());
			}
			// log.info("Performing PUT request to " + url);
			response = client.execute(put);
			// log.info("Received response with status " + response.getStatusLine());
		}
		catch (final IOException e) {
			// log.error("Http client call failed");
		}
		catch (final Exception ex) {
			// log.error("Http client call failed");
		}
		return response;
	}

}
