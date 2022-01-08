package com.example.cerebro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText conpas,passw,emai;
    Button regi,logi;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        conpas = findViewById(R.id.conpass1);
        passw = findViewById(R.id.pass1);
        emai = findViewById(R.id.emai1);
        regi = findViewById(R.id.reg1);
        logi = findViewById(R.id.log1);
        auth = FirebaseAuth.getInstance();
        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity.class));
                finish();
            }
        });

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emai.getText().toString();
                String password = passw.getText().toString();
                String Conformpass = conpas.getText().toString();
                if(email.isEmpty()||password.isEmpty()||Conformpass.isEmpty()){
                    Toast.makeText(Register.this, "Fill the all Deatails", Toast.LENGTH_SHORT).show();
                }else {
                    if(password.length()<8){
                        Toast.makeText(Register.this, "password must be 8 letters", Toast.LENGTH_SHORT).show();
                    }else if(!password.equals(Conformpass)){
                        Toast.makeText(Register.this, "Password and Conform password not match", Toast.LENGTH_SHORT).show();
                    }else{
                        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(Register.this, "Successfully register", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Register.this,MainActivity.class));
                                    finish();
                                }else{
                                    Toast.makeText(Register.this, "Fail to Register", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}