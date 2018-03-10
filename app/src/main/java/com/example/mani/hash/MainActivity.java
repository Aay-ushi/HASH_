package com.example.mani.hash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TextView allSchemes = findViewById(R.id.textview_all_schmes);

        allSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AllSchemes.class));
            }
        });

       TextView signUp = findViewById(R.id.textview_sign_up);
       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,SignUp.class));
           }
       });

    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
