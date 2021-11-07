package com.example.test;

import static com.example.test.MainActivity.pass;
import static com.example.test.MainActivity.pendingSMSCount;
import static com.example.test.MainActivity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView gotoRegister;
    EditText txtEmail,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtEmail = findViewById(R.id.inputEmail);
        txtPass = findViewById(R.id.inputPassword);

        gotoRegister = (TextView) findViewById(R.id.gotoRegister);
        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin =  findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user =  txtEmail.getText().toString();
                pass = txtPass.getText().toString();
                pendingSMSCount = 2;
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}