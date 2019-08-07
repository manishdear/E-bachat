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

public class gstr1_forms extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    DatabaseReference databaseUser;

    EditText i4Invoice, i4taxable, i4liablity;
    EditText i5incoice, i5taxable, i5liablity;
    EditText registeredtaxable, registredliability;
    EditText unregistredtaxable, unregisteredliability;
    EditText exportinvoice, exporttaxable, exportliability;
    EditText othertaxable, otherliability;
    EditText suppliesnill, suppliesexempted, suppliesnongst;
    EditText advancereceived, advanceliability;
    EditText adjustedandvance, adjustedliability;
    EditText hsninvoice, hsntaxable, hsnliability;
    EditText totaldoc, cancelleddoc, issueddoc;
    String id, period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstr1_forms);
        findViewById(R.id.btnsubmit).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        i4Invoice = findViewById(R.id.et4invoice);
        i4taxable = findViewById(R.id.et4taxable);
        i4liablity = findViewById(R.id.et4liability);
        i5incoice = findViewById(R.id.et5invoice);
        i5taxable = findViewById(R.id.et5taxable);
        i5liablity = findViewById(R.id.et5liability);
        registeredtaxable = findViewById(R.id.registeredTaxable);
        registredliability = findViewById(R.id.registerdLiability);
        unregistredtaxable = findViewById(R.id.unregisteredTaxable);
        unregisteredliability = findViewById(R.id.unregisteredLiability);
        exportinvoice = findViewById(R.id.exportInvoice);
        exporttaxable = findViewById(R.id.exportTaxable);
        exportliability = findViewById(R.id.exportLiability);
        othertaxable = findViewById(R.id.otherTaxable);
        otherliability = findViewById(R.id.otherLiability);
        suppliesnill = findViewById(R.id.suppliesNill);
        suppliesexempted = findViewById(R.id.suppliesExempted);
        suppliesnongst = findViewById(R.id.suppliesNonGst);
        advancereceived = findViewById(R.id.advanceReceived);
        advanceliability = findViewById(R.id.advanceLiability);
        adjustedandvance = findViewById(R.id.advanceAdjust);
        adjustedliability = findViewById(R.id.adjustmentLiability);
        hsninvoice = findViewById(R.id.hsnInvoice);
        hsntaxable = findViewById(R.id.hsnTaxable);
        hsnliability = findViewById(R.id.hsnLiability);
        totaldoc = findViewById(R.id.totalDoc);
        cancelleddoc = findViewById(R.id.cancelledDoc);
        issueddoc = findViewById(R.id.issuedDoc);
    }

    private void saveData() {

        id = PreferenceManager.getDefaultSharedPreferences(gstr1_forms.this).getString("gstid", null);

        String I4Invoice = i4Invoice.getText().toString().trim();
        String I4Taxable = i4taxable.getText().toString().trim();
        String I4Liability = i4liablity.getText().toString().trim();
        String I5Invoice = i5incoice.getText().toString().trim();
        String I5Taxable = i5taxable.getText().toString().trim();
        String I5Liability = i5liablity.getText().toString().trim();
        String RegisteredTaxable = registeredtaxable.getText().toString().trim();
        String RegisteredLiability = registredliability.getText().toString().trim();
        String UnregisteredTaxable = unregistredtaxable.getText().toString().trim();
        String UnregisteredLiability = unregisteredliability.getText().toString().trim();
        String ExportInvoice = exportinvoice.getText().toString().trim();
        String ExportTaxable = exporttaxable.getText().toString().trim();
        String ExportLiability = exportliability.getText().toString().trim();
        String OtherTaxable = othertaxable.getText().toString().trim();
        String OtherLiability = otherliability.getText().toString().trim();
        String SuppliesNill = suppliesnill.getText().toString().trim();
        String SuppliesExempted = suppliesexempted.getText().toString().trim();
        String SuppliesNon_gst = suppliesnongst.getText().toString().trim();
        String AdvancesReceived = advancereceived.getText().toString().trim();
        String AdvancesLiability = adjustedliability.getText().toString().trim();
        String AdvanceAdjusted = adjustedandvance.getText().toString().trim();
        String AdjustementLiability = adjustedliability.getText().toString().trim();
        String hsnInvoice = hsninvoice.getText().toString().trim();
        String hsnTaxable = hsntaxable.getText().toString().trim();
        String hsnLiability = hsnliability.getText().toString().trim();
        String DocumentTotal = totaldoc.getText().toString().trim();
        String DocumentCencelled = cancelleddoc.getText().toString().trim();
        String DocumentIssued = issueddoc.getText().toString().trim();

        period = PreferenceManager.getDefaultSharedPreferences(gstr1_forms.this).getString("year", null);

        try {
            if (!id.isEmpty()) {
                gstr1FormData form = new gstr1FormData(I4Invoice, I4Taxable, I4Liability,
                        I5Invoice,I5Taxable,  I5Liability,
                         RegisteredTaxable, RegisteredLiability,
                         UnregisteredTaxable,  UnregisteredLiability,
                        ExportInvoice, ExportTaxable, ExportLiability,
                        OtherTaxable, OtherLiability, SuppliesNill,
                        SuppliesExempted, SuppliesNon_gst, AdvancesReceived,
                        AdvancesLiability, AdvanceAdjusted, AdjustementLiability,
                        hsnInvoice, hsnTaxable,  hsnLiability,
                        DocumentTotal, DocumentCencelled, DocumentIssued);

                databaseUser.child(id).child("gstr1").child(period).child("form").setValue(form);
                Toast.makeText(gstr1_forms.this, "Your data saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,uploadPdf.class));
            }
        }
        catch (Exception e){
            Toast.makeText(gstr1_forms.this, ""+e ,Toast.LENGTH_SHORT).show();
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
