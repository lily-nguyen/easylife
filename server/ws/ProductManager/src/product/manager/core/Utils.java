package product.manager.core;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Utils {
	public static JsonObject convertToJson (String data) {
		JsonReader jsonReader = Json.createReader(new StringReader(data));
		JsonObject jObj = jsonReader.readObject();
		jsonReader.close();
		return jObj;
	}
}
