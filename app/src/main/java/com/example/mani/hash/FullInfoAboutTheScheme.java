package com.example.mani.hash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FullInfoAboutTheScheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_info_about_the_scheme);

        TextView textViewdDis = findViewById(R.id.textView_description);
        TextView textViewdEli = findViewById(R.id.textview_eligiblity);
        TextView textViewdBen = findViewById(R.id.textView_benefits);
        TextView textViewdHow = findViewById(R.id.textview_how_to_apply);
        TextView textViewdWeb = findViewById(R.id.textview_website);
        TextView textViewdAddi = findViewById(R.id.textview_additional_resources);


        textViewdDis.setText(getIntent().getStringExtra("description"));
        textViewdEli.setText(getIntent().getStringExtra("eligiblity"));
        textViewdBen.setText(getIntent().getStringExtra("benefits"));
        textViewdHow.setText(getIntent().getStringExtra("howToApply"));
        textViewdWeb.setText(getIntent().getStringExtra("websites"));
        textViewdAddi.setText(getIntent().getStringExtra("additionalResources"));






        // Setting webpage
        TextView textViewLink = findViewById(R.id.textview_website);
        final String Url = textViewLink.getText().toString();
        if(!Url.equals("null"))
        {
            textViewLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(FullInfoAboutTheScheme.this,LinkWebView.class);
                    i.putExtra("URL",Url);
                    startActivity(i);
                }
            });

        }


    }
}
