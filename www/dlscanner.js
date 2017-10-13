    var exec = cordova.require("cordova/exec");
 

 function DLScanner() {

}
DLScanner.prototype.scanBarcode = function (successCallback, errorCallback, config) {
	console.log("Inside dlscanner.js");
	try{
      exec(
	  function(result)
	  { 
	   console.log("result "+result);
	   successCallback(result);
	   }, 
	  function(error)
	  {
	  console.log(error);
	  errorCallback(error);
	  },
	  'DLScanner', "scanBarcode", null);
	  }catch(exception){
		console.log(exception);
	}
	console.log("After calling java class");
};

var DLScanner = new DLScanner();
module.exports = DLScanner;