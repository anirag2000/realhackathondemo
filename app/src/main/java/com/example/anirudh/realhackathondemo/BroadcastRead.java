package com.example.anirudh.realhackathondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BroadcastRead extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_read);
        Intent intent=getIntent();
        String uid=intent.getStringExtra("uid");
        String url="https://realhackathondemo.firebaseio.com/guidebroadcast";

    }
}
