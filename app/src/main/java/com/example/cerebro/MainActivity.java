package com.example.cerebro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText em,pas;
    Button login,register;
    FirebaseAuth auth;
    FirebaseUser currenuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        em = findViewById(R.id.emai);
        pas = findViewById(R.id.pass);
        login = findViewById(R.id.log);
        register = findViewById(R.id.reg);
        auth = FirebaseAuth.getInstance();
        currenuser = auth.getCurrentUser();

        if(currenuser!=null){
            startActivity(new Intent(this,Homepage.class));
            finish();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ema=em.getText().toString();
                String passw= pas.getText().toString();
                if(ema.isEmpty()||passw.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill the details correctly", Toast.LENGTH_SHORT).show();
                }else{
                    if(passw.length()<8){
                        Toast.makeText(MainActivity.this, "password must be 8 letters", Toast.LENGTH_SHORT).show();
                    }else{
                        auth.signInWithEmailAndPassword(ema,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this,Homepage.class));
                                    finish();
                                }else{
                                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
                finish();
            }
        });

    }
}