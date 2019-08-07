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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class client_details extends AppCompatActivity implements View.OnClickListener {
    Button next,search;
    public static ClientData clientData;
    EditText client_company_name,gstin,billto,place ,city,state,country,zip,address;

    public userProfile uProfile;
    EditText username;
    EditText userEmail;
    EditText userGstin;
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    String userGstId, userName,enterName,id;
    Boolean userExist;

    String str ,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);
        client_company_name=findViewById(R.id.customer_company);
        gstin=findViewById(R.id.customer_gstin);
        billto=findViewById(R.id.customer_date);
        city=findViewById(R.id.customer_city);
        country=findViewById(R.id.customer_country);
        zip=findViewById(R.id.client_zip);
        address=findViewById(R.id.customer_address);
        search=findViewById(R.id.search);

        firebaseDatabase =  FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("user");
        clientData=new ClientData();
//        uProfile = new userProfile();





        findViewById(R.id.next2).setOnClickListener(this);
        findViewById(R.id.search).setOnClickListener(this);
    }


   public void getData()
   {
     clientData._client_name= client_company_name.getText().toString().trim();
      clientData._gstin= gstin.getText().toString().trim();
      clientData._billto= billto.getText().toString().trim();
      clientData._city=city.getText().toString().trim();
       clientData._country= country.getText().toString().trim();
       clientData._zip= zip.getText().toString().trim();
       clientData._address= address.getText().toString().trim();

   }
    public void findid()
    {
       client_company_name=findViewById(R.id.customer_company);
       gstin=findViewById(R.id.customer_gstin);
       billto=findViewById(R.id.customer_date);
       city=findViewById(R.id.customer_city);
       country=findViewById(R.id.customer_country);
       zip=findViewById(R.id.client_zip);
       address=findViewById(R.id.customer_address);
       search=findViewById(R.id.search);
    }

    private void validateUser(){

        if((gstin.getText().toString().trim().isEmpty())){
            gstin.setError("GSTIN is required");
            gstin.requestFocus();
            return;
        }

        str = PreferenceManager.getDefaultSharedPreferences(this).getString("gstid", null);

        databaseReference.child(userGstId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.exists()) {
                        uProfile = dataSnapshot.getValue(userProfile.class);
                        address.setText(uProfile.userName);
                        s = address.getText().toString().trim();
                        Toast.makeText(getApplicationContext(), "data is fetched", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(), "details not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        if(enterName.equalsIgnoreCase(s)){
            userExist = true;
            Toast.makeText(client_details.this, "user Exist", Toast.LENGTH_SHORT).show();
        }
        else {
            userExist = false;
            Toast.makeText(client_details.this, "user Don't Exist", Toast.LENGTH_SHORT).show();
        }

    }

    private void nextActivity(){

        if(userExist.equals(true)) {

            getData();
            if (gstin.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "GSTIN cannot be empty", Toast.LENGTH_SHORT).show();
            else if (billto.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "Enter the billing address", Toast.LENGTH_SHORT).show();
            else if (city.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "Enter city", Toast.LENGTH_SHORT).show();
            else if (country.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "Country cannot be empty", Toast.LENGTH_SHORT).show();
            else if (zip.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "Enter ZIP code", Toast.LENGTH_SHORT).show();
            else if (address.getText().toString().trim().isEmpty())
                Toast.makeText(client_details.this, "Enter address", Toast.LENGTH_SHORT).show();
            else {
                //  Toast.makeText(client_details.this, "" + clientData._billto, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(client_details.this, billform.class));
            }
        }
        else{
            Toast.makeText(client_details.this, "name does not match with GSTIN", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.next2:
                nextActivity();
                break;

            case R.id.search:
                userGstId = gstin.getText().toString().trim();
                enterName = client_company_name.getText().toString().trim();
                validateUser();
                break;

        }
    }
}
