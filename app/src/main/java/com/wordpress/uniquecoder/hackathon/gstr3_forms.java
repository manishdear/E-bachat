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

public class gstr3_forms extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;

    EditText GrossTurnover, TurnoverTaxable;
    EditText OutwardIgst, OutwardCgst, OutwardSgst;
    EditText InwardIgst, InwardCgst, InwardSgst;
    EditText LiabilityIgst, LiabilityCgst, LiabilitySgst;
    EditText TdsIgst, TdsCgst, TdsSgst;
    EditText ItcIgst, ItcCgst, ItcSgst;
    EditText TaxIgst, TaxCgst, TaxSgst;
    EditText RefundIgst, RefundCgst, RefundSgst;
    String id,period;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstr3_forms);
        findViewById(R.id.btnsubmit).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        GrossTurnover = findViewById(R.id.grossTurnover);
        TurnoverTaxable = findViewById(R.id.taxableTurnover);
        OutwardIgst = findViewById(R.id.outwordIgst);
        OutwardCgst = findViewById(R.id.outwordCgst);
        OutwardSgst = findViewById(R.id.outwordSgst);
        InwardIgst = findViewById(R.id.inwardIgst);
        InwardCgst = findViewById(R.id.inwardCgst);
        InwardSgst = findViewById(R.id.inwardSgst);
        LiabilityIgst = findViewById(R.id.liabilityIgst);
        LiabilityCgst = findViewById(R.id.liabilityCgst);
        LiabilitySgst = findViewById(R.id.liabilitySgst);
        TdsIgst = findViewById(R.id.tdsIgst);
        TdsCgst = findViewById(R.id.tdsCgst);
        TdsSgst = findViewById(R.id.tdsSgst);
        ItcIgst = findViewById(R.id.itcIgst);
        ItcCgst = findViewById(R.id.itcCgst);
        ItcSgst = findViewById(R.id.itcSgst);
        TaxIgst = findViewById(R.id.taxPaidIgst);
        TaxCgst = findViewById(R.id.taxPaidCgst);
        TaxSgst = findViewById(R.id.taxPaidSgst);
        RefundIgst = findViewById(R.id.refundIgst);
        RefundCgst = findViewById(R.id.refundCgst);
        RefundSgst = findViewById(R.id.refundSgst);

    }

    public void saveData() {

        id = PreferenceManager.getDefaultSharedPreferences(gstr3_forms.this).getString("gstid", null);

        String grossTurnover = GrossTurnover.getText().toString().trim();
        String turnoverTaxable = TurnoverTaxable.getText().toString().trim();
        String outwardIgst = OutwardIgst.getText().toString().trim();
        String outwardCgst = OutwardCgst.getText().toString().trim();
        String outwardSgst = OutwardSgst.getText().toString().trim();
        String inwardIgst = InwardIgst.getText().toString().trim();
        String inwordCgst = InwardCgst.getText().toString().trim();
        String inwardSgst = InwardSgst.getText().toString().trim();
        String liabilityIgst = LiabilityIgst.getText().toString().trim();
        String liabilityCgst = LiabilityCgst.getText().toString().trim();
        String liabilitySgst = LiabilitySgst.getText().toString().trim();
        String TdsCreditIgst = TdsIgst.getText().toString().trim();
        String TdsCreditCgst = TdsCgst.getText().toString().trim();
        String TdsCreditSgst = TdsSgst.getText().toString().trim();
        String ItcCreditIgst = ItcIgst.getText().toString().trim();
        String ItcCreditCgst = ItcCgst.getText().toString().trim();
        String ItcCreditSgst = ItcSgst.getText().toString().trim();
        String TaxPaidIgst = TaxIgst.getText().toString().trim();
        String TaxPaidCgst = TaxCgst.getText().toString().trim();
        String TaxPaidSgst = TaxSgst.getText().toString().trim();
        String RefundClaimIgst = RefundIgst.getText().toString().trim();
        String RefundClaimCgst = RefundCgst.getText().toString().trim();
        String RefundClaimSgst = RefundSgst.getText().toString().trim();

        period = PreferenceManager.getDefaultSharedPreferences(gstr3_forms.this).getString("year", null);


        try {
            if (!id.isEmpty()) {
                gstr3FormData data = new  gstr3FormData(grossTurnover,turnoverTaxable, outwardIgst,
                        outwardCgst, outwardSgst, inwardIgst,
                        inwordCgst, inwardSgst, liabilityIgst,
                        liabilityCgst, liabilitySgst, TdsCreditIgst,
                        TdsCreditCgst, TdsCreditSgst, ItcCreditIgst,
                        ItcCreditCgst, ItcCreditSgst, TaxPaidIgst,
                        TaxPaidCgst, TaxPaidSgst, RefundClaimIgst,
                        RefundClaimCgst, RefundClaimSgst);

                databaseUser.child(id).child("gstr3").child(period).child("form").setValue(data);
                Toast.makeText(gstr3_forms.this, "Your data saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,uploadPdf.class));
            }
        }
        catch (Exception e){
            Toast.makeText(gstr3_forms.this, "please fill gstr1 first " ,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsubmit:
                saveData();
        }
    }
}
