package com.twospeak.twospeak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
TextView signup;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);


        signup=(TextView)findViewById(R.id.signup);
        btnLogin=(Button)findViewById(R.id.btnLogin);
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
                Intent in = new Intent(getApplicationContext(),NavDrawerActivity.class);
                startActivity(in);
                overridePendingTransition(0,0);
            }
        });
    }
}
