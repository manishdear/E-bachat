package com.wordpress.uniquecoder.hackathon;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;


public class Qrcode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        //Bitmap myBitmap=QRCode.from("www.studytutorial.in").bitmap();
        String client=client_details.clientData._client_name;
        String gstin=client_details.clientData._gstin;
        String billto=client_details.clientData._billto;
        String address=client_details.clientData._address;

        String cust=billform.custData.c_name;
        String c_gst=billform.custData.cust_gstin;
        String cd=billform.custData.c_date;
        String x=cust+"\n"+c_gst+"\n"+cd;
        VCard abhay=new VCard(client)
                .setAddress(address)
                .setTitle(""+gstin+"\n"+billto+"\n"+x)
                .setCompany(""+billform.custData.comp_name);

         Bitmap myBitmap=QRCode.from(abhay).bitmap();
        ImageView myImage=(ImageView) findViewById(R.id.imageView);
        myImage.setImageBitmap(myBitmap);


    }
}
