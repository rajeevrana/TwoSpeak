package com.twospeak.twospeak;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
TextView signup;
Button btnLogin;
String UserID,PasswordID;
    public static boolean checkInternet;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);


        Configuration c = new Configuration(getApplicationContext());
        checkInternet = c.haveNetworkConnection();

        signup=(TextView)findViewById(R.id.signup);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        username=(EditText) findViewById(R.id.editTextEmail);
        password=(EditText) findViewById(R.id.editTextPassword);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(in);
                overridePendingTransition(0,0);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserID = username.getText().toString();
                PasswordID = password.getText().toString();

                if (checkInternet) {
                    if(UserID!= null && PasswordID!=null)
                    {
                        new SendPostRequest().execute();
                    }


                }



                Intent in = new Intent(getApplicationContext(),NavDrawerActivity.class);
                startActivity(in);
                overridePendingTransition(0,0);
            }
        });
    }




    public class SendPostRequest extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... voids)

        {

            // url where the data will be posted
            String postReceiverUrl = AppConst.url_service+"/"+"signIn";

            System.out.println("---responseStr-postURL"+postReceiverUrl);
// HttpClient
            HttpClient httpClient = new DefaultHttpClient();

// post header
            HttpPost httpPost = new HttpPost(postReceiverUrl);

// add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", UserID.toString()));
            nameValuePairs.add(new BasicNameValuePair("password", PasswordID.toString()));


            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

// execute HTTP post request
            HttpResponse response = null;
            try {
                response = httpClient.execute(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {

                String responseStr = null;
                try {
                    responseStr = EntityUtils.toString(resEntity).trim();
                    System.out.println("---responseStr-"+responseStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // you can add an if statement here and do other actions based on the response
            }

/*            final int DEFAULT_TIMEOUT = 30 * 1000;

            AsyncHttpClient client = new AsyncHttpClient();

            client.setTimeout(DEFAULT_TIMEOUT);

            JSONObject requestParam = new JSONObject();
            try {


                requestParam.put("email", UserID.toString());
                requestParam.put("password", PasswordID.toString());
                Log.e("params", requestParam.toString());
                StringEntity entity = new StringEntity(requestParam.toString(),"UTF-8");
                client.post(LoginActivity.this,
                        AppConst.url_service+"/"+"signIn", entity, "application/json; charset=utf-8",
                        responseHandler);
                //statusDialog();
            } catch (JSONException e) {

                if (e != null) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                if (e != null) {
                    e.printStackTrace();
                }
            }*/
            return null;
        }
        protected void onPreExecute() {
        }
        @Override
        protected void onPostExecute(String result) {
        }
    }




    AsyncHttpResponseHandler responseHandler = new JsonHttpResponseHandler()
    {
        @Override
        public void onFailure(int statusCode, Header[] headers,
                              final String responseString, Throwable throwable) {

            super.onFailure(statusCode, headers, responseString, throwable);
            System.out.println("-----TOKEN---responseString"+responseString);
            runOnUiThread(new Runnable()
            {

                @Override
                public void run() {

                    Toast.makeText(getApplicationContext(),
                            "OTP Entered Is Wrong ", Toast.LENGTH_SHORT)
                            .show();

                }

            });
        }

        @Override
        public void onFailure(int statusCode, Header[] headers,
                              Throwable throwable, JSONArray errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            System.out.println("-----TOKEN---errorResponse"+errorResponse);
        }

        @Override
        public void onFailure(int statusCode, Header[] headers,
                              Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            System.out.println("-----TOKEN---errorResponse"+errorResponse);
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers,
                              JSONArray response) {
            super.onSuccess(statusCode, headers, response);
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers,
                              final JSONObject response) {
            super.onSuccess(statusCode, headers, response);
            if(response != null)
            {
                try {
                    JSONObject resp= new JSONObject(response.toString());
                    System.out.println("-----TOKEN---errorResponse"+resp.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            runOnUiThread(new Runnable()
            {

                @Override
                public void run() {

                    if(response == null)
                    {

                        Toast.makeText(getApplicationContext(),
                                "OTP Entered Is Wrong ", Toast.LENGTH_SHORT)
                                .show();

                    }
                    else if(response != null)
                    {
                        System.out.println("-----TOKEN---errorResponse"+response.toString());
                     /*   if(memberInfo.getDesignation() != null){

                            if (memberInfo.getDesignation().equals("Speaker")) {
                                Intent intent = new Intent(Login.this,SpeakerSessionpage.class);
                                startActivity(intent);
                            }else{
                                Intent intent = new Intent(Login.this,SessionPage.class);
                                startActivity(intent);
                            }
                            prefstore.setBooleanValue(AppConst.IS_LOGGED_IN,true);
                            Login.this.finish();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "Something went Wrong,Try Again ", Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(Login.this,Login.class);
                            startActivity(intent);
                        }*/
                    }
                }

            });
        }

    };
}
