chrome.runtime.onMessage.addListener(function(request, sender) {
  if (request.action == "miningProductName") {
    message.innerText = "DONE!";
  }
});

document.addEventListener('DOMContentLoaded', function() {
	var miningButton = document.getElementById('miningPage');
	miningButton.addEventListener('click', function() {
		var message = document.querySelector('#message');
		message.innerText = "processing ... ";
		chrome.tabs.executeScript(null, {
			file: "miningPage.js"
		}, function() {
		// If you try and inject into an extensions page or the webstore/NTP you'll get an error
			if (chrome.runtime.lastError) {
			  message.innerText = 'There was an error injecting script : \n' + chrome.runtime.lastError.message;
			}
		});		
	}, false);
}, false);