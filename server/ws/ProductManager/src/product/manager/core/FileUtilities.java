package product.manager.core;

import javax.json.JsonObject;

public class FileUtilities {
	
	public boolean save (String fileName, JsonObject content) {
		return true;
	}
	
	/**
	 * Return file name: domain_category_yymmdd
	 * @param data
	 * @return
	 */
	public String generateFileName (JsonObject data) {
		
		return "todo";
	}

}
