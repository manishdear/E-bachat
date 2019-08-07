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

public class Gstr1 extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;
    EditText gstin, legalName ,tradeName , forYear , returnPeriod , dueDate, previousYear , month ;
    String id;
    String period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstr1);
        findViewById(R.id.buttonr1).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        gstin = findViewById(R.id.etgstin);
        legalName = findViewById(R.id.etlegalname);
        tradeName = findViewById(R.id.ettradename);
        forYear = findViewById(R.id.etforyear);
        returnPeriod = findViewById(R.id.etrp);
//        status = findViewById(R.id.etstatus);
        dueDate = findViewById(R.id.etdd);
        previousYear = findViewById(R.id.etpy);
        month = findViewById(R.id.etmonth);

    }

    public void saveData(){

        id = PreferenceManager.getDefaultSharedPreferences(Gstr1.this).getString("gstid", null);

        String gstinId = gstin.getText().toString().trim();
        String legal_name = legalName.getText().toString().trim();
        String trade_name = tradeName.getText().toString().trim();
        String for_year = forYear.getText().toString().trim();
        String return_period = returnPeriod.getText().toString().trim();
//        String _status = status.getText().toString().trim();
        String due_Date = dueDate.getText().toString().trim();
        String previous_year = previousYear.getText().toString().trim();
        String _month = month.getText().toString().trim();

        period = for_year;

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

        if(legal_name.isEmpty()){
            legalName.setError("Name is required");
            legalName.requestFocus();
            return;
        }

        if(trade_name.isEmpty()){
            tradeName.setError("Trade name is required");
            tradeName.requestFocus();
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

        if(previous_year.isEmpty()){
            previousYear.setError("previous year is required");
            previousYear.requestFocus();
            return;
        }

        if(_month.isEmpty()){
            month.setError("month period is required");
            month.requestFocus();
            return;
        }

        try {
            if (!id.isEmpty()) {
                Gstr1_data user = new Gstr1_data(gstinId, legal_name, trade_name, for_year, return_period, due_Date, previous_year, _month);
                databaseUser.child(id).child("gstr1").child(period).setValue(user);

                Toast.makeText(Gstr1.this, "Your data saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Gstr1.this, gstr1_forms.class);
//                intent.putExtra("year", period);

                PreferenceManager.getDefaultSharedPreferences(Gstr1.this).edit().putString("year", period).apply();

                startActivity(new Intent(Gstr1.this, gstr1_forms.class));
            }
        }
        catch (Exception e){
            Toast.makeText(Gstr1.this, ""+e ,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonr1:
                saveData();
        }
    }
}