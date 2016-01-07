function MingingNameProduct(document_root) {

    return "";
}

chrome.runtime.sendMessage({
    action: "miningProductName",
    source: MingingNameProduct(document)
});