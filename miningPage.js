function MingingNameProduct() {
	alert($(".product-card__name-wrap").length);
	//var _productNameList = $(node).find(".product-card__name-wrap");
	//alert(_productNameList.length);
    return "";
}

chrome.runtime.sendMessage({
    action: "miningProductName",
    source: MingingNameProduct(document)
});