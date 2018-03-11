package com.example.mani.hash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView mEmail, mPassword, mLogin, mSignUp;
    String email, password;
    AlertDialog.Builder mBuilder;
    String login_url = "http://192.168.43.153/HealthCare/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView allSchemes = findViewById(R.id.textview_all_schmes);

        allSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AllSchemes.class));
            }
        });

        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
        mLogin = findViewById(R.id.faltu);

        mBuilder = new AlertDialog.Builder(MainActivity.this);

        mSignUp = findViewById(R.id.textview_sign_up);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                //Toast.makeText(MainActivity.this,"Aaa"+email+""+password,Toast.LENGTH_SHORT).show();

                if (email.equals("") || password.equals("")) {
                    mBuilder.setTitle("Something went wrong");
                    displayAleart("Enter a valid email and password");
                }

                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                                        String code = jsonObject.getString("code");

                                        if(code.equals("login_failed"))
                                        {
                                            mBuilder.setTitle("Login Error...");
                                            displayAleart(jsonObject.getString("message"));
                                        }

                                        else
                                        {
                                            Intent i = new Intent(MainActivity.this,AllSchemes.class);
                                            startActivity(i);

                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();

                        }
                    }){

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("email",email);
                            params.put("password",password);
                            return params;
                        }
                    };
                    MySingleton.getmInstance(MainActivity.this).addToRequestque(stringRequest);

                }
            }
        });


    }
     public void displayAleart(String message)
     {
         mBuilder.setMessage(message);
         mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 mEmail.setText("");
                 mPassword.setText("");
             }
         });

         AlertDialog alertDialog = mBuilder.create();
         alertDialog.show();
     }
}

