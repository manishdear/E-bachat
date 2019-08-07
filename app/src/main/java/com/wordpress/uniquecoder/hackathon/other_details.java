package com.wordpress.uniquecoder.hackathon;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class other_details extends AppCompatActivity {

    EditText inv_no,inv_date,inv_due;
    public static Other ot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_details);
        FloatingActionButton next=findViewById(R.id.next3);
        setUIViews();
        ot=new Other();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getdata();
                    if (inv_no.getText().toString().trim().isEmpty())
                        Toast.makeText(other_details.this, "Enter Invoice Number", Toast.LENGTH_SHORT).show();
                    else if (inv_date.getText().toString().trim().isEmpty())
                        Toast.makeText(other_details.this, "Enter Invoice date", Toast.LENGTH_SHORT).show();
                    else if (inv_due.getText().toString().trim().isEmpty())
                        Toast.makeText(other_details.this, "Enter Invoice Due Date", Toast.LENGTH_SHORT).show();
                    else {
                        startActivity(new Intent(other_details.this, item_details.class));
                    }
                }
                catch(Exception e){
                    Toast.makeText(other_details.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setUIViews(){
        inv_date=findViewById(R.id.other_invoice_date);
        inv_no=findViewById(R.id.other_invoice_no);
        inv_due=findViewById(R.id.other_due_date);
    }
    public void getdata(){
        ot.inv_date=inv_date.getText().toString().trim();
        ot.inv_due_date=inv_due.getText().toString().trim();
        ot.inv_no=inv_no.getText().toString().trim();
    }

}
