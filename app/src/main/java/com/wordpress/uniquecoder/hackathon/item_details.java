package com.wordpress.uniquecoder.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hendrix.pdfmyxml.PdfDocument;
import com.hendrix.pdfmyxml.viewRenderer.AbstractViewRenderer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class item_details extends AppCompatActivity {
    private static final String ROOT_URL = "http://ucdapeiron.heliohost.org/test/";
    public static final String GET_TAX_RATES = ROOT_URL+"findRate.php";
    public static GstRates gstRates;
    EditText iname,qty,rate,iunits,itotal,ihsn;
    TextView sgst,cgst;
    Button get_gst;
    items i;
    String s="",c="",desc="";
    ProgressBar progressBar;
    String hsn , itemName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        i=new items();
        setUIViews();
        progressBar = findViewById(R.id.progressBar);
//        gstRates=new GstRates(ihsn.getText().toString().trim());

        findViewById(R.id.fill).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                hsn = ihsn.getText().toString().trim();
                itemName = iname.getText().toString().trim();

                if (hsn.isEmpty()) {
                    ihsn.setError("hsn is required");
                    ihsn.requestFocus();
                    return;
                }

                if (itemName.isEmpty()) {
                    iname.setError("item name is requied is required");
                    iname.requestFocus();
                    return;
                }

                StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_TAX_RATES, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("error").equals("false")) {
                                s = jsonObject.getString("sgst");
                                c = jsonObject.getString("cgst");
                                desc = jsonObject.getString("description");
                            } else {
                                s = "" + 18;
                                c = "" + 18;
                                desc = "";
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("hsn_no", ihsn.getText().toString().trim());
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(item_details.this);
                requestQueue.add(stringRequest);

                cgst.setText("" + c);
                sgst.setText("" + s);
                Toast.makeText(getApplicationContext(), desc, Toast.LENGTH_SHORT).show();
//                if(!desc.equals(""))
//                {
//                    String temp  = iname.getText().toString().trim();
//                    if (!temp.equals(desc))
//                    {
//                        Toast.makeText(item_details.this,"Is hsn code provided by you is \n"+desc,Toast.LENGTH_LONG).show();
//                    }
//                }
                if (!((desc.isEmpty()) || (desc.equals("")))) {
                    iname.setText(desc);
                    iname.setEnabled(false);
                }
            }

        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void addItem(MenuItem item)
    {

    }

    public void setUIViews(){
        iname=findViewById(R.id.item_name);
        qty=findViewById(R.id.quantity);
        rate=findViewById(R.id.rate);
        cgst=findViewById(R.id.cg);
        sgst=findViewById(R.id.sg);
        iunits=findViewById(R.id.unt);
        itotal=findViewById(R.id.tot);
        ihsn=findViewById(R.id.hsnc);
        get_gst=findViewById(R.id.fill);
    }
    public void getData(){
        i.iname=iname.getText().toString().trim();
        i.qty  =  qty.getText().toString().trim();
        i.rate = rate .getText().toString().trim();
        i.cgst  =  cgst.getText().toString().trim();
        i.sgst  =  sgst.getText().toString().trim();
        i.totgst= ""+Integer.parseInt(cgst.toString().trim())+Integer.parseInt(sgst.toString().trim());
        i.units  =  iunits.getText().toString().trim();
        i.total  =  itotal.getText().toString().trim();
        i.hsn  =  ihsn.getText().toString().trim();
    }


    public void createInvoice(View view)
    {
        /*client_details.clientData;
        billform.custData;
        other_details.ot;
        i;*/
        try {

            AbstractViewRenderer page = new AbstractViewRenderer(this, R.layout.invoice_page) {
                private String _text;

                public void setText(String text) {
                    _text = text;
                }

                @Override
                protected void initView(View view) {

                    //Upper part of the invoice
                    TextView gstin=view.findViewById(R.id.zin_gstin);
                    gstin.setText(billform.custData.cust_gstin);

                    TextView name=view.findViewById(R.id.zname);
                    name.setText(billform.custData.c_name);

                    TextView in_gstin=view.findViewById(R.id.in_gst);
                    in_gstin.setText(billform.custData.cust_gstin);
                    /////////////////////////////////////////

                    TextView in_name,in_addr,in_con_gst,in_con_name,in_con_addr;

                    //Details of customer
                    in_name=view.findViewById(R.id.in_name);
                    in_name.setText(billform.custData.comp_name);

                    in_addr=view.findViewById(R.id.in_addr);
                    String in_address=""+billform.custData.addr+"\n"+billform.custData.city+"\n"+billform.custData.c_zip+"\n"+billform.custData.country;
                    in_addr.setText(in_address);

                    TextView zadr=view.findViewById(R.id.zaddress);
                    zadr.setText(in_address);

                    //in_gstin=view.findViewById(R.id.in_gst);
                    // gstin.setText(billform.custData.cust_gstin);
                    //////////////////////////////////////////

                    //Details of consignee
                    in_con_addr=view.findViewById(R.id.in_con_adr);
                    String con_address=""+client_details.clientData._address+"\n"+client_details.clientData._city+"\n"+client_details.clientData._zip+"\n"+ client_details.clientData._country;
                    in_con_addr.setText(con_address);

                    in_con_gst=view.findViewById(R.id.in_con_gst);
                    in_con_gst.setText(client_details.clientData._gstin);

                    in_con_name=view.findViewById(R.id.in_con_name);
                    in_con_name.setText(client_details.clientData._client_name);
                    ////////////////////////////////////////////
                    TextView i1,q1,r1,g1,tot;
                    //Fill table
                    i1=view.findViewById(R.id.i1);
                    i1.setText(iname.getText().toString().trim());

                    q1=view.findViewById(R.id.p1);
                    q1.setText(qty.getText().toString().trim());

                    r1=view.findViewById(R.id.r1);
                    r1.setText(rate.getText().toString().trim());

                    g1=view.findViewById(R.id.g1);
                    g1.setText(itotal.getText().toString().trim());

                }
            };

            // you can reuse the bitmap if you want
            page.setReuseBitmap(true);
            PdfDocument doc = new PdfDocument(this);

            // add as many pages as you have
            doc.addPage(page);

            doc.setRenderWidth(2115);
            doc.setRenderHeight(6000);
            doc.setOrientation(PdfDocument.A4_MODE.PORTRAIT);
//        doc.setProgressTitle(R.string.gen_please_wait);
//        doc.setProgressMessage(R.string.gen_pdf_file);
            doc.setFileName("test");
            doc.setSaveDirectory(this.getExternalFilesDir(null));
            doc.setInflateOnMainThread(false);
            doc.setListener(new PdfDocument.Callback() {
                @Override
                public void onComplete(File file) {
                    Log.i(PdfDocument.TAG_PDF_MY_XML, "Complete");
                }

                @Override
                public void onError(Exception e) {
                    Log.i(PdfDocument.TAG_PDF_MY_XML, "Error");
                }
            });
            doc.createPdf(this);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "hello"+e, Toast.LENGTH_SHORT).show();
        }

    }
}
