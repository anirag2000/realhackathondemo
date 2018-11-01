package com.example.anirudh.realhackathondemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BroadcastRead extends AppCompatActivity {
Firebase myFirebase;
    TextView tv;

    FirebaseUser user;
    String mychild;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_read);
        Intent intent=getIntent();
        Firebase.setAndroidContext(getApplicationContext());

        tv=(TextView)findViewById(R.id.textView);

try {
    String uid = intent.getStringExtra("uid");
    String url = "https://realhackathondemo.firebaseio.com/guidebroadcast/" + uid;
   // Toast.makeText(BroadcastRead.this,url,Toast.LENGTH_LONG).show();
    myFirebase = new Firebase(url);
    myFirebase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            mychild = dataSnapshot.child("message").getValue(String.class);
           // Toast.makeText(BroadcastRead.this,mychild+"yep",Toast.LENGTH_LONG).show();
            tv.setText(mychild);
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });

}
catch (Exception e)
{
    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
}

    }
}
