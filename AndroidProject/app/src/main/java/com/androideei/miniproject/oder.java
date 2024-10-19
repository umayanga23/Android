package com.androideei.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class oder extends AppCompatActivity {

    private TextView add;
    private Button LocationButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder2);


        LocationButton = findViewById(R.id.location);
        add=findViewById(R.id.add);


        LocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oder.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }



}