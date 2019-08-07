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

public class gstr4_forms extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;

    EditText totalLiability, paidThroughCash;
    EditText IntegratedTax, CentralTax, stateTax, Cess;
    EditText TotalTaxClaim, IntrestClaim, LateFeeClaim;
    String id,period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstr4_forms);
        findViewById(R.id.btnsubmit).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        totalLiability = findViewById(R.id.totalLiability);
        paidThroughCash = findViewById(R.id.paidthroughcash);
        IntegratedTax = findViewById(R.id.integratedtax);
        CentralTax = findViewById(R.id.centraltax);
        stateTax = findViewById(R.id.statetax);
        Cess = findViewById(R.id.cess);
        TotalTaxClaim = findViewById(R.id.totaltaxclaim);
        IntrestClaim = findViewById(R.id.intrestclaim);
        LateFeeClaim = findViewById(R.id.latefeeclaim);

    }

    public void saveDate() {

        id = PreferenceManager.getDefaultSharedPreferences(gstr4_forms.this).getString("gstid", null);

        String taxLiability = totalLiability.getText().toString().trim();
        String taxPaidthroughCash = paidThroughCash.getText().toString().trim();
        String debitEntriesInCashIntegratedTax = IntegratedTax.getText().toString().trim();
        String debitEntriesInCashCentralTax = CentralTax.getText().toString().trim();
        String debitEntriesInCashStateTax = stateTax.getText().toString().trim();
        String debitEntriesInCashCess = Cess.getText().toString().trim();
        String refundClaimTotalTax = TotalTaxClaim.getText().toString().trim();
        String refundIntrestClaim = IntrestClaim.getText().toString().trim();
        String refundLateFeeClaim = LateFeeClaim.getText().toString().trim();

        period = PreferenceManager.getDefaultSharedPreferences(gstr4_forms.this).getString("year", null);

        try {
            if (!id.isEmpty()) {
                gstr4FormData data = new gstr4FormData(taxLiability, taxPaidthroughCash,
                        debitEntriesInCashIntegratedTax,
                        debitEntriesInCashCentralTax,
                        debitEntriesInCashStateTax, debitEntriesInCashCess,
                        refundClaimTotalTax, refundIntrestClaim,
                         refundLateFeeClaim);

                databaseUser.child(id).child("gstr4").child(period).child("form").setValue(data);
                Toast.makeText(gstr4_forms.this, "Your data saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,uploadPdf.class));
            }
        }
        catch (Exception e){
            Toast.makeText(gstr4_forms.this, " "+e ,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsubmit:
                saveDate();
        }
    }
}
