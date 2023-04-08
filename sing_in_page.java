package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sing_in_page extends AppCompatActivity {

    Button createacc,show;
    EditText username,password;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in_page);
        show=findViewById(R.id.show);
        error =findViewById(R.id.error);
        createacc=findViewById(R.id.creatacc);
        username=findViewById(R.id.username2);
        password=findViewById(R.id.password);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") && password.getText().toString().equals("")){
                    error.setText("Enter the Credentials!");
                }
                else if(username.getText().toString().equals("")){
                    error.setText("Enter the Username!");

                }
                else if (password.getText().toString().equals("")){
                    error.setText("Enter the Password!");
                }
                else {
                    Intent k= new Intent(getApplicationContext(),MainActivity.class);
                    k.putExtra("username",username.getText().toString());
                    k.putExtra("pass",password.getText().toString());
                    startActivity(k);
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().equals("show")){
                    show.setText("hide");
                    password.setTransformationMethod(null);
                }
                else{
                    show.setText("show");
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }
}