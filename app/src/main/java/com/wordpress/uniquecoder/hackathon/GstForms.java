package com.wordpress.uniquecoder.hackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GstForms extends AppCompatActivity {

    public DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_forms);


        databaseReference = FirebaseDatabase.getInstance().getReference();

        findViewById(R.id.filegstr1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GstForms.this,Gstr1.class));
            }
        });

        findViewById(R.id.filegstr3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GstForms.this, Gstr3.class));
            }
        });

        findViewById(R.id.filegstr4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GstForms.this, Gstr4.class));
            }
        });

    }

//    public void setUIView(){
//        gstr1 = findViewById(R.id.gstr1);
//        gstr3 = findViewById(R.id.gstr3);
//        gstr4 = findViewById(R.id.gstr4);
//    }

}
