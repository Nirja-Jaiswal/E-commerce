package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView done;
    EditText edtmail;
    EditText edtpass;


String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        done = findViewById(R.id.done);
        edtmail = findViewById(R.id.edtmail);
        edtpass = findViewById(R.id.edtpass);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail=edtmail.getText().toString();
                if (mail.equalsIgnoreCase("")){
                    Toast.makeText(LoginActivity.this, "Pease enter mail", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    Log.e("TAG", "onClick: " );
                    Toast.makeText(LoginActivity.this, "Pease enter valid mail", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(LoginActivity.this,HomebotnvActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}