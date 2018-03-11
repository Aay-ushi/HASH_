package com.example.mani.hash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

public class SignUp extends AppCompatActivity {

    EditText mName,mEmail,mPassword,mConfirmPassword;
    String name,email,password,confirmPassword;
    TextView mSignUp;
    AlertDialog.Builder mBuilder;
    String signUpUrl = "http://192.168.43.153/HealthCare/sign_up.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView backT0Login = findViewById(R.id.tv_back_to_login);
        backT0Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,MainActivity.class));

            }
        });

        mName = findViewById(R.id.et_name);
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mConfirmPassword = findViewById(R.id.et_confirm_password);

        mBuilder = new AlertDialog.Builder(SignUp.this);
        mSignUp = findViewById(R.id.sign_up_btn);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = mName.getText().toString();
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                confirmPassword = mConfirmPassword.getText().toString();

                if(name.equals("") || email.equals("") || password.equals("")
                        || confirmPassword.equals(""))
                {
                    mBuilder.setTitle("Something went wrong...");
                    mBuilder.setMessage("All fields are required.");
                    displayAleart("input_error");

                }

                else if(!password.equals(confirmPassword))
                {
                    mBuilder.setTitle("Something went wrong...");
                    mBuilder.setMessage("Your password is not matching");
                    displayAleart("input_error");
                }

                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, signUpUrl,
                            new Response.Listener<String>() {
                                @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONArray jsonArray = new JSONArray(response);
                                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                                            String code = jsonObject.getString("code");
                                            String message = jsonObject.getString("message");
                                            mBuilder.setTitle("Server response...");
                                            mBuilder.setMessage(message);
                                            displayAleart(code );

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String,String> params = new HashMap<String, String>();
                                params.put("name",name);
                                params.put("email",email);
                                params.put("password",password);
                                return  params;

                            }
                        };

                    MySingleton.getmInstance(SignUp.this).addToRequestque(stringRequest);
                }


            }
        });
    }

    public void displayAleart(final String code)
    {
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(code.equals("input_error"))
                {
                    mPassword.setText("");
                    mConfirmPassword.setText("");
                }
                else if(code.equals("success"))
                    finish();
                else if(code.equals("reg_failed"))
                {
                    mName.setText("");
                    mEmail.setText("");
                    mPassword.setText("");
                    mConfirmPassword.setText("");
                }
            }
        });
        mBuilder.create().show();
    }

}
