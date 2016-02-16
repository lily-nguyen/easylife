package product.manager.core;

import java.io.StringReader;

import javax.json.*;

public class ProductSaverImpl implements ProductSaverInf {

	@Override
	public JsonObject saveProductList(JsonObject data, boolean backupFile) {
		if (backupFile) {
			FileUtilities fileUtil = new FileUtilities();
			String fileName = fileUtil.generateFileName(data,"D:/m_stuff/easylife/server");
			fileUtil.save(fileName, data);
		}
		return ProcessStatus.PRODUCT_SAVE_SUCCESS;
	}

	
	
	private static JsonObject getData() {
		JsonObject data = null;
		String product = "{\"url\":\"http://example.com/query?category=hoa\",\"category\":\"hoa\",\"products\":[{\"product\":\"hoa lan\"},{\"product\":\"hoa hue\"}]}";
		StringReader strReader = new StringReader(product);
		JsonReader jsonReader = Json.createReader(strReader);
		data = jsonReader.readObject();
		jsonReader.close();
		return data;
	}
	
	
	// for test
	public static void main(String[] args) {
		JsonObject data = getData();
		ProductSaverInf saver = new ProductSaverImpl();
		saver.saveProductList(data, true);
	}

}
