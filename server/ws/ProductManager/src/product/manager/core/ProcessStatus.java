package product.manager.core;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ProcessStatus {
	
	static String SAVE_SUCCESS = "{\"message\":\"success\"}";
	static String SAVE_FAILED = "{\"message\":\"failed\"}";
	
	public static JsonObject PRODUCT_SAVE_SUCCESS = getSuccess();
	
	public static JsonObject getSuccess () {
		JsonReader jsonReader = Json.createReader(new StringReader(SAVE_SUCCESS));
		return jsonReader.readObject();
	}
	
	public static void main (String[] agrs) {
		System.out.println(getSuccess().toString());
	}
}
