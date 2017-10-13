package com.datalogic;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.datalogic.decode.BarcodeManager;
import com.datalogic.decode.DecodeException;
import com.datalogic.decode.DecodeResult;
import com.datalogic.decode.ReadListener;
import com.datalogic.device.ErrorManager;

import java.util.ArrayList;

public class DLScanner extends CordovaPlugin {

    BarcodeManager decoder = null;
    ReadListener listener = null;

    @Override
    public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {

	   
       if (action.equals("scanBarcode")) {
		  try{
        decoder = new BarcodeManager();
		decoder.addReadListener(new ReadListener(){
			public void onRead(DecodeResult decodeResult){
				String message = "Barcode "+decodeResult.getText();
                                         callbackContext.success(message);
										 decoder.stopDecode();
										 decoder.releaseTrigger ();
										 decoder.release();
			};
		});
               decoder.pressTrigger();
		decoder.startDecode(5000);
		
      //  return true;
	   }catch(Exception e){
		   
		    callbackContext.error(e.getMessage());
		   return true;
	   }
	 //  String message = "Barcode ";
       //callbackContext.success(message);
	  return true;
    }
	
    return false;


}
}
