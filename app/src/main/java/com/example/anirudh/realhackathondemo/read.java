package com.example.anirudh.realhackathondemo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class read extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity=this;
        setContentView(R.layout.activity_read);
        IntentIntegrator intentIntegrator=new IntentIntegrator(activity);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        intentIntegrator.setPrompt("Scan");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.setBarcodeImageEnabled(false);
        intentIntegrator.initiateScan();
        intentIntegrator.setOrientationLocked(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "Unsucesful", Toast.LENGTH_LONG).show();

            } else {
                Intent intent=new Intent(read.this,BroadcastRead.class);
                intent.putExtra("uid",intentResult.getContents());


startActivity(intent);
            }
        }
            else
            {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }


    }

