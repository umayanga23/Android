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

public class seller_login extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView frog;
    Button login;
    EditText mail, Psswd;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);
        frog = (TextView) findViewById(R.id.register);
        login = findViewById(R.id.button111);
        mAuth = FirebaseAuth.getInstance();
        mail = (EditText) findViewById(R.id.email);
        Psswd =  findViewById(R.id.Password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  email, Password;

                email = String.valueOf(mail.getText());
                Password = String.valueOf(Psswd.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(seller_login.this, "enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(seller_login.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, Password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(seller_login.this, "Authentication pass.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),AddfoodActivity.class);
                                    startActivity(intent);



                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(seller_login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });

        frog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(seller_login.this,Seller_sign.class);
                startActivity(intent);
            }
        });

    }
}