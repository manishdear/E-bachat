package com.wordpress.uniquecoder.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InputCredit2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_credit2);

        findViewById(R.id.buttonr1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(InputCredit2.this, "Data saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
