package com.wordpress.uniquecoder.hackathon;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class
billform extends AppCompatActivity implements View.OnClickListener {

    EditText company_name,c_gstin,c_date,c_name,c_city,c_country,c_zip,_addr;
    Button next;
    public static CustomerData custData;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    String userGstId, userName,enterName,id;
    Boolean userExist;
    public userProfile uProfile;
    String str ,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billform);
        setUIViews();

        firebaseDatabase =  FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("user");

        userGstId = c_gstin.getText().toString().trim();

        findViewById(R.id.search).setOnClickListener(this);

        next=findViewById(R.id.next1);
        custData=new CustomerData();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getData();
                    if(company_name.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Company Name cannot be empty", Toast.LENGTH_SHORT).show();
                    else if(c_gstin.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "GSTIN cannot be empty", Toast.LENGTH_SHORT).show();
                    else if(c_date.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Date cannot be empty", Toast.LENGTH_SHORT).show();
                    else if(c_name.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Customer Name cannot be empty", Toast.LENGTH_SHORT).show();
                    else if(c_zip.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "ZIP cannot be empty", Toast.LENGTH_SHORT).show();
                    else if(_addr.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Enter Address", Toast.LENGTH_SHORT).show();
                    else if(c_country.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Enter country", Toast.LENGTH_SHORT).show();
                    else if(c_city.getText().toString().trim().isEmpty())
                        Toast.makeText(billform.this, "Enter City name", Toast.LENGTH_SHORT).show();
                    else
                    startActivity(new Intent(billform.this, other_details.class));
                }
                catch(Exception e)
                {
                    Toast.makeText(billform.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

   }
   public void setUIViews(){
      company_name=findViewById(R.id.customer_company);
      c_gstin=findViewById(R.id.customer_gstin);
      c_date=findViewById(R.id.customer_date);
      c_name=findViewById(R.id.customer_name);
      c_country=findViewById(R.id.customer_country);
      c_city=findViewById(R.id.customer_city);
      c_zip=findViewById(R.id.customer_zip);
      _addr=findViewById(R.id.customer_address);

   }

   public void getData(){
        custData.comp_name=company_name.getText().toString().trim();
        custData.cust_gstin=c_gstin.getText().toString().trim();
        custData.c_date=c_date.getText().toString().trim();
        custData.c_name=c_name.getText().toString().trim();
        custData.city=c_city.getText().toString().trim();
        custData.country=c_country.getText().toString().trim();
        custData.c_zip=c_zip.getText().toString().trim();
        custData.addr=_addr.getText().toString().trim();
   }
    private void validateUser(){

        if((c_gstin.getText().toString().trim().isEmpty())){
            c_gstin.setError("GSTIN is required");
            c_gstin.requestFocus();
            return;
        }

        str = PreferenceManager.getDefaultSharedPreferences(this).getString("gstid", null);

        databaseReference.child(userGstId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    uProfile = dataSnapshot.getValue(userProfile.class);
                    c_name.setText(uProfile.userName);
                    s= c_name.getText().toString().trim();
                    Toast.makeText(getApplicationContext(), "data is fetched", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        if(enterName.equalsIgnoreCase(s)){
            userExist = true;
            Toast.makeText(this, "user Exist", Toast.LENGTH_SHORT).show();
        }
        else {
            userExist = false;
            Toast.makeText(this, "user Don't Exist", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search:
                userGstId = c_gstin.getText().toString().trim();
                enterName = company_name.getText().toString().trim();
                validateUser();
                break;
        }
    }
}
