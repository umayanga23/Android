package com.androideei.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CustomeSign extends AppCompatActivity {
    EditText sname, email1, psswd, cmfpssd;
    TextView login;
    Button register;
    FirebaseAuth  mAuth;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_sign);
        sname = findViewById(R.id.name);
        email1 = findViewById(R.id.email);
        psswd =findViewById(R.id.password);
        cmfpssd =findViewById(R.id.passwordcomfim);
        register = findViewById(R.id.sign);
        login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        bar = findViewById(R.id.progerss);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =  new Intent(CustomeSign.this,CustomerLogin.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                String name, email, password, passwordcomfim;
                name = String.valueOf(sname.getText()) ;
                email = String.valueOf(email1.getText());
                password = String.valueOf(psswd.getText());
                passwordcomfim =String.valueOf(cmfpssd.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(CustomeSign.this, "enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(CustomeSign.this, "enter NAme", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(CustomeSign.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordcomfim)){
                    Toast.makeText(CustomeSign.this, "Comfirm password error", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                bar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(CustomeSign.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(CustomeSign.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });



            }
        });
    }
}