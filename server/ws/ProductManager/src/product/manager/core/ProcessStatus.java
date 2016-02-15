package product.manager.core;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ProcessStatus {
	
	static StringReader SAVE_SUCCESS = new StringReader("{\"code\":200,\"message\":\"success\"}");
	static StringReader SAVE_FAILED = new StringReader("{\"code\":201,\"message\":\"failed\"}");
	
	public static JsonObject PRODUCT_SAVE_SUCCESS = getSuccess();
	
	public static JsonObject getSuccess () {
		JsonReader jsonReader = Json.createReader(SAVE_SUCCESS);
		return jsonReader.readObject();
	}
}
