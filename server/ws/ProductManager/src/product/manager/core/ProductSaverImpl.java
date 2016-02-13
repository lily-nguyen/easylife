package product.manager.core;

import net.sf.json.JSON;

public class ProductSaverImpl implements ProductSaverInf {

	@Override
	public JSON saveProductList(JSON data) {
		return null;
	}

	public static void main(String[] args) {
		JSON data = null;
		ProductSaverInf saver = new ProductSaverImpl();
		saver.saveProductList(data);
	}

}
