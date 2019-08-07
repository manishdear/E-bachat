package com.wordpress.uniquecoder.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gstr3 extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;

    EditText gstin, bussinessName , forYear , returnPeriod , status , dueDate;

    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstr3);


        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        findViewById(R.id.buttonr3).setOnClickListener(this);

        gstin = findViewById(R.id.etgstin);
        bussinessName = findViewById(R.id.etbn);
        forYear = findViewById(R.id.etfy);
        returnPeriod = findViewById(R.id.etrp);
//        status = findViewById(R.id.etstatus);
        dueDate = findViewById(R.id.etdd);
    }

    public void saveData() {

        id = PreferenceManager.getDefaultSharedPreferences(Gstr3.this).getString("gstid", "");

        String gstinId = gstin.getText().toString().trim();
        String bussiness_name = bussinessName.getText().toString().trim();
        String for_year = forYear.getText().toString().trim();
        String return_period = returnPeriod.getText().toString().trim();
//        String _status = status.getText().toString().trim();
        String due_Date = dueDate.getText().toString().trim();

        if(gstinId.isEmpty()){
            gstin.setError("GstinId is required");
            gstin.requestFocus();
            return;
        }

        if(!gstinId.equals(id)){
            gstin.setError("Enter your valid Gstin Id");
            gstin.requestFocus();
            return;
        }

        if(bussiness_name.isEmpty()){
            bussinessName.setError("GstinId is required");
            bussinessName.requestFocus();
            return;
        }

        if(for_year.isEmpty()){
            forYear.setError("year is required");
            forYear.requestFocus();
            return;
        }

        if(return_period.isEmpty()){
            returnPeriod.setError("return period is required");
            returnPeriod.requestFocus();
            return;
        }

        if(due_Date.isEmpty()){
            dueDate.setError("due date is required");
            dueDate.requestFocus();
            return;
        }

        try {
            if (!id.isEmpty()) {
                Gstr3_data user = new Gstr3_data(gstinId, bussiness_name, for_year, return_period, due_Date);
                databaseUser.child(id).child("gstr3").setValue(user);
                Toast.makeText(Gstr3.this, "Your data saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Gstr3.this,gstr3_forms.class));
            }
        } catch (Exception e) {
            Toast.makeText(Gstr3.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonr3:
                saveData();
        }
    }
}
