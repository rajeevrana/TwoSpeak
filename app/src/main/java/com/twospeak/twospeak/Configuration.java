package com.twospeak.twospeak;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Configuration extends Activity {
    private android.content.Context Context;
    public Configuration(Context context) {
        this.Context = context;
    }

    public  boolean haveNetworkConnection()
    {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager)Context.getSystemService(android.content.Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
                //if (ni.isConnectedOrConnecting())
                //NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (netInfo != null) {
                    for (int i = 0; i < netInfo.length; i++) {
                        if (netInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                            haveConnectedWifi = true;
                            return true;  //<--  --  -- Connected

                        }
                    }
                }

                return false;
            }

            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnectedOrConnecting())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;

    }


}
