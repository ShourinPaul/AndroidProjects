package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JsonActivity extends AppCompatActivity {

    public  static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        textView = (TextView) findViewById(R.id.textview);

        fetchdata fetch = new fetchdata();
        fetch.execute();
    }
}
