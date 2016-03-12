package product.manager.core;

import java.io.StringReader;

import javax.json.*;

import javassist.expr.Instanceof;

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

	
	@Override
	public JsonObject saveProductList (String data, boolean backupFile) {
		System.out.println(data.toString() + " / ");
		//return null;
		return saveProductList(Utils.convertToJson(data), backupFile);
	}
	
	
	public static JsonObject getData() {
		JsonObject data = null;
		String product = "{\"url\":\"http://example.com/query?category=hoa\",\"category\":\"hoa\",\"products\":[{\"product\":\"hoa lan\"},{\"product\":\"hoa hue\"}]}";
		JsonReader jsonReader = Json.createReader(new StringReader(product));
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
