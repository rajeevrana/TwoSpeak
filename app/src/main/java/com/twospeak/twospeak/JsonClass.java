package com.twospeak.twospeak;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonClass {

    static InputStream is = null;
    String jj;
    static OutputStream outputStream;
    String json;

    JSONArray jObj = null;
    JSONObject jobjj = null;

    public JsonClass() {

    }


    public  JSONArray makeHttpRequest(Context context, String url, String method, JSONObject requestParam) throws IOException {
        if (method == "POST")
        {
            System.out.println("-resultstring-call-json");
            System.out.println("-resultstring-call-json"+requestParam);
            System.out.println("-resultstring-call-json"+url);
            try
            {   //Your code goes here
                URL url1 = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(String.valueOf(requestParam));
                bufferedWriter.flush();
                int statusCode = httpURLConnection.getResponseCode();
                System.out.println("-resultstring--json"+statusCode);
                if (statusCode == 200)
                {
                    is = new BufferedInputStream(httpURLConnection.getInputStream());
                    json =  convertStreamToString(is);//No data found
                    System.out.println("-resultstring--json" + json.replace("\"", ""));

                    jj=json.replace("\"", "");
                    System.out.println("-resultstring--json" + jj);
                    if(jj.equals("No Data Found"))
                    {

                        System.out.println("-resultstring--json rajeev ");

                    }
                    try {
                        jObj = new JSONArray(json);

                    } catch (JSONException e)
                    {


                    }




                }

                else
                {
                    System.out.println("-resultstring--else");
                }
            } catch (Exception e) {
                System.out.println("-resultstring--else"+e);
                e.printStackTrace();
            }
        }
        return jObj;
    }

    private  String convertStreamToString(InputStream is) {
        String line = "";
        StringBuilder total = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        try {
            while ((line = rd.readLine()) != null) {
                total.append(line);
            }
        } catch (Exception e) {

        }
        return total.toString();
    }

}
