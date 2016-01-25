package com.example.shobhit.cop_290_assignment_0;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class netwk extends AppCompatActivity {
    // Declared two global variables for receiving server message.
    public static String msg="Waiting for Response",s1,s2,s3,s4,s5,s6,s7;
    public static int succ=22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netwk);
        // Getting Strings from  main activity
        Intent intent= getIntent();
        s1= intent.getStringExtra("s1");
        s2= intent.getStringExtra("s2");
        s3= intent.getStringExtra("s3");
        s4= intent.getStringExtra("s4");
        s5= intent.getStringExtra("s5");
        s6= intent.getStringExtra("s6");
        s7= intent.getStringExtra("s7");

        TextView t1= (TextView) findViewById(R.id.textView2);
        TextView t2= (TextView) findViewById(R.id.textView3);
        // the POST parameters:


        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";  // URL of Server

        StringRequest postRequest = new StringRequest(Request.Method.POST, url, // Making a POST request.
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        msg=response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        ) {
            @Override   //Override getParams method to set our values received from main activity.
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                // the POST parameters:
                params.put("teamname", s1);
                params.put("entry1", s2);
                params.put("name1", s3);
                params.put("entry2", s4);
                params.put("name2", s5);
                params.put("entry3", s6);
                params.put("name3", s7);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
        t2.setText("Message: "+msg);

    }

}

