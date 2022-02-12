package com.hdv.api.utils;

import com.google.gson.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonUtil {

	public static final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setPrettyPrinting()
			.create();

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String getString(JsonObject json, String prop) {
		if (json.has(prop) && json.get(prop).isJsonPrimitive() && json.get(prop).getAsJsonPrimitive().isString()) {
			return json.get(prop).getAsString();
		}
		return null;
	}

	public static Boolean getBoolean(JsonObject json, String prop) {
		if (json.has(prop) && json.get(prop).isJsonPrimitive() && json.get(prop).getAsJsonPrimitive().isBoolean()) {
			return json.get(prop).getAsBoolean();
		}
		return null;
	}

	public static Number getNumber(JsonObject json, String prop) {
		if (json.has(prop) && json.get(prop).isJsonPrimitive() && json.get(prop).getAsJsonPrimitive().isNumber()) {
			return json.get(prop).getAsNumber();
		}
		return null;
	}

	public static JsonObject getJsonObject(JsonObject json, String prop) {
		if (json.has(prop) && json.get(prop).isJsonObject()) {
			return json.get(prop).getAsJsonObject();
		}
		return null;
	}

	public static JsonArray getJsonArray(JsonObject json, String prop) {
		if (json.has(prop) && json.get(prop).isJsonArray()) {
			return json.get(prop).getAsJsonArray();
		}
		return null;
	}

	public static JsonObject toJsonObject(String json) throws Exception {
		return gson.fromJson(json, JsonObject.class);
	}

	public static JsonElement toJsonElement(String json) throws Exception {
		return gson.fromJson(json, JsonElement.class);
	}

	public static JsonArray toJsonArray(String json) throws Exception {
		return gson.fromJson(json, JsonArray.class);
	}

//	public static ObjectMapper getObjectMapper() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//		LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(formatter);
//		LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(formatter);
//
//		SimpleModule module = new SimpleModule().addDeserializer(LocalDateTime.class, deserializer)
//				.addSerializer(LocalDateTime.class, serializer);
//
//		ObjectMapper mapper = new ObjectMapper().registerModule(module);
//
//		return mapper;
//	}
//
}
