package com.myo.volley;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {
    TextView tvresponse;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvresponse=(TextView)findViewById(R.id.tvResponse);
        btnClick=(Button)findViewById(R.id.btnClick);

        btnClick.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        RequestQueue queue=Volley.newRequestQueue(this);
        String url="http://www.google.com";
        StringRequest stringRequest=new StringRequest(Request.Method.GET,url,this,this);
        queue.add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        tvresponse.setText("This is not work");
    }

    @Override
    public void onResponse(String response) {
        tvresponse.setText("Response is"+response.substring(0,500));

    }
}
