package product.manager.core;

import javax.json.JsonObject;

public interface ProductSaverInf {
	
	JsonObject saveProductList(JsonObject data, boolean backupFile);
	JsonObject saveProductList(String data, boolean backupFile);

}
