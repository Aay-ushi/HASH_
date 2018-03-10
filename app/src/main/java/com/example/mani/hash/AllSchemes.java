package com.example.mani.hash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllSchemes extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Schemes> mSehemesList;
    String FETCHING_URL = "http://192.168.43.153/HealthCare/fetch_from_database.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_schemes);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSehemesList = new ArrayList<>();
        loadSchemesFromDatabase();
    }

    private void loadSchemesFromDatabase()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, FETCHING_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray schemes = new JSONArray(response);
                            for(int i=0;i<schemes.length();i++)
                            {
                                JSONObject  schemesJSONObject = schemes.getJSONObject(i);

                                String name             = schemesJSONObject.getString("name");
                                String description      = schemesJSONObject.getString("description");
                                String eligiblity       = schemesJSONObject.getString("eligiblity");
                                String benefits         = schemesJSONObject.getString("benefits");
                                String how_to_apply     = schemesJSONObject.getString("how_to_apply");
                                String websites         = schemesJSONObject.getString("websites");
                                String additional_information = schemesJSONObject.getString("additional_information");


                                Schemes schemes1 = new Schemes(name,description,eligiblity,benefits,how_to_apply,
                                        websites,additional_information);
                                mSehemesList.add(schemes1);
                            }

                            SchemesAdapter adapter = new SchemesAdapter(AllSchemes.this,mSehemesList);
                            mRecyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AllSchemes.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

}
