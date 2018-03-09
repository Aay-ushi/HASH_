package com.example.mani.hash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetailAboutAParticularScheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_about_a_particular_scheme);

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
        TextView textviewOfficialSiteLink = findViewById(R.id.textview_website);
        TextView textViewAdditionResoursesLink = findViewById(R.id.textview_additional_resources);


        final String Url = textviewOfficialSiteLink.getText().toString();
        if(!Url.equals("null"))
        {
            textviewOfficialSiteLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(DetailAboutAParticularScheme.this,LinkWebView.class);
                    i.putExtra("URL",Url);
                    startActivity(i);
                }
            });

        }

        final String Url2 = textViewAdditionResoursesLink.getText().toString();
        if(!Url2.equals("null"))
        {
            textViewAdditionResoursesLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(DetailAboutAParticularScheme.this,LinkWebView.class);
                    i.putExtra("URL",Url2);
                    startActivity(i);

                }
            });
        }


    }
}
