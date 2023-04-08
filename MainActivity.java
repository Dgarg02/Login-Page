package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button b1,b2, show,creat;
    EditText pass, username1;
    TextView error1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        error1=findViewById(R.id.error);
        username1=findViewById(R.id.editText);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b2.setBackgroundColor(0x00000000);
        pass = findViewById(R.id.pass);
        show=findViewById(R.id.show);
        creat=findViewById(R.id.sign_up);
        Intent k= getIntent();
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k= new Intent(getApplicationContext(),sing_in_page.class);
                startActivity(k);
            }
        });
        String username=k.getStringExtra("username");
        String password=k.getStringExtra("pass");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username1.getText().toString().equals(username) && pass.getText().toString().equals(password)){
                    Intent i= new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                }
                else if(username1.getText().toString().equals("") && pass.getText().toString().equals("")){
                    error1.setText("Enter the Details Please!");
                }
                else if(username1.getText().toString().equals("")){
                    error1.setText("Enter the Username!");
                }
                else if(pass.getText().toString().equals("")){
                    error1.setText("Enter the Password!");
                }
                else if(username1.getText().toString()!=username && pass.getText().toString()!=password){
                    error1.setText("");
                    Toast.makeText(MainActivity.this, "Please Create an account", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter the correct Credential's", Toast.LENGTH_SHORT).show();
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show.getText().toString().equals("show")){
                    show.setText("hide");
                    pass.setTransformationMethod(null);

                }
                else {
                    show.setText("show");
                    pass.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }
}