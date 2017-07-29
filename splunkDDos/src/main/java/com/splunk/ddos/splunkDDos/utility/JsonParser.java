package com.splunk.ddos.splunkDDos.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonParser {

	// private static Logger logger = LogManager.getLogger(JsonParser.class);

	/**
	 * This method will return customized list of Objects from a given list of json
	 * strings
	 *
	 * @param json
	 * @param class1
	 * @return
	 */
	public <T> List<T> generalJsonListToObjectList(final String json, final Class<?> cls) {
		final ObjectMapper mapper = new ObjectMapper();
		List<T> objectList = null;

		try {
			objectList = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, cls));

		}
		catch (final IOException e) {
			// logger.error(StringUtil.getStackTraceInStringFmt(e));
		}
		return objectList;
	}

	/**
	 * This method will return customized model object from a given json String here the
	 * input type for the method is json string and class name of the domain that you want
	 * output as
	 *
	 * @param json - json String that needs to be converted
	 * @param cls - .class name for the pojo
	 * @return
	 */
	public <T> T generalJsonToObject(final String json, final Class<?> cls) {
		final ObjectMapper mapper = new ObjectMapper();
		T object = null;

		try {
			object = (T) mapper.readValue(json, cls);
		}
		catch (final IOException e) {
			// logger.error(StringUtil.getStackTraceInStringFmt(e));
		}
		return object;
	}

	/**
	 * This method will convert any model objectList into json string The key for the json
	 * string is being mapped from getters of your pojo
	 *
	 * @author prashantkumar
	 * @param object
	 * @return Json from Object
	 */
	public String objectListToJson(final List<? extends Object> list) {
		final ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			final OutputStream out = new ByteArrayOutputStream();
			mapper.writeValue(out, list);
			// final byte[] data = ((ByteArrayOutputStream) out).toByteArray();
			jsonInString = out.toString();
		}
		catch (final IOException e) {
			// logger.error(StringUtil.getStackTraceInStringFmt(e));
		}
		return jsonInString;
	}

	/**
	 * This method will convert any model object into json string The key for the json
	 * string is being mapped from getters of your pojo
	 * @author prashantkumar
	 * @param object
	 * @return Json from Object
	 */
	public String objectToJson(final Object obj) {
		final ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(obj);
		}
		catch (final IOException e) {
			// logger.error("Failed to parse object into json");
			// logger.error(StringUtil.getStackTraceInStringFmt(e));
		}
		return jsonInString;
	}

}
