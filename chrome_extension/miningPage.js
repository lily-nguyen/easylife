function MingingNameProduct() {
	//alert($(".product-card__name-wrap").length);
	var _productNameList = $(".product-card__name-wrap");
	var arrayProduct = [];
	var nameP = undefined;
	for (var i = 0; i < _productNameList.length; i++) {
		nameP = _productNameList[i].firstElementChild.title;
		if (nameP) {
			arrayProduct.push(nameP);
		} else {
			nameP = _productNameList[i].firstElementChild.textContent;
			if (nameP && (!nameP.endsWith('...'))){
				arrayProduct.push(nameP);
			}
			
		}
			
	}
	alert(arrayProduct);
    return "";
}

chrome.runtime.sendMessage({
    action: "miningProductName",
    source: MingingNameProduct(document)
});