function MingingNameProduct(root) {
	var _productNameList = $(root).find(".product-card__name-wrap");
	alert(_productNameList.length);
    return "";
}


chrome.runtime.sendMessage({
    action: "miningProductName",
    source: MingingNameProduct(document)
});