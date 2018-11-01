package com.example.anirudh.realhackathondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void read(View view)
    {
        Intent intent=new Intent(MainActivity.this,read.class);
        startActivity(intent);






    }
    public void write(View view)
    {
        Intent intent=new Intent(MainActivity.this,write.class);
        startActivity(intent);






    }


}
