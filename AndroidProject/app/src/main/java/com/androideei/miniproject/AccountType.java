package com.androideei.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccountType extends AppCompatActivity {
    Button seller, buyer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);
        seller =findViewById(R.id.login3);
        buyer = findViewById(R.id.login2);
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccountType.this,seller_login.class);
                startActivity(intent);
            }
        });
        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccountType.this,CustomerLogin.class);
                startActivity(intent);
            }
        });

    }
}