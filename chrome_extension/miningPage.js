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
	var productInformation = createProductInformation(arrayProduct);
	saveProduct(productInformation);
    return "";
}


function createProductInformation (arrayProduct) {
	var productJ = {};
	productJ.url = 'http://www.lazada.vn/the-thao-da-ngoai/?ref=HP';
	productJ.category = 'the thao da ngoai';
	productJ.products = arrayProduct;
	return productJ;
}

function saveProduct(productInformation) {
	$.ajax({
		'type': 'POST',
		'url': 'http://localhost:8080/ProductManager/saveProducts',
		'contentType': 'application/json',
		'data': JSON.stringify(productInformation),
		'dataType': 'xml/html/script/json',
		'success': function() {
			alert("success");
		}
	});
}

chrome.runtime.sendMessage({
    action: "miningProductName",
    source: MingingNameProduct(document)
});